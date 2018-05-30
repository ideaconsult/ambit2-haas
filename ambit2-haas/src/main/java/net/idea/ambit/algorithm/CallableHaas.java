package net.idea.ambit.algorithm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.Algorithm;
import ambit2.core.data.model.ModelQueryResults;
import ambit2.rest.OpenTox;
import ambit2.rest.algorithm.AlgorithmURIReporter;
import ambit2.rest.model.ModelURIReporter;
import ambit2.rest.task.CallableProtectedTask;
import ambit2.rest.task.TaskResult;
import cz.it4i.hpcaas.jobmgmt.JobSpecificationExt;
import cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt;
import net.idea.hpcaas.HPCWS;
import net.idea.modbcum.i.IQueryRetrieval;

public class CallableHaas<USERID> extends CallableProtectedTask<USERID> {
	protected long delay;
	protected Exception error;
	protected UUID uuid;
	protected ModelQueryResults model;
	protected ModelURIReporter<IQueryRetrieval<ModelQueryResults>> modelReporter;
	protected AlgorithmURIReporter algReporter;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public CallableHaas(Form form, Algorithm<String> algorithm,
			ModelURIReporter<IQueryRetrieval<ModelQueryResults>> modelReporter, AlgorithmURIReporter algReporter,
			USERID token) {
		super(token);
		try {
			this.delay = Long.parseLong(OpenTox.params.delay.getFirstValue(form).toString());
		} catch (Exception x) {
			this.delay = 30000;
		}

		model = new ModelQueryResults();
		model.setAlgorithm(algorithm.getName());
		try {
			model.setName(form.getFirstValue("name"));
		} catch (Exception x) {

		}

		if (model.getName() == null)
			model.setName("TestJob");

	}

	@Override
	public TaskResult doCall() throws Exception {

		Properties p = new Properties();
		try (InputStream in = HPCWS.class.getClassLoader()
				.getResourceAsStream("net/idea/ambit/hpcws/config/haas.properties")) {
			p.load(in);
		} catch (IOException x) {
			x.printStackTrace();
			System.exit(-1);
		}
		HPCWS hpcws = new HPCWS();
		hpcws.AuthenticateUserPassword();
		Thread.yield();
		File inputFile = new File("test_haas.txt");
		JobSpecificationExt testJob = hpcws.CreateJob(1L, model.getName(), "ExpTests", inputFile);
		SubmittedJobInfoExt submittedTestJob = hpcws.SubmitJob(testJob, inputFile);

		System.out.println(String.format("Submitted job ID %s.", submittedTestJob.getId()));
		try {
			SubmittedJobInfoExt job = hpcws.poll(submittedTestJob, delay);

			switch (job.getState()) {
			case FINISHED: {
				// hack for now
				model.setId(((Long) submittedTestJob.getId()).intValue());
				File file = hpcws.process(job);
				model.setContent(file.getAbsolutePath());
				try {
					String uri = modelReporter.getURI(model);
					return new TaskResult(uri);
				} catch (Exception x) {
					
				}
				return new TaskResult(file.toString());
			}
			case CANCELED: {
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Job cancelled %s", job.getId())));
			}
			case FAILED: {
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Job failed %s", job.getId())));
			}
			default: {
				throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,
						String.format(String.format("Should not  get here %s", job.getId())));
			}
			}
		} catch (Exception x) {
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,x.getMessage());

		}

	}
}