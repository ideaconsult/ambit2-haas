package net.idea.ambit.algorithm;

import java.io.IOException;

import org.restlet.Context;
import org.restlet.Request;

import ambit2.core.data.model.Algorithm;
import ambit2.rest.algorithm.AlgorithmJSONReporter;

public class AlgorithmJSONReporterHaas extends AlgorithmJSONReporter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7995951460794582944L;

	public AlgorithmJSONReporterHaas(Request request, String jsonpcallback) {
		super(request, jsonpcallback);
	}

	@Override
	protected void item2json(Algorithm algorithm, String uri) throws IOException {
		super.item2json(algorithm, uri);
		try {
			output.write(",inputparam : null");
		} catch (IOException x) {
			Context.getCurrentLogger().severe(x.getMessage());
		}
	}
}
