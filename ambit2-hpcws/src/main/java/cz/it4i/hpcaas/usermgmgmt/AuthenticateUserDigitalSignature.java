
package cz.it4i.hpcaas.usermgmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credentials" type="{http://hpcaas.it4i.cz/}DigitalSignatureCredentialsExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "credentials"
})
@XmlRootElement(name = "AuthenticateUserDigitalSignature")
public class AuthenticateUserDigitalSignature {

    protected DigitalSignatureCredentialsExt credentials;

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link DigitalSignatureCredentialsExt }
     *     
     */
    public DigitalSignatureCredentialsExt getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigitalSignatureCredentialsExt }
     *     
     */
    public void setCredentials(DigitalSignatureCredentialsExt value) {
        this.credentials = value;
    }

}
