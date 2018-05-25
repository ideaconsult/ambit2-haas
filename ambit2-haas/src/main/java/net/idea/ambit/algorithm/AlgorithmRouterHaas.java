package net.idea.ambit.algorithm;

import org.restlet.Context;

import ambit2.rest.algorithm.MLResources;
import ambit2.rest.routers.MyRouter;

/**
 * OpenTox Algorithms /algorithm
 */
public class AlgorithmRouterHaas extends MyRouter {

	public AlgorithmRouterHaas(Context context) {
		super(context);

		attachDefault(AlgorithmResourceHaas.class);
		attach(String.format("/{%s}", MLResources.algorithmKey), AlgorithmResourceHaas.class);
		attach(String.format("/{%s}/{%s}", MLResources.algorithmKey, AlgorithmResourceHaas._param.level0.name()),
				AlgorithmResourceHaas.class);
		attach(String.format("/{%s}/{%s}/{%s}", MLResources.algorithmKey, AlgorithmResourceHaas._param.level0.name(),
				AlgorithmResourceHaas._param.level1.name()), AlgorithmResourceHaas.class);
		attach(String.format("/{%s}/{%s}/{%s}/{%s}", MLResources.algorithmKey,
				AlgorithmResourceHaas._param.level0.name(), AlgorithmResourceHaas._param.level1.name(),
				AlgorithmResourceHaas._param.level2.name()), AlgorithmResourceHaas.class);

	}
}
