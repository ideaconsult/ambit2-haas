
package cz.it4i.hpcaas.usermgmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="AuthenticateUserDigitalSignatureResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "authenticateUserDigitalSignatureResult"
})
@XmlRootElement(name = "AuthenticateUserDigitalSignatureResponse")
public class AuthenticateUserDigitalSignatureResponse {

    @XmlElement(name = "AuthenticateUserDigitalSignatureResult")
    protected String authenticateUserDigitalSignatureResult;

    /**
     * Gets the value of the authenticateUserDigitalSignatureResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticateUserDigitalSignatureResult() {
        return authenticateUserDigitalSignatureResult;
    }

    /**
     * Sets the value of the authenticateUserDigitalSignatureResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticateUserDigitalSignatureResult(String value) {
        this.authenticateUserDigitalSignatureResult = value;
    }

}
