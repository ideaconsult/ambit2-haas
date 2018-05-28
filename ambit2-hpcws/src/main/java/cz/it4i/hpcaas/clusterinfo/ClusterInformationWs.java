
package cz.it4i.hpcaas.clusterinfo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ClusterInformationWs", targetNamespace = "http://hpcaas.it4i.cz/", wsdlLocation = "https://haas.it4i.cz/HaasWsExcape/ClusterInformationWs.asmx?WSDL")
public class ClusterInformationWs
    extends Service
{

    private final static URL CLUSTERINFORMATIONWS_WSDL_LOCATION;
    private final static WebServiceException CLUSTERINFORMATIONWS_EXCEPTION;
    private final static QName CLUSTERINFORMATIONWS_QNAME = new QName("http://hpcaas.it4i.cz/", "ClusterInformationWs");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://haas.it4i.cz/HaasWsExcape/ClusterInformationWs.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLUSTERINFORMATIONWS_WSDL_LOCATION = url;
        CLUSTERINFORMATIONWS_EXCEPTION = e;
    }

    public ClusterInformationWs() {
        super(__getWsdlLocation(), CLUSTERINFORMATIONWS_QNAME);
    }

    public ClusterInformationWs(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLUSTERINFORMATIONWS_QNAME, features);
    }

    public ClusterInformationWs(URL wsdlLocation) {
        super(wsdlLocation, CLUSTERINFORMATIONWS_QNAME);
    }

    public ClusterInformationWs(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLUSTERINFORMATIONWS_QNAME, features);
    }

    public ClusterInformationWs(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClusterInformationWs(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ClusterInformationWsSoap
     */
    @WebEndpoint(name = "ClusterInformationWsSoap")
    public ClusterInformationWsSoap getClusterInformationWsSoap() {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "ClusterInformationWsSoap"), ClusterInformationWsSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClusterInformationWsSoap
     */
    @WebEndpoint(name = "ClusterInformationWsSoap")
    public ClusterInformationWsSoap getClusterInformationWsSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "ClusterInformationWsSoap"), ClusterInformationWsSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns ClusterInformationWsSoap
     */
    @WebEndpoint(name = "ClusterInformationWsSoap12")
    public ClusterInformationWsSoap getClusterInformationWsSoap12() {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "ClusterInformationWsSoap12"), ClusterInformationWsSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClusterInformationWsSoap
     */
    @WebEndpoint(name = "ClusterInformationWsSoap12")
    public ClusterInformationWsSoap getClusterInformationWsSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "ClusterInformationWsSoap12"), ClusterInformationWsSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLUSTERINFORMATIONWS_EXCEPTION!= null) {
            throw CLUSTERINFORMATIONWS_EXCEPTION;
        }
        return CLUSTERINFORMATIONWS_WSDL_LOCATION;
    }

}
