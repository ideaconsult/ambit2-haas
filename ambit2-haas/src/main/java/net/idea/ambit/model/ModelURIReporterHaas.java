package net.idea.ambit.model;

import org.restlet.Request;

import ambit2.core.data.model.ModelQueryResults;
import ambit2.rest.reporters.CatalogURIReporter;

public class ModelURIReporterHaas extends CatalogURIReporter<ModelQueryResults> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7326614776271701463L;
	public ModelURIReporterHaas(Request baseRef) {
		super(baseRef);
	}
	@Override
	public String getURI(String ref, ModelQueryResults item) {
		return String.format("%s%smodel/%s", ref, "".equals(ref) ? "" : "/", item.getId());
	}

}
