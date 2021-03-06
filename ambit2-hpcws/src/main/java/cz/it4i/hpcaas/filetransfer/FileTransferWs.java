
package cz.it4i.hpcaas.filetransfer;

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
@WebServiceClient(name = "FileTransferWs", targetNamespace = "http://hpcaas.it4i.cz/", wsdlLocation = "https://haas.it4i.cz/HaasWsExcape/FileTransferWs.asmx?WSDL")
public class FileTransferWs
    extends Service
{

    private final static URL FILETRANSFERWS_WSDL_LOCATION;
    private final static WebServiceException FILETRANSFERWS_EXCEPTION;
    private final static QName FILETRANSFERWS_QNAME = new QName("http://hpcaas.it4i.cz/", "FileTransferWs");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://haas.it4i.cz/HaasWsExcape/FileTransferWs.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILETRANSFERWS_WSDL_LOCATION = url;
        FILETRANSFERWS_EXCEPTION = e;
    }

    public FileTransferWs() {
        super(__getWsdlLocation(), FILETRANSFERWS_QNAME);
    }

    public FileTransferWs(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILETRANSFERWS_QNAME, features);
    }

    public FileTransferWs(URL wsdlLocation) {
        super(wsdlLocation, FILETRANSFERWS_QNAME);
    }

    public FileTransferWs(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILETRANSFERWS_QNAME, features);
    }

    public FileTransferWs(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FileTransferWs(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FileTransferWsSoap
     */
    @WebEndpoint(name = "FileTransferWsSoap")
    public FileTransferWsSoap getFileTransferWsSoap() {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "FileTransferWsSoap"), FileTransferWsSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FileTransferWsSoap
     */
    @WebEndpoint(name = "FileTransferWsSoap")
    public FileTransferWsSoap getFileTransferWsSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "FileTransferWsSoap"), FileTransferWsSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns FileTransferWsSoap
     */
    @WebEndpoint(name = "FileTransferWsSoap12")
    public FileTransferWsSoap getFileTransferWsSoap12() {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "FileTransferWsSoap12"), FileTransferWsSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FileTransferWsSoap
     */
    @WebEndpoint(name = "FileTransferWsSoap12")
    public FileTransferWsSoap getFileTransferWsSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://hpcaas.it4i.cz/", "FileTransferWsSoap12"), FileTransferWsSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILETRANSFERWS_EXCEPTION!= null) {
            throw FILETRANSFERWS_EXCEPTION;
        }
        return FILETRANSFERWS_WSDL_LOCATION;
    }

}
