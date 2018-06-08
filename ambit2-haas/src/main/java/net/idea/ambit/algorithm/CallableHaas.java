package net.idea.ambit.algorithm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openscience.cdk.io.formats.ZindoFormat;
//import org.opentox.rest.RestException;
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
import net.idea.ambit.model.ModelResourceHaas;
import net.idea.hpcaas.HPCWS;
import net.idea.modbcum.i.IQueryRetrieval;

public class CallableHaas<USERID> extends CallableProtectedTask<USERID> {

	protected Exception error;
	protected UUID uuid;
	protected ModelQueryResults model;
	protected ModelURIReporter<IQueryRetrieval<ModelQueryResults>> modelReporter;
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

	public CallableHaas(Form form, Algorithm<String> algorithm,
			ModelURIReporter<IQueryRetrieval<ModelQueryResults>> modelReporter, AlgorithmURIReporter algReporter,
			File resultFolder,
			USERID token) {
		super(token);
		this.modelReporter = modelReporter;
		this.resultFolder = resultFolder;
		this.algorithm = algorithm;
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
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL,x.getMessage(),x);
		}
		
		HPCWS hpcws = null;
		try {
			//hpcws = new HPCWS(resultFolder);
			//temp folder if not specified
			hpcws = new HPCWS();
			hpcws.AuthenticateUserPassword();
		} catch (Exception x) {
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY,x.getMessage(),x);
		}
		
		
		
		Thread.yield();

		JobSpecificationExt testJob = null;
		File inputFile = null;
		if (algorithm.getId().equals("haasexample")) {
			inputFile = new File("test_haas.txt");
			testJob = hpcws.CreateJob(1L, model.getName(), "ExpTests", inputFile);
		} else if (algorithm.getId().equals("haasexnet")) {
			inputFile = new File(this.getClass().getClassLoader().getResource("haas/examples/config.json").toURI());
			testJob = hpcws.CreateJob(2L, model.getName(), "ExpTests", inputFile);
		} else
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);

		SubmittedJobInfoExt submittedTestJob = hpcws.SubmitJob(testJob, inputFile);

		logger.log(Level.INFO,String.format("Submitted job ID %s.", submittedTestJob.getId()));
		try {
			SubmittedJobInfoExt job = hpcws.poll(submittedTestJob, delay);

			switch (job.getState()) {
			case FINISHED: {
				// TODO: This will be finished once the problem with storing models and other
				// intermediate files in general on the cluster is solved.
				
				model.setId(((Long) submittedTestJob.getId()).intValue());
				File file = hpcws.process(job);
				model.setContent(file.getAbsolutePath());
				try {
					String uri = modelReporter.getURI(model);
					// For now, we'll just serve the output files as a ZIP archive.
					File resultsDir = hpcws.process(job);
					//name has to be job specific, otherwise will overwrite if >1 job done
					//we return model URI, not path to files.
					// and the model resource will serve files under /model/{id} 
					//ideally the model URI should be independent of job id, but will do for now
					String resultsZipPath = ModelResourceHaas.getModelPath(resultFolder,model);
					File modelfolder = new File(resultsZipPath).getParentFile();
					try {
						if (!modelfolder.exists()) modelfolder.mkdirs();
						zipFiles(resultsDir, resultsZipPath);
					} catch (IOException x) {
						throw new ResourceException(Status.SERVER_ERROR_INTERNAL,"Error creating zip archive",x);	
					}
					
					return new TaskResult(uri);
				} catch (Exception x) {
					throw new ResourceException(Status.SERVER_ERROR_INTERNAL,x.getMessage(),x);
				}
				
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
			throw new ResourceException(Status.SERVER_ERROR_BAD_GATEWAY, x.getMessage());

		}

	}

	private static void zipFiles(File sourceDir, String zipFilePath) throws IOException {
		Files.deleteIfExists(Paths.get(zipFilePath));
		Path dpath = Files.createFile(Paths.get(zipFilePath));
		
		try (ZipOutputStream zstream = new ZipOutputStream(Files.newOutputStream(dpath))) {
			
			Path spath = sourceDir.toPath();
			Files.walk(spath)
					.filter(path -> !Files.isDirectory(path))
					.forEach(path -> {
						ZipEntry zipEntry = new ZipEntry(spath.relativize(path).toString());
						try {
							zstream.putNextEntry(zipEntry);
							Files.copy(path, zstream);
							zstream.closeEntry();
						} catch (IOException x) {
							//this is effectively hiding the error
							x.printStackTrace();
						}
					});
		} 
	}
}