package net.idea.ambit.algorithm;

import java.io.File;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.Algorithm;
import ambit2.core.data.model.AlgorithmType;
import ambit2.core.data.model.ModelQueryResults;
import ambit2.rest.algorithm.AlgorithmListResource;
import ambit2.rest.algorithm.AlgorithmURIReporter;
import ambit2.rest.model.ModelURIReporter;
import ambit2.rest.task.CallableMockup;
import net.idea.ambit.app.HaaSApp;
import net.idea.ambit.model.ModelURIReporterHaas;
import net.idea.modbcum.i.IQueryRetrieval;
import net.idea.restnet.i.task.ICallableTask;

public class AlgorithmResourceHaas extends AlgorithmListResource {

	@Override
	protected ICallableTask createCallable(Form form, Algorithm<String> algorithm) throws ResourceException {

		return super.createCallable(form, algorithm);
	}

	@Override
	protected ICallableTask createCallable(Form form, Algorithm<String> algorithm,
			ModelURIReporter<IQueryRetrieval<ModelQueryResults>> modelReporter, AlgorithmURIReporter algReporter,
			Object token) throws ResourceException {

		if (algorithm.hasType(AlgorithmType.Mockup)) {
			return new CallableMockup(form, token);

		} else if (algorithm.hasType(AlgorithmType.ExternalModels)) {
			String tmpFolder = ((HaaSApp) getApplication()).getdHaasHome();
			//this is a hack to use different reporter class, which is not descending from  ambit2.rest.model.ModelURIReporter
			ModelURIReporterHaas modelReporterHaas = new ModelURIReporterHaas(getRequest());
			return new CallableHaas(form, algorithm, modelReporterHaas, algReporter, new File(tmpFolder), token);
		}
		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
	}

}
