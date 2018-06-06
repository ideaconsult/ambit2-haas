package net.idea.ambit.hpcws;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Properties;

import org.junit.Test;

import cz.it4i.hpcaas.clusterinfo.ClusterInfoExt;
import cz.it4i.hpcaas.clusterinfo.ClusterInformationWs;
import cz.it4i.hpcaas.clusterinfo.ClusterInformationWsSoap;
import cz.it4i.hpcaas.usermgmgmt.PasswordCredentialsExt;
import cz.it4i.hpcaas.usermgmgmt.UserAndLimitationManagementWs;
import cz.it4i.hpcaas.usermgmgmt.UserAndLimitationManagementWsSoap;
import junit.framework.Assert;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.KeyType;
import net.schmizz.sshj.userauth.keyprovider.KeyFormat;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;
import net.schmizz.sshj.userauth.keyprovider.KeyProviderUtil;
import net.schmizz.sshj.xfer.FileSystemFile;

public class TestHPCWS {

	public Properties loadProperties() throws Exception {
		Properties p = new Properties();
		try (InputStream in = TestHPCWS.class.getClassLoader()
				.getResourceAsStream("net/idea/ambit/hpcws/config/haas.properties")) {
			p.load(in);
		}
		return p;
	}

	@Test
	public void testClusterInfo() throws Exception {
		ClusterInformationWs c = new ClusterInformationWs();
		ClusterInformationWsSoap info = c.getClusterInformationWsSoap();

		for (ClusterInfoExt x : info.listAvailableClusters().getClusterInfoExt()) {
			System.out.println(String.format("%s\t%s\t%s\t%s", x.getId(), x.getName(), x.getDescription(),
					x.getNodeTypes().getClusterNodeTypeExt().get(0).getNumberOfNodes()));

		}
		// What is session code? returned from usre ws ?
		// info.getCurrentClusterNodeUsage(1, sessionCode)

	}

	@Test
	public void testKnownHosts() throws Exception {
		Properties p = loadProperties();
		String filename = p.getProperty("haas.knownhosts");
		Assert.assertNotNull(filename);
		File file = new File(filename);
		System.out.println(filename);
		Assert.assertTrue(file.exists());

		String keyfile = p.getProperty("haas.keyfile");
		KeyFormat kf = KeyProviderUtil.detectKeyFileFormat(new File(keyfile));
		System.out.println(kf);
	}

	@Test
	public void testUser() throws Exception {
		Properties p = loadProperties();
		System.out.println(p);
		PasswordCredentialsExt credentials = new PasswordCredentialsExt();
		credentials.setUsername(p.getProperty("haas.user"));
		credentials.setPassword(p.getProperty("haas.pwd"));

		UserAndLimitationManagementWs c = new UserAndLimitationManagementWs();
		UserAndLimitationManagementWsSoap cc = c.getUserAndLimitationManagementWsSoap();
		System.out.println(cc);
		String auth = cc.authenticateUserPassword(credentials);
		System.out.println(auth);

	}


	@Test
	public void testProperties() throws Exception {
		Properties p = loadProperties();
		Assert.assertNotNull(p.getProperty("haas.user"));
		Assert.assertNotNull(p.getProperty("haas.pwd"));
		Assert.assertNotNull(p.getProperty("haas.knownhosts"));
	}

}

class MyKeyProvider implements KeyProvider {

	@Override
	public PrivateKey getPrivate() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublicKey getPublic() throws IOException {

		return null;
	}

	@Override
	public KeyType getType() throws IOException {
		return KeyType.RSA;
	}
	
}
