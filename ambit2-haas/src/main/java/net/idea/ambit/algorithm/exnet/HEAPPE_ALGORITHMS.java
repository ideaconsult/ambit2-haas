package net.idea.ambit.algorithm.exnet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ambit2.core.data.model.Algorithm;
import ambit2.core.data.model.ModelQueryResults;
import ambit2.core.data.model.Parameter;
import ambit2.rest.OpenTox;
import cz.it4i.hpcaas.jobmgmt.JobSpecificationExt;
import net.idea.hpcaas.HPCWS;

public enum HEAPPE_ALGORITHMS {

	haasexample {

		@Override
		public int getTemplateID() {
			return 1;
		}
	},
	haasexnet {
		@Override
		public int getTemplateID() {
			return 2;
		}

		public Algorithm parseForm(Form form, Algorithm algorithm) throws ResourceException {
			File file = defaultInputFile(algorithm);
			ObjectMapper mapper = new ObjectMapper();
			try {
				ExnetParam exnetParams = mapper.readValue(file, ExnetParam.class);

				JsonNode top = mapper.readTree(file);
				Iterator<String> keys = top.fieldNames();
				while (keys.hasNext()) {
					String key = keys.next();
					String value = form.getFirstValue(key);
					if (value != null && !"".equals(value))
						try {
							String methodName = "get" + WordUtils.capitalize(key);
							Method method = exnetParams.getClass().getMethod(methodName);
							Object v = method.invoke(exnetParams);

							methodName = "set" + WordUtils.capitalize(key);
							if (v instanceof Integer) {
								method = exnetParams.getClass().getMethod(methodName, Integer.class);
								method.invoke(exnetParams, Integer.parseInt(value));
							} else if (v instanceof Integer[]) {
								Integer[] dvalues = parseIntArrayValue(value);
								method = exnetParams.getClass().getMethod(methodName, dvalues.getClass());
								method.invoke(exnetParams, new Object[] { dvalues });
							} else if (v instanceof Double[]) {
								Double[] dvalues = parseDoubleArrayValue(value);
								method = exnetParams.getClass().getMethod(methodName, dvalues.getClass());
								method.invoke(exnetParams, new Object[] { dvalues });
							} else if (v instanceof Integer[][]) {
								String[] values = form.getValuesArray(key);
								int n = 0;
								for (String vv : values)
									if (vv != null && !"".equals(vv))
										n++;
								Integer[][] nets = new Integer[n][];
								n = 0;
								for (int i = 0; i < values.length; i++)
									if (values[i] != null && !"".equals(values[i])) {
										nets[n] = parseIntArrayValue(values[i]);
										n++;
									}
								method = exnetParams.getClass().getMethod(methodName, nets.getClass());
								method.invoke(exnetParams, new Object[] { nets });
							} // else
								// ignore

						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
				}
				List<Parameter> prms = new ArrayList<Parameter>();
				prms.add(new Parameter("config", exnetParams));
				algorithm.setParameters(prms);
				return algorithm;
			} catch (JsonMappingException x) {
				throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
			} catch (JsonParseException x) {
				throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
			} catch (IOException x) {
				throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
			}
		}

		public File inputFile(Algorithm algorithm) {
			if (algorithm.getParameters() != null)
				for (Object prm : algorithm.getParameters())
					if ((prm instanceof Parameter) && (((Parameter) prm).getName() == "config"))
						try {
							ExnetParam exnetParams = (ExnetParam) ((Parameter) prm).getValue();
							ObjectMapper mapper = new ObjectMapper();
							File tempConfig = File.createTempFile(HPCWS.getTempDir().getAbsolutePath() + "/config",
									".json");
							mapper.writeValue(tempConfig, exnetParams);
							return tempConfig;
						} catch (Exception x) {

						}
			return defaultInputFile(algorithm);

		}
	},
	haasexnettest {

		@Override
		public int getTemplateID() {
			return 2;
		}

		@Override
		public Algorithm parseForm(Form form, Algorithm algorithm) throws ResourceException {
			return haasexnet.parseForm(form, algorithm);
		}

		@Override
		public File inputFile(Algorithm algorithm) {
			return haasexnet.inputFile(algorithm);
		}

		@Override
		public File defaultInputFile(Algorithm algorithm) {
			return haasexnet.defaultInputFile(algorithm);
		}

		@Override
		public boolean jobSubmission() {
			return false;
		}
	},
	haasexnetstats {

		@Override
		public File defaultInputFile(Algorithm algorithm) {
			return null;
		}

		@Override
		public int getTemplateID() {
			return 3;
		}

		@Override
		public Algorithm parseForm(Form form, Algorithm algorithm) throws ResourceException {
			String model_uri = form.getFirstValue(OpenTox.params.model_uri.name());
			if (model_uri == null || "".equals(model_uri)) throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
			List<Parameter> prms = new ArrayList<Parameter>();
			prms.add(new Parameter(OpenTox.params.model_uri.name(), model_uri));
			algorithm.setParameters(prms);
			return algorithm;
		}
		@Override
		public boolean jobSubmission() {
			// for testing purposes untill the file sharing is resolved
			return false;
		}
	};

	public abstract int getTemplateID();

	public File defaultInputFile(Algorithm algorithm) {
		try {
			return new File(this.getClass().getClassLoader()
					.getResource(String.format("haas/input/template%d/config.json", getTemplateID())).toURI());
		} catch (URISyntaxException e) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
		}
	}

	public File inputFile(Algorithm algorithm) {
		return defaultInputFile(algorithm);
	}

	public boolean jobSubmission() {
		return true;
	}

	public JobSpecificationExt createJobSpec(ModelQueryResults model, HPCWS hpcws, File inputFile)
			throws ResourceException {
		try {
			return hpcws.CreateJob(getTemplateID(), model.getName(), "ExpTests", inputFile);
		} catch (Exception e) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
		}
	}

	public Algorithm parseForm(Form form, Algorithm algorithm) throws ResourceException {
		return algorithm;
	}

	protected Integer[] parseIntArrayValue(String value) {
		String[] values = value.split(",");
		Integer[] dvalues = new Integer[values.length];
		for (int i = 0; i < values.length; i++)
			dvalues[i] = Integer.parseInt(values[i].trim());
		return dvalues;
	}

	protected Double[] parseDoubleArrayValue(String value) {
		String[] values = value.split(",");
		Double[] dvalues = new Double[values.length];
		for (int i = 0; i < values.length; i++)
			dvalues[i] = Double.parseDouble(values[i].trim());
		return dvalues;
	}
}