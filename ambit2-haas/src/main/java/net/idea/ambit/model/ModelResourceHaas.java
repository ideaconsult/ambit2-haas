package net.idea.ambit.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.ModelQueryResults;
import ambit2.rest.algorithm.CatalogResource;
import ambit2.rest.algorithm.MLResources;
import net.idea.ambit.app.HaaSApp;
import net.idea.modbcum.i.exceptions.AmbitException;
import net.idea.modbcum.i.processors.IProcessor;
import net.idea.restnet.c.StringConvertor;

public class ModelResourceHaas extends CatalogResource<ModelQueryResults> {
	public ModelResourceHaas() {
		super();
		setHtmlbyTemplate(true);
	}

	@Override
	public String getTemplateName() {
		return "model.ftl";
	}

	@Override
	protected void doInit() throws ResourceException {
		super.doInit();
		customizeVariants(new MediaType[] { MediaType.TEXT_URI_LIST, MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_JAVASCRIPT, MediaType.TEXT_HTML, MediaType.APPLICATION_ZIP });

	}

	@Override
	protected Iterator<ModelQueryResults> createQuery(Context context, Request request, Response response)
			throws ResourceException {
		// extracts the id from /model{id}
		Object modelkey = getRequest().getAttributes().get(MLResources.model_resourcekey);
		// if the {id} is null we have request to /model and we do not want to
		// list all available models at the moment
		// (do we ?)
		int modelid = -1;
		// returning not found instead of bad request, mostly to make the
		// rendering easier atm
		// but could be considered security feature ;)
		if (modelkey == null)
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
		try {
			modelid = Integer.parseInt(modelkey.toString());
		} catch (NumberFormatException x) {
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
		}
		// use only the id for model so far
		// ideally we would like to store and retrieve a bit more info about the
		// model,
		// e.g. as in MySQL based model storage in ambit
		ModelQueryResults model = new ModelQueryResults();
		model.setId(modelid);
		model.setName(String.format("Exnet model %d", modelid));
		model.setTrainingInstances("ExCAPEDBv5");
		model.setStars(1);
		model.setCreator("Heappe");
		model.setContent(String.format("%s/model/%s?media=%s", getRequest().getRootRef(), model.getId(),
				MediaType.APPLICATION_ZIP.getName()));
		model.setContentMediaType(MediaType.APPLICATION_ZIP.getName());

		if (modelid == 0)
			model.setAlgorithm(String.format("%s/algorithm/haasexnettest", getRequest().getRootRef()));
		else
			model.setAlgorithm(String.format("%s/algorithm/haasexnet", getRequest().getRootRef()));
		String resultFolder = ((HaaSApp) getApplication()).getdHaasHome();
		File modelPathJson = new File(getModelPathJson(new File(resultFolder), model));
		File modelPathZip = new File(getModelPathZip(new File(resultFolder), model));
		// throw exceptions if the path to the zip files is not found
		if (modelPathZip.exists() || modelPathJson.exists()) {
			ArrayList<ModelQueryResults> models = new ArrayList<ModelQueryResults>();
			models.add(model);
			return models.iterator();

		} else
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);

	}

	public static String getModelPathZip(File resultFolder, ModelQueryResults model) {
		return String.format("%s/models/%d/job_results.zip", resultFolder.getAbsoluteFile(), model.getId());
	}

	public static String getModelPathJson(File resultFolder, ModelQueryResults model) {
		return String.format("%s/models/%d/model.json", resultFolder.getAbsoluteFile(), model.getId());
	}

	@Override
	public IProcessor<Iterator<ModelQueryResults>, Representation> createConvertor(Variant variant)
			throws AmbitException, ResourceException {
		String filenamePrefix = getRequest().getResourceRef().getPath();

		if (variant.getMediaType().equals(MediaType.APPLICATION_JAVASCRIPT)) {
			Form params = getResourceRef(getRequest()).getQueryAsForm();
			String jsonpcallback = params.getFirstValue("jsonp");
			if (jsonpcallback == null)
				jsonpcallback = params.getFirstValue("callback");
			ModelJSONReporter r = new ModelJSONReporter(getRequest().getRootRef(), jsonpcallback);
			return new StringConvertor(r, MediaType.APPLICATION_JAVASCRIPT);
		} else if (variant.getMediaType().equals(MediaType.APPLICATION_ZIP)) {
			String resultFolder = ((HaaSApp) getApplication()).getdHaasHome();
			ModelFileReporter r = new ModelFileReporter(getRequest(), resultFolder, variant.getMediaType());
			return new DownloadConvertor(r, MediaType.APPLICATION_ZIP, ".zip");
		} else if (variant.getMediaType().equals(MediaType.TEXT_URI_LIST)) {
			ModelURIReporterHaas r = new ModelURIReporterHaas(getRequest());
			return new StringConvertor(r, MediaType.TEXT_PLAIN);

		} else {
			ModelJSONReporter r = new ModelJSONReporter(getRequest().getRootRef(), null);
			return new StringConvertor(r, MediaType.APPLICATION_JSON);
		}

	}

	@Override
	protected Representation post(Representation entity) throws ResourceException {
		throw new ResourceException(Status.SERVER_ERROR_NOT_IMPLEMENTED);
	}

	@Override
	protected Representation post(Representation entity, Variant variant) throws ResourceException {
		throw new ResourceException(Status.SERVER_ERROR_NOT_IMPLEMENTED);
	}

}
