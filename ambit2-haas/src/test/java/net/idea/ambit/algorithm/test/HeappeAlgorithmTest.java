package net.idea.ambit.algorithm.test;

import java.io.File;

import org.junit.Test;
import org.restlet.data.Form;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.Algorithm;
import ambit2.core.data.model.Parameter;
import junit.framework.Assert;
import net.idea.ambit.algorithm.exnet.ExnetParam;
import net.idea.ambit.algorithm.exnet.HEAPPE_ALGORITHMS;

public class HeappeAlgorithmTest {
	@Test
	public void testParams() throws ResourceException {

		Algorithm algorithm = new Algorithm<>();
		HEAPPE_ALGORITHMS exnet = HEAPPE_ALGORITHMS.haasexnet;

		Form form = new Form();
		form.add("max_epochs", "10");
		form.add("learning_rate_list", "0.1, 1.0");
		form.add("momentum_list", "0.33");
		form.add("affinity_level_list", "5, 6");
		form.add("network_layout_list", "200,200");
		form.add("network_layout_list", "1000,1000");
		form.add("network_layout_list", "");
		algorithm = exnet.parseForm(form, algorithm);

		Assert.assertNotNull(algorithm.getParameters());
		for (Object prm : algorithm.getParameters()) {

			Assert.assertTrue(prm instanceof Parameter);
			Object o = ((Parameter) prm).getValue();
			Assert.assertTrue(o instanceof ExnetParam);
			ExnetParam ep = (ExnetParam) o;
			Assert.assertEquals((Integer) 10, ep.getMax_epochs());
			Assert.assertEquals(2, ep.getLearning_rate_list().length);
			for (double lr : ep.getLearning_rate_list())
				System.out.println(lr);
			Assert.assertEquals(1, ep.getMomentum_list().length);
			Assert.assertEquals(0.33, ep.getMomentum_list()[0]);
			Assert.assertEquals(2, ep.getAffinity_level_list().length);
			Assert.assertEquals(2, ep.getNetwork_layout_list().length);
			for (Integer[] net : ep.getNetwork_layout_list())
				for (Integer layer : net) {
					System.out.println(layer);
				}
		}
		File file = HEAPPE_ALGORITHMS.haasexnet.inputFile(algorithm);
		System.out.println(file.getAbsolutePath());
	}
}
