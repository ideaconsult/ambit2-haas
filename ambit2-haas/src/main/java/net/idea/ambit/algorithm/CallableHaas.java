package net.idea.ambit.algorithm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.xerces.impl.dv.util.Base64;
//import org.opentox.rest.RestException;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.Algorithm;
import ambit2.core.data.model.ModelQueryResults;
import ambit2.core.data.model.Parameter;
import ambit2.rest.OpenTox;
import ambit2.rest.algorithm.AlgorithmURIReporter;
import ambit2.rest.task.CallableProtectedTask;
import ambit2.rest.task.TaskResult;
import cz.it4i.hpcaas.jobmgmt.JobSpecificationExt;
import cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt;
import net.idea.ambit.algorithm.exnet.HEAPPE_ALGORITHMS;
import net.idea.ambit.model.ModelHaas;
import net.idea.ambit.model.ModelJSONReporter;
import net.idea.ambit.model.ModelResourceHaas;
import net.idea.ambit.model.ModelURIReporterHaas;
import net.idea.hpcaas.HPCWS;

public class CallableHaas<USERID> extends CallableProtectedTask<USERID> {

	protected Exception error;
	protected UUID uuid;
	protected ModelQueryResults model;
	protected ModelURIReporterHaas modelReporter;
	protected ModelJSONReporter modeljsonreporter;
	protected AlgorithmURIReporter algReporter;
	protected Algorithm algorithm;
	protected long delay;
	File resultFolder;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public CallableHaas(Form form, Algorithm<String> algorithm, ModelURIReporterHaas modelReporter,
			AlgorithmURIReporter algReporter, File resultFolder, USERID token) throws ResourceException {
		super(token);
		this.modelReporter = modelReporter;
		this.resultFolder = resultFolder;
		this.algorithm = algorithm;
		try {
			this.delay = Long.parseLong(OpenTox.params.delay.getFirstValue(form).toString());
		} catch (Exception x) {
			this.delay = 30000;
		}
		this.modeljsonreporter = new ModelJSONReporter(modelReporter.getResourceRef(), null);
		model = new ModelQueryResults();
		model.setAlgorithm(algorithm.getName());
		try {
			model.setName(form.getFirstValue("name"));
		} catch (Exception x) {

		}

		if (model.getName() == null)
			model.setName("TestJob");

	}

