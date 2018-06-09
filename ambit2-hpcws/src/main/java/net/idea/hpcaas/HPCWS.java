package net.idea.hpcaas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import cz.it4i.hpcaas.clusterinfo.ClusterInformationWs;
import cz.it4i.hpcaas.filetransfer.ArrayOfJobFileContentExt;
import cz.it4i.hpcaas.filetransfer.ArrayOfTaskFileOffsetExt;
import cz.it4i.hpcaas.filetransfer.FileTransferMethodExt;
import cz.it4i.hpcaas.filetransfer.FileTransferWs;
import cz.it4i.hpcaas.filetransfer.JobFileContentExt;
import cz.it4i.hpcaas.filetransfer.SynchronizableFilesExt;
import cz.it4i.hpcaas.filetransfer.TaskFileOffsetExt;
import cz.it4i.hpcaas.jobmgmt.ArrayOfCommandTemplateParameterValueExt;
import cz.it4i.hpcaas.jobmgmt.ArrayOfTaskSpecificationExt;
import cz.it4i.hpcaas.jobmgmt.CommandTemplateParameterValueExt;
import cz.it4i.hpcaas.jobmgmt.JobManagementWs;
import cz.it4i.hpcaas.jobmgmt.JobPriorityExt;
import cz.it4i.hpcaas.jobmgmt.JobSpecificationExt;
import cz.it4i.hpcaas.jobmgmt.JobStateExt;
import cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt;
import cz.it4i.hpcaas.jobmgmt.SubmittedTaskInfoExt;
import cz.it4i.hpcaas.jobmgmt.TaskSpecificationExt;
import cz.it4i.hpcaas.jobreporting.JobReportingWs;
import cz.it4i.hpcaas.usermgmgmt.PasswordCredentialsExt;
import cz.it4i.hpcaas.usermgmgmt.UserAndLimitationManagementWs;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.xfer.FileSystemFile;

public class HPCWS {
	protected ClusterInformationWs wsClusterInformation = new ClusterInformationWs();
	protected FileTransferWs wsFileTransfer = new FileTransferWs();
	protected JobManagementWs wsJobManagement = new JobManagementWs();
	protected JobReportingWs wsJobReporting = new JobReportingWs();
	protected UserAndLimitationManagementWs wsUserAndLimitationManagement = new UserAndLimitationManagementWs();
	protected String sessionCode; // code acquired via authentication
	protected Properties p;
	protected File resultFolder;
	final static Logger logger = Logger.getLogger(HPCWS.class.getName());

	public HPCWS() throws IOException {
		this(getTempDir());
	}

	public HPCWS(File resultFolder) throws IOException {
		super();
		this.resultFolder = resultFolder;
		p = new Properties();
		try (InputStream in = HPCWS.class.getClassLoader()
				.getResourceAsStream("net/idea/ambit/hpcws/config/haas.properties")) {
			p.load(in);
		}
	}

	public static void main(String[] args) {

		try {
			HPCWS hpcws = new HPCWS();

			hpcws.AuthenticateUserPassword();
			File inputFile = new File("test_haas.txt");
			JobSpecificationExt testJob = hpcws.CreateJobExample("TestJob", inputFile);
			SubmittedJobInfoExt submittedTestJob = hpcws.SubmitJob(testJob, inputFile);
			logger.info(String.format("\nSubmitted job ID %s.\n", submittedTestJob.getId()));
			SubmittedJobInfoExt job = hpcws.poll(submittedTestJob, 30000);
			File tempDirJob = hpcws.process(job);
			logger.fine(tempDirJob.getAbsolutePath());
		} catch (IOException x) {
			logger.severe(x.getMessage());
		}
	}

	public void AuthenticateUserPassword() {

		PasswordCredentialsExt credentials = new PasswordCredentialsExt();
		credentials.setUsername(p.getProperty("haas.user"));
		credentials.setPassword(p.getProperty("haas.pwd"));
		logger.fine(String.format("\nAuthenticating user [%s]...\n", credentials.getUsername()));
		sessionCode = wsUserAndLimitationManagement.getUserAndLimitationManagementWsSoap()
				.authenticateUserPassword(credentials);

	}

