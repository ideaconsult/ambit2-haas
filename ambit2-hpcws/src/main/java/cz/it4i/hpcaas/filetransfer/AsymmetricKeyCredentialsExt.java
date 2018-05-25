
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AsymmetricKeyCredentialsExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AsymmetricKeyCredentialsExt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hpcaas.it4i.cz/}AuthenticationCredentialsExt">
 *       &lt;sequence>
 *         &lt;element name="privateKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AsymmetricKeyCredentialsExt", propOrder = {
    "privateKey",
    "publicKey"
})
public class AsymmetricKeyCredentialsExt
    extends AuthenticationCredentialsExt
{

    protected String privateKey;
    protected String publicKey;

    /**
     * Gets the value of the privateKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Sets the value of the privateKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivateKey(String value) {
        this.privateKey = value;
    }

    /**
     * Gets the value of the publicKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * Sets the value of the publicKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicKey(String value) {
        this.publicKey = value;
    }

}
