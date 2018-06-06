package net.idea.ambit.algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.ModelQueryResults;
import ambit2.rest.algorithm.CatalogResource;
import ambit2.rest.algorithm.MLResources;
import net.idea.ambit.app.HaaSApp;

public class ModelResourceHaas extends CatalogResource<ModelQueryResults> {

	@Override
	protected Iterator<ModelQueryResults> createQuery(Context context, Request request, Response response)
			throws ResourceException {
		// extracts the id from /model{id}
		Object modelid = getRequest().getAttributes().get(MLResources.model_resourcekey);
		// if the {id} is null we have request to /model and we do not want to
		// list all available models at the moment
		// (do we ?)
		if (modelid == null)
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);

		// use only the id for model so far
		// ideally we would like to store and retrieve a bit more info about the
		// model,
		// e.g. as in MySQL based model storage in ambit
		ModelQueryResults model = new ModelQueryResults();
		model.setId(Integer.parseInt(modelid.toString()));

		String resultFolder = ((HaaSApp) getApplication()).getdHaasHome();
		File modelPath = new File(getModelPath(new File(resultFolder), model));
		//throw exceptions if the path to the zip files is not found 
		if (!modelPath.exists())
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
		
		ArrayList<ModelQueryResults> models = new ArrayList<ModelQueryResults>();
		models.add(model);
		return models.iterator();
	}

	public static String getModelPath(File resultFolder, ModelQueryResults model) {
		return String.format("%s/%d/job_results.zip", resultFolder.getAbsoluteFile(), model.getId());
	}

}