	public JobSpecificationExt CreateJobExample(String taskname, File inputFile) {
		return CreateJob(1L, taskname, "ExpTests", inputFile);
	}

	public JobSpecificationExt CreateJobExnetBuild(String taskname, File inputFile) {
		return CreateJob(2L, taskname, "ExpTests", inputFile);
	}

	public JobSpecificationExt CreateJob(long commandTemplateID, String taskname, String project, File inputfile) {
		// each submitted job must contain at least one task
		TaskSpecificationExt testTask = new TaskSpecificationExt();
		testTask.setName(taskname);
		testTask.setMinCores(24); // minimum number of cores required
		testTask.setMaxCores(24); // maximum number of cores required
		testTask.setWalltimeLimit(3600); // maximum time for task to run
											// (seconds)
		testTask.setStandardOutputFile("stdout.txt");
		testTask.setStandardErrorFile("stderr.txt");
		testTask.setProgressFile("progress.txt");
		testTask.setLogFile("log.txt");
		testTask.setCommandTemplateId(commandTemplateID); // commandTemplateID
		// custom environment variables for the task
		// testTask.setEnvironmentVariables(new EnvironmentVariableExt[0]);
		// fill the command template parameters (see Table1 for “inputParam”)
		ArrayOfCommandTemplateParameterValueExt a = new ArrayOfCommandTemplateParameterValueExt();
		CommandTemplateParameterValueExt pv = new CommandTemplateParameterValueExt();
		pv.setCommandParameterIdentifier("configFile");
		pv.setParameterValue("config.json");
		a.getCommandTemplateParameterValueExt().add(pv);
		testTask.setTemplateParameterValues(a);
		testTask.setClusterTaskSubdirectory(null);
		testTask.setIsExclusive(null);
		testTask.setIsRerunnable(null);
		testTask.setRequiredNodes(null);
		testTask.setStandardInputFile(null);

		// create job specification with the task above
		JobSpecificationExt testJob = new JobSpecificationExt();
		testJob.setName(taskname); // job name
		testJob.setMinCores(24); // minimum number of cores required
		testJob.setMaxCores(24); // maximum number of cores required
		testJob.setPriority(JobPriorityExt.AVERAGE);
		testJob.setProject(project); // accounting project
		testJob.setWaitingLimit(null); // limit for the waiting time in cluster
										// queue
		testJob.setWalltimeLimit(3600); // maximum time for job to run (seconds)
		testJob.setClusterNodeTypeId(7L); // Salomon express queue (1h limit)
		// custom environment variables for the job
		// testJob.environmentVariables = new EnvironmentVariableExt[0];
		// assign created task to job specification
		ArrayOfTaskSpecificationExt tasks = new ArrayOfTaskSpecificationExt();
		tasks.getTaskSpecificationExt().add(testTask);
		testJob.setTasks(tasks);
		testJob.setNotificationEmail("support@ideaconsult.net");
		testJob.setNotifyOnAbort(false);
		testJob.setNotifyOnFinish(false);
		testJob.setNotifyOnStart(false);
		testJob.setPhoneNumber("000111222");
		return testJob;
	}

	public SubmittedJobInfoExt SubmitJob(JobSpecificationExt testJob, File inputfile) throws IOException {
		// create job
		SubmittedJobInfoExt submittedTestJob = wsJobManagement.getJobManagementWsSoap().createJob(testJob, sessionCode);
		logger.info(String.format("\nCreated job ID %s.\n", submittedTestJob.getId()));

		// upload input files
		FileTransferMethodExt ft = wsFileTransfer.getFileTransferWsSoap()
				.getFileTransferMethod(submittedTestJob.getId(), sessionCode);
		File tempDirJob = getJobFolder(submittedTestJob.getId());
		tempDirJob.mkdirs();
		File privatekey = storeMetadata(ft, tempDirJob);
		// TODO: We should fail gracefully if inputfile doesn't exist,
		// instead of just ignoring the issue.
		// if (inputfile != null && inputfile.exists())
		try (SSHClient ssh = new SSHClient()) {
			// TODO: MD5 fingerprints are insecure. Best to import the server's
			// public key as already implemented in the Python Jupyter notebook.
			ssh.addHostKeyVerifier("70:01:c9:9a:5d:88:91:c7:1b:c0:84:d1:fa:4e:83:5c");
			ssh.connect(ft.getServerHostname());
			ssh.authPublickey(ft.getCredentials().getUsername(), privatekey.getAbsolutePath());
			ssh.newSCPFileTransfer().upload(inputfile.getAbsolutePath(), ft.getSharedBasepath());
			ssh.disconnect();
		} catch (IOException x) {
			throw x;
		} finally {

		}
		wsFileTransfer.getFileTransferWsSoap().endFileTransfer(submittedTestJob.getId(), ft, sessionCode);

		// submit the job to a cluster queue for processing

		submittedTestJob = wsJobManagement.getJobManagementWsSoap().submitJob(submittedTestJob.getId(), sessionCode);
		return submittedTestJob;

	}

	public SubmittedJobInfoExt poll(SubmittedJobInfoExt submittedTestJob, long delay) {
		// check status of running job (submitted/configuring/queued/running)
		SubmittedJobInfoExt submittedJob;
		long jobId = submittedTestJob.getId();
		while (true)
			try {
				// wait 30s before the next status check
				Thread.yield();
				Thread.sleep(delay);
				// get info for the job
				submittedJob = checkstatus(jobId);
				logger.fine(String.format("\nSubmitted job state %s.\n", submittedJob.getState()));
				if (submittedJob.getState() == JobStateExt.SUBMITTED
						|| submittedJob.getState() == JobStateExt.CONFIGURING
						|| submittedJob.getState() == JobStateExt.QUEUED
						|| submittedJob.getState() == JobStateExt.RUNNING)
					continue;
				else
					break;
			} catch (Exception x) {
				logger.severe(x.getMessage());
				break;

			} finally {

			}

		// job computation is done (finished/failed/canceled)
		return wsJobManagement.getJobManagementWsSoap().getCurrentInfoForJob(jobId, sessionCode);
	}

	public SubmittedJobInfoExt checkstatus(long jobId) {
		SubmittedJobInfoExt submittedJob = wsJobManagement.getJobManagementWsSoap().getCurrentInfoForJob(jobId,
				sessionCode);

		// set offsets for the stdout, stderr, stdprog, stdlog files
		// offsets can be used for the partial download of files
		ArrayOfTaskFileOffsetExt aofsets = new ArrayOfTaskFileOffsetExt();
		List<TaskFileOffsetExt> offsets = aofsets.getTaskFileOffsetExt();
		for (SubmittedTaskInfoExt taskInfo : submittedJob.getTasks().getSubmittedTaskInfoExt()) {
			TaskFileOffsetExt off = new TaskFileOffsetExt();
			off.setFileType(SynchronizableFilesExt.LOG_FILE);
			off.setSubmittedTaskInfoId(taskInfo.getId());
			off.setOffset(0L);
			offsets.add(off);

			off = new TaskFileOffsetExt();
			off.setFileType(SynchronizableFilesExt.PROGRESS_FILE);
			off.setSubmittedTaskInfoId(taskInfo.getId());
			off.setOffset(0L);
			offsets.add(off);

			off = new TaskFileOffsetExt();
			off.setFileType(SynchronizableFilesExt.STANDARD_ERROR_FILE);
			off.setSubmittedTaskInfoId(taskInfo.getId());
			off.setOffset(0L);
			offsets.add(off);

			off = new TaskFileOffsetExt();
			off.setFileType(SynchronizableFilesExt.STANDARD_OUTPUT_FILE);
			off.setSubmittedTaskInfoId(taskInfo.getId());
			off.setOffset(0L);
			offsets.add(off);
		}

		// donwload stdouts based on the offsets
		try {
			logger.fine(
					wsFileTransfer.getFileTransferWsSoap().getFileTransferMethod(jobId, sessionCode).getProtocol().name());
			ArrayOfJobFileContentExt result = wsFileTransfer.getFileTransferWsSoap()
					.downloadPartsOfJobFilesFromCluster(jobId, aofsets, sessionCode);

			for (JobFileContentExt file : result.getJobFileContentExt()) {
				logger.fine(String.format("File: %s, %s ", file.getFileType(), file.getRelativePath()));
				logger.fine(String.format("TaskInfoId: ", file.getSubmittedTaskInfoId()));
				logger.fine(String.format("Offset: ", file.getOffset()));
				logger.fine(String.format("Content: %s", file.getContent()));

			}
		} catch (Exception x) {
			logger.warning(x.getMessage());
		}
		return submittedJob;
	}

	protected static File getTempDir() {
		return new File(String.format("%s/haas", System.getProperty("java.io.tmpdir")));
	}

	protected File getJobFolder(long jobId) {
		return new File(String.format("%s/%d", resultFolder.getAbsoluteFile(), jobId));
		// return new File(String.format("%s/%d", getTempDir(), jobId));
	}

	protected File storeMetadata(FileTransferMethodExt ft, File tempDirJob) throws IOException {
		File properties = new File(tempDirJob, "haas.properties");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(properties))) {
			w.write(String.format("username=%s\n", ft.getCredentials().getUsername()));
			w.write(String.format("sharedBasepath=%s\n", ft.getSharedBasepath()));
		} catch (Exception x) {
			throw x;
		}
		File privatekey = new File(tempDirJob, "haas.private.key");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(privatekey))) {
			w.write(ft.getCredentials().getPrivateKey());
		} catch (IOException x) {
			throw x;
		}
		File publickey = new File(tempDirJob, "haas.public.key");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(publickey))) {
			w.write(ft.getCredentials().getPublicKey());
		} catch (IOException x) {
			throw x;
		}
		return privatekey;
	}

	public File process(SubmittedJobInfoExt submittedJob) throws IOException {
		File tempDirJob = getJobFolder(submittedJob.getId());
		tempDirJob.mkdirs();
		// job finished successfully, download result files from the cluster
		if (submittedJob.getState() == JobStateExt.FINISHED) {
			String[] changedFiles = wsFileTransfer.getFileTransferWsSoap()
					.listChangedFilesForJob(submittedJob.getId(), sessionCode).getString().toArray(new String[0]);

			FileTransferMethodExt ft2 = wsFileTransfer.getFileTransferWsSoap()
					.getFileTransferMethod(submittedJob.getId(), sessionCode);

			File privatekey = storeMetadata(ft2, tempDirJob);

			try (SSHClient ssh = new SSHClient()) {
				// TODO: MD5 fingerprints are insecure. Best to import the
				// server's
				// public key as already implemented in the Python Jupyter
				// notebook.
				ssh.addHostKeyVerifier("70:01:c9:9a:5d:88:91:c7:1b:c0:84:d1:fa:4e:83:5c");
				ssh.connect(ft2.getServerHostname());
				ssh.authPublickey(ft2.getCredentials().getUsername(), privatekey.getAbsolutePath());

				FileSystemFile destDir = new FileSystemFile(tempDirJob);

				for (String changedFile : changedFiles) {
					try {
						ssh.newSCPFileTransfer().download(String.format("%s/%s",ft2.getSharedBasepath(), changedFile), destDir);

						logger.info(String.format("File %s downloaded.",changedFile));
					} catch (IOException x) {
						logger.warning(x.getMessage());
					}
				}
				ssh.disconnect();
			} catch (IOException x) {
				throw x;
			} finally {

			}
			wsFileTransfer.getFileTransferWsSoap().endFileTransfer(submittedJob.getId(), ft2, sessionCode);
		}
		// job failed or was canceled
		else if (submittedJob.getState() == JobStateExt.FAILED || submittedJob.getState() == JobStateExt.CANCELED) {
			// do nothing

		}
		return tempDirJob;
	}
}
