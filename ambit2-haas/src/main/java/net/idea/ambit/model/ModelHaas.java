package net.idea.ambit.model;

import java.io.Serializable;

public class ModelHaas implements Serializable {
	protected String algorithm;
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	protected int jobid;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getSessioncode() {
		return sessioncode;
	}
	public void setSessioncode(String sessioncode) {
		this.sessioncode = sessioncode;
	}
	protected String sessioncode;
}
