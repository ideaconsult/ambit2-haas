package net.idea.ambit.algorithm.test;

import org.junit.Test;
import org.restlet.data.Form;
import org.restlet.data.Reference;
import org.restlet.data.Status;

import ambit2.rest.algorithm.MLResources;
import junit.framework.Assert;

public class AlgorithmHaasTest extends ResourceTest {

	@Override
	public String getTestURI() {
		return String.format("http://localhost:%d%s/haasexnettest", port,
				MLResources.algorithm);
	}
	
	@Test
	public void testExnetMockup() throws Exception {
		Form webform = new Form();
		webform.add("learning_rate_list", "1.0");
		webform.add("network_layout_list", "200,200");
		webform.add("network_layout_list", "2000,2000");
		webform.add("network_layout_list", "");
		Reference url = testAsyncTask(getTestURI(),
				webform, Status.SUCCESS_OK, null);
		String expected = String.format("http://localhost:%d/model/0", port);
		Assert.assertEquals(expected, url.toString());

	}
	
	@Test
	public void testExnet() throws Exception {
		Form webform = new Form();
		webform.add("learning_rate_list", "0.5");
		webform.add("network_layout_list", "2048,2048");
		String exneturi = String.format("http://localhost:%d%s/haasexnet", port,
				MLResources.algorithm);
		Reference url = testAsyncTask(exneturi,
				webform, Status.SUCCESS_OK, null);
		String expected = String.format("http://localhost:%d/model/0", port);
		Assert.assertEquals(expected, url.toString());

	}
	
	@Test
	public void testHaasExample() throws Exception {
		Form webform = new Form();
		webform.add("learning_rate_list", "0.5");
		webform.add("network_layout_list", "2048,2048");
		String exneturi = String.format("http://localhost:%d%s/haasexample", port,
				MLResources.algorithm);
		Reference url = testAsyncTask(exneturi,
				webform, Status.SUCCESS_OK, null);
		String expected = String.format("http://localhost:%d/model/0", port);
		Assert.assertEquals(expected, url.toString());

	}
}
