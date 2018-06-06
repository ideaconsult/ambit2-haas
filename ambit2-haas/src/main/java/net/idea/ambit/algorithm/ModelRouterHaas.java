package net.idea.ambit.algorithm;

import org.restlet.Context;

import ambit2.rest.algorithm.MLResources;
import ambit2.rest.routers.MyRouter;

public class ModelRouterHaas  extends MyRouter {
	public ModelRouterHaas(Context context) {
		super(context);
		init();
	}
	protected void init() {
		attachDefault(ModelResourceHaas.class);
		attach(String.format("/{%s}",MLResources.model_resourcekey),ModelResourceHaas.class);
		/* model variables, skip for now
		attach(String.format("/{%s}%s",
				MLResources.model_resourcekey,
							PropertyModelResource.resourceID),
							PropertyModelResource.class);
							*/
	}
}