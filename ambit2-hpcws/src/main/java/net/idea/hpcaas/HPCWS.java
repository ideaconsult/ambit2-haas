package net.idea.hpcaas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

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

	public HPCWS() {
		super();
		p = new Properties();
		try (InputStream in = HPCWS.class.getClassLoader()
				.getResourceAsStream("net/idea/ambit/hpcws/config/haas.properties")) {
			p.load(in);
		} catch (IOException x) {
			x.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {

		HPCWS hpcws = new HPCWS();
		
		hpcws.AuthenticateUserPassword();
		File inputFile = new File("test_haas.txt");
		JobSpecificationExt testJob = hpcws.CreateJobExample("TestJob", inputFile);
		SubmittedJobInfoExt submittedTestJob = hpcws.SubmitJob(testJob,inputFile);
		System.out.println(String.format("Submitted job ID %s.", submittedTestJob.getId()));
		SubmittedJobInfoExt job = hpcws.poll(submittedTestJob, 30000);
		File tempDirJob = hpcws.process(job);
		System.out.println(tempDirJob);
	}

	public void AuthenticateUserPassword() {
		System.out.println(p);
		PasswordCredentialsExt credentials = new PasswordCredentialsExt();
		credentials.setUsername(p.getProperty("haas.user"));
		credentials.setPassword(p.getProperty("haas.pwd"));
		System.out.println(String.format("Authenticating user [%s]...", credentials.getUsername()));
		sessionCode = wsUserAndLimitationManagement.getUserAndLimitationManagementWsSoap()
				.authenticateUserPassword(credentials);

	}

	public JobSpecificationExt CreateJobExample(String taskname,File inputFile) {
		return CreateJob(1L,taskname, "ExpTests", inputFile);
	}

	public JobSpecificationExt CreateJobExnetBuild(String taskname, File inputFile) {
		return CreateJob(2L,taskname, "ExpTests", inputFile);
	}
	public JobSpecificationExt CreateJob(long commandTemplateID, String taskname, String project, File inputfile) {
		// each submitted job must contain at least one task
		TaskSpecificationExt testTask = new TaskSpecificationExt();
		testTask.setName(taskname);
		testTask.setMinCores(1); // minimum number of cores required
		testTask.setMaxCores(1); // maximum number of cores required
		testTask.setWalltimeLimit(600); // maximum time for task to run
										// (seconds)
		testTask.setStandardOutputFile("console_Stdout");
		testTask.setStandardErrorFile("console_Stderr");
		testTask.setProgressFile("console_Stdprog");
		testTask.setLogFile("console_Stdlog");
		testTask.setCommandTemplateId(commandTemplateID); // commandTemplateID
		// custom environment variables for the task
		// testTask.setEnvironmentVariables(new EnvironmentVariableExt[0]);
		// fill the command template parameters (see Table1 for “inputParam”)
		ArrayOfCommandTemplateParameterValueExt a = new ArrayOfCommandTemplateParameterValueExt();
		CommandTemplateParameterValueExt pv = new CommandTemplateParameterValueExt();
		pv.setCommandParameterIdentifier("inputParam");
		pv.setParameterValue("someStringParam");
		a.getCommandTemplateParameterValueExt().add(pv);
		testTask.setTemplateParameterValues(a);

		// create job specification with the task above
		JobSpecificationExt testJob = new JobSpecificationExt();
		testJob.setName(taskname); // job name
		testJob.setMinCores(1); // minimum number of cores required
		testJob.setMaxCores(1); // maximum number of cores required
		testJob.setPriority(JobPriorityExt.AVERAGE);
		testJob.setProject("ExpTests"); // accounting project
		testJob.setWaitingLimit(null); // limit for the waiting time in cluster
										// queue
		testJob.setWalltimeLimit(600); // maximum time for job to run (seconds)
		testJob.setClusterNodeTypeId(7L); // Salomon express queue (1h limit)
		// custom environment variables for the job
		// testJob.environmentVariables = new EnvironmentVariableExt[0];
		// assign created task to job specification
		ArrayOfTaskSpecificationExt tasks = new ArrayOfTaskSpecificationExt();
		tasks.getTaskSpecificationExt().add(testTask);
		testJob.setTasks(tasks);
		return testJob;
	}

	public SubmittedJobInfoExt SubmitJob(JobSpecificationExt testJob, File inputfile) {
		// create job
		SubmittedJobInfoExt submittedTestJob = wsJobManagement.getJobManagementWsSoap().createJob(testJob, sessionCode);
		System.out.println(String.format("Created job ID %s.", submittedTestJob.getId()));

		// upload input files
		FileTransferMethodExt ft = wsFileTransfer.getFileTransferWsSoap()
				.getFileTransferMethod(submittedTestJob.getId(), sessionCode);
		File tempDirJob = getTempDir(submittedTestJob.getId());
		tempDirJob.mkdirs();
		File privatekey = storeMetadata(ft, tempDirJob);
		if (inputfile != null && inputfile.exists())
		try (SSHClient ssh = new SSHClient()) {
			String filename = p.getProperty("haas.knownhosts");
			ssh.loadKnownHosts(new File(filename));
			ssh.connect(ft.getServerHostname());
				ssh.authPublickey(ft.getCredentials().getUsername(), privatekey.getAbsolutePath());
				ssh.newSCPFileTransfer().upload(inputfile.getAbsolutePath(), ft.getSharedBasepath());
			ssh.disconnect();
		} catch (Exception x) {
			x.printStackTrace();
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
				System.out.println(String.format("Submitted job state %s.", submittedJob.getState()));
				if (submittedJob.getState() == JobStateExt.SUBMITTED
						|| submittedJob.getState() == JobStateExt.CONFIGURING
						|| submittedJob.getState() == JobStateExt.QUEUED
						|| submittedJob.getState() == JobStateExt.RUNNING)
					continue;
				else
					break;
			} catch (Exception x) {
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
			System.out.println(
					wsFileTransfer.getFileTransferWsSoap().getFileTransferMethod(jobId, sessionCode).getProtocol());
			ArrayOfJobFileContentExt result = wsFileTransfer.getFileTransferWsSoap()
					.downloadPartsOfJobFilesFromCluster(jobId, aofsets, sessionCode);

			for (JobFileContentExt file : result.getJobFileContentExt()) {
				System.out.println(String.format("File: %s, %s ", file.getFileType(), file.getRelativePath()));
				System.out.println(String.format("TaskInfoId: ", file.getSubmittedTaskInfoId()));
				System.out.println(String.format("Offset: ", file.getOffset()));
				System.out.println(String.format("Content: %s", file.getContent()));

			}
		} catch (Exception x) {
			x.printStackTrace();
		}
		return submittedJob;
	}

	protected File getTempDir() {
		return new File(String.format("%s/haas", System.getProperty("java.io.tmpdir")));
	}

	protected File getTempDir(long jobId) {
		return new File(String.format("%s/%d", getTempDir(), jobId));
	}

	protected File storeMetadata(FileTransferMethodExt ft, File tempDirJob) {
		File properties = new File(tempDirJob, "haas.properties");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(properties))) {
			w.write(String.format("username=%s\n", ft.getCredentials().getUsername()));
			w.write(String.format("sharedBasepath=%s\n", ft.getSharedBasepath()));
		} catch (Exception x) {
			x.printStackTrace();
		}
		File privatekey = new File(tempDirJob, "haas.private.key");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(privatekey))) {
			w.write(ft.getCredentials().getPrivateKey());
		} catch (Exception x) {
			x.printStackTrace();
		}
		File publickey = new File(tempDirJob, "haas.public.key");
		try (BufferedWriter w = new BufferedWriter(new FileWriter(publickey))) {
			w.write(ft.getCredentials().getPublicKey());
		} catch (Exception x) {
			x.printStackTrace();
		}
		return privatekey;
	}

	public File process(SubmittedJobInfoExt submittedJob) {
		File tempDir = getTempDir();
		File tempDirJob = getTempDir(submittedJob.getId());
		tempDirJob.mkdirs();
		// job finished successfully, download result files from the cluster
		if (submittedJob.getState() == JobStateExt.FINISHED) {
			FileTransferMethodExt ft2 = wsFileTransfer.getFileTransferWsSoap()
					.getFileTransferMethod(submittedJob.getId(), sessionCode);

			File privatekey = storeMetadata(ft2, tempDirJob);

			try (SSHClient ssh = new SSHClient()) {
				String filename = p.getProperty("haas.knownhosts");

				ssh.loadKnownHosts(new File(filename));
				ssh.connect(ft2.getServerHostname());
				ssh.authPublickey(ft2.getCredentials().getUsername(), privatekey.getAbsolutePath());

				ssh.newSCPFileTransfer().download(ft2.getSharedBasepath(), new FileSystemFile(tempDir));
				ssh.disconnect();
			} catch (Exception x) {
				x.printStackTrace();
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
