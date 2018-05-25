
package cz.it4i.hpcaas.jobmgmt;

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
 *         &lt;element name="SubmitJobResult" type="{http://hpcaas.it4i.cz/}SubmittedJobInfoExt" minOccurs="0"/>
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
    "submitJobResult"
})
@XmlRootElement(name = "SubmitJobResponse")
public class SubmitJobResponse {

    @XmlElement(name = "SubmitJobResult")
    protected SubmittedJobInfoExt submitJobResult;

    /**
     * Gets the value of the submitJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link SubmittedJobInfoExt }
     *     
     */
    public SubmittedJobInfoExt getSubmitJobResult() {
        return submitJobResult;
    }

    /**
     * Sets the value of the submitJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmittedJobInfoExt }
     *     
     */
    public void setSubmitJobResult(SubmittedJobInfoExt value) {
        this.submitJobResult = value;
    }

}
