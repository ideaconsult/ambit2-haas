
package cz.it4i.hpcaas.usermgmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DigitalSignatureCredentialsExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DigitalSignatureCredentialsExt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hpcaas.it4i.cz/}AuthenticationCredentialsExt">
 *       &lt;sequence>
 *         &lt;element name="noise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="digitalSignature" type="{http://hpcaas.it4i.cz/}ArrayOfByte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DigitalSignatureCredentialsExt", propOrder = {
    "noise",
    "digitalSignature"
})
public class DigitalSignatureCredentialsExt
    extends AuthenticationCredentialsExt
{

    protected String noise;
    protected ArrayOfByte digitalSignature;

    /**
     * Gets the value of the noise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoise() {
        return noise;
    }

    /**
     * Sets the value of the noise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoise(String value) {
        this.noise = value;
    }

    /**
     * Gets the value of the digitalSignature property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfByte }
     *     
     */
    public ArrayOfByte getDigitalSignature() {
        return digitalSignature;
    }

    /**
     * Sets the value of the digitalSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfByte }
     *     
     */
    public void setDigitalSignature(ArrayOfByte value) {
        this.digitalSignature = value;
    }

}