	protected SubmittedJobInfoExt createAndSubmitJob(Algorithm algorithm, HPCWS hpcws)
			throws ResourceException, IOException {
		JobSpecificationExt job = null;
		SubmittedJobInfoExt submittedjob = null;
		try {
			HEAPPE_ALGORITHMS heappe_alg = HEAPPE_ALGORITHMS.valueOf(algorithm.getId());
			File inputFile = heappe_alg.inputFile(algorithm);
			// File inputFile = heappe_alg.defaultInputFile(algorithm);
			job = heappe_alg.createJobSpec(model, hpcws, inputFile);
			if (job != null) {
				if (heappe_alg.jobSubmission()) {
					submittedjob = hpcws.SubmitJob(job, inputFile);
					submittedjob.getId();

				}
				try {
					File config = new File(String.format("%s/jobs/%d/config.json", resultFolder.getAbsoluteFile(),
							submittedjob == null ? 0 : submittedjob.getId()));
					if (!config.getParentFile().exists())
						config.getParentFile().mkdirs();
					FileUtils.copyFile(inputFile, config);
				} catch (Exception x) {
					logger.warning(x.getMessage());
				}
				return submittedjob;

			} else
				throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
		} catch (IllegalArgumentException x) {
			// i.e. not a listed algorithm
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
		} catch (IOException x) {
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY, x.getMessage(), x);
		} catch (ResourceException x) {
			throw x;
		}

	}

	protected void updateModel(ModelQueryResults model, Algorithm algorithm, SubmittedJobInfoExt submittedJob,
			String sessioncode) {
		model.setTrainingInstances("ExCAPEDBv5");
		model.setStars(1);
		model.setCreator("Heappe");

		HEAPPE_ALGORITHMS heappe_alg = HEAPPE_ALGORITHMS.valueOf(algorithm.getId());

		switch (heappe_alg) {
		case haasexnetstats: {
			if (algorithm.getParameters() != null)
				for (Object prm : algorithm.getParameters())
					if ((prm instanceof Parameter)
							&& (((Parameter) prm).getName() == OpenTox.params.model_uri.name())) {
						String[] path = ((Parameter) prm).getValue().toString().split("/");
						model.setId(Integer.parseInt(path[path.length - 1]));
						// model.setEvaluation(evaluation);
						break;
					}

			break;
		}
		default: {
			if (submittedJob == null) {
				model.setId(0);
			} else {
				model.setId(((Long) submittedJob.getId()).intValue());
			}

		}
		}

		model.setName(String.format("%s %d", heappe_alg.name(), model.getId()));
		model.setAlgorithm(String.format("%s/algorithm/%s", modelReporter.getResourceRef(), heappe_alg.name()));
		// model.setContent(String.format("%s/model/%s?media=%s",
		// modelReporter.getResourceRef(), model.getId(),
		// MediaType.APPLICATION_ZIP.getName()));
		try {
			Form form = serializeModel(model, sessioncode,algorithm.getId());
			model.setContent(form.getWebRepresentation().getText());
			model.setContentMediaType(MediaType.APPLICATION_JAVA.getName());
		} catch (Exception x) {
			model.setContent(Integer.toString(model.getId()));
			model.setContentMediaType(MediaType.TEXT_PLAIN.getName());
		}
		
	}

	private Form serializeModel(ModelQueryResults model, String sessioncode, String algorithm) throws IOException {
		
		ModelHaas mh= new ModelHaas();
		mh.setJobid(model.getId());
		mh.setAlgorithm(algorithm);
		mh.setSessioncode(sessioncode);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// serialize model
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(mh);
		oos.flush();
		oos.close();

		byte[] content = out.toByteArray();
		Form form = new Form();
		form.add("model", Base64.encode(content));
		return form;
	}

	@Override
	public TaskResult doCall() throws Exception {

		Properties p = new Properties();
		try (InputStream in = HPCWS.class.getClassLoader()
				.getResourceAsStream("net/idea/ambit/hpcws/config/haas.properties")) {
			p.load(in);
		} catch (IOException x) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, x.getMessage(), x);
		}

		HPCWS hpcws = null;
		try {
			hpcws = new HPCWS(resultFolder);
			// temp folder if not specified
			// hpcws = new HPCWS();
			hpcws.AuthenticateUserPassword();
		} catch (Exception x) {
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY, x.getMessage(), x);
		}

		Thread.yield();

		try {
			SubmittedJobInfoExt submittedTestJob = createAndSubmitJob(algorithm, hpcws);
			if (submittedTestJob == null) {
				// fake model for testing
				updateModel(model, algorithm, submittedTestJob, hpcws.getSessionCode());
				String uri = modelReporter.getURI(model);
				String resultsJsonPath = ModelResourceHaas.getModelPathJson(resultFolder, model);
				File modelfolder = new File(resultsJsonPath).getParentFile();
				if (!modelfolder.exists())
					modelfolder.mkdirs();
				try {
					saveModel(model, new File(resultsJsonPath));
				} catch (IOException x) {
					logger.log(Level.WARNING, String.format("Error writing model.json job %d", 0));
				}
				return new TaskResult(uri);
			}
			logger.log(Level.INFO, String.format("Submitted job ID %s.", submittedTestJob.getId()));
			SubmittedJobInfoExt job = hpcws.poll(submittedTestJob, delay);

			switch (job.getState()) {
			case FINISHED: {
				// TODO: This will be modified once the problem with storing
				// models and other
				// intermediate files in general on the cluster is solved.
				updateModel(model, algorithm, submittedTestJob, hpcws.getSessionCode());

				File file = hpcws.process(job);
				model.setContent(file.getAbsolutePath());
				try {
					String uri = modelReporter.getURI(model);
					// For now, we'll just serve the output files as a ZIP
					// archive.
					File resultsDir = hpcws.process(job);
					// name has to be job specific, otherwise will overwrite if
					// >1 job done
					// we return model URI, not path to files.
					// and the model resource will serve files under /model/{id}
					// ideally the model URI should be independent of job id,
					// but will do for now
					String resultsZipPath = ModelResourceHaas.getModelPathZip(resultFolder, model);

					File modelfolder = new File(resultsZipPath).getParentFile();
					if (!modelfolder.exists())
						modelfolder.mkdirs();
					try {
						String resultsJsonPath = ModelResourceHaas.getModelPathJson(resultFolder, model);
						saveModel(model, new File(resultsJsonPath));
					} catch (IOException x) {
						logger.log(Level.WARNING, String.format("Error writing model.json job %d", job.getId()));
					}
					try {
						if (!modelfolder.exists())
							modelfolder.mkdirs();
						zipFiles(resultsDir, resultsZipPath);
					} catch (IOException x) {
						logger.log(Level.WARNING, String.format("Error writing zip archive job %d", job.getId()));
					}
					return new TaskResult(uri);
				} catch (Exception x) {
					throw new ResourceException(Status.SERVER_ERROR_INTERNAL, x.getMessage(), x);
				}

			}
			case CANCELED: {
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Job cancelled %s", job.getId())));
			}
			case FAILED: {
				// to do download stdin/stderr even if failed
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Job failed %s", job.getId())));
			}
			default: {
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Should not  get here %s", job.getId())));
			}
			}
		} catch (ResourceException x) {
			throw x;
		} catch (Exception x) {
			logger.severe(x.getMessage());
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY, x.getMessage());

		}

	}

	protected void saveModel(ModelQueryResults model, File json) throws IOException {
		ModelJSONReporter jsonreporter = new ModelJSONReporter(modelReporter.getResourceRef(), null);
		try (FileWriter output = new FileWriter(json)) {
			jsonreporter.setOutput(output);
			jsonreporter.processItem(model, output);
		} catch (Exception x) {
		} finally {

		}
	}

	private static void zipFiles(File sourceDir, String zipFilePath) throws IOException {
		Files.deleteIfExists(Paths.get(zipFilePath));
		Path dpath = Files.createFile(Paths.get(zipFilePath));

		try (ZipOutputStream zstream = new ZipOutputStream(Files.newOutputStream(dpath))) {

			Path spath = sourceDir.toPath();
			Files.walk(spath).filter(path -> !Files.isDirectory(path)).forEach(path -> {
				ZipEntry zipEntry = new ZipEntry(spath.relativize(path).toString());
				try {
					zstream.putNextEntry(zipEntry);
					Files.copy(path, zstream);
					zstream.closeEntry();
				} catch (IOException x) {
					// this is effectively hiding the error
					x.printStackTrace();
				}
			});
		}
	}
}