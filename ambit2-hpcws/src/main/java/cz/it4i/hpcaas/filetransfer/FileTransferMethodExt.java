
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileTransferMethodExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileTransferMethodExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverHostname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sharedBasepath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="protocol" type="{http://hpcaas.it4i.cz/}FileTransferProtocolExt"/>
 *         &lt;element name="credentials" type="{http://hpcaas.it4i.cz/}AsymmetricKeyCredentialsExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileTransferMethodExt", propOrder = {
    "serverHostname",
    "sharedBasepath",
    "protocol",
    "credentials"
})
public class FileTransferMethodExt {

    protected String serverHostname;
    protected String sharedBasepath;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected FileTransferProtocolExt protocol;
    protected AsymmetricKeyCredentialsExt credentials;

    /**
     * Gets the value of the serverHostname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerHostname() {
        return serverHostname;
    }

    /**
     * Sets the value of the serverHostname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerHostname(String value) {
        this.serverHostname = value;
    }

    /**
     * Gets the value of the sharedBasepath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedBasepath() {
        return sharedBasepath;
    }

    /**
     * Sets the value of the sharedBasepath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedBasepath(String value) {
        this.sharedBasepath = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link FileTransferProtocolExt }
     *     
     */
    public FileTransferProtocolExt getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileTransferProtocolExt }
     *     
     */
    public void setProtocol(FileTransferProtocolExt value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link AsymmetricKeyCredentialsExt }
     *     
     */
    public AsymmetricKeyCredentialsExt getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsymmetricKeyCredentialsExt }
     *     
     */
    public void setCredentials(AsymmetricKeyCredentialsExt value) {
        this.credentials = value;
    }

}
