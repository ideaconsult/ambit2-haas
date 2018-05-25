
package cz.it4i.hpcaas.jobreporting;

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
 *         &lt;element name="GetResourceUsageReportForJobResult" type="{http://hpcaas.it4i.cz/}SubmittedJobInfoUsageReportExt" minOccurs="0"/>
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
    "getResourceUsageReportForJobResult"
})
@XmlRootElement(name = "GetResourceUsageReportForJobResponse")
public class GetResourceUsageReportForJobResponse {

    @XmlElement(name = "GetResourceUsageReportForJobResult")
    protected SubmittedJobInfoUsageReportExt getResourceUsageReportForJobResult;

    /**
     * Gets the value of the getResourceUsageReportForJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link SubmittedJobInfoUsageReportExt }
     *     
     */
    public SubmittedJobInfoUsageReportExt getGetResourceUsageReportForJobResult() {
        return getResourceUsageReportForJobResult;
    }

    /**
     * Sets the value of the getResourceUsageReportForJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmittedJobInfoUsageReportExt }
     *     
     */
    public void setGetResourceUsageReportForJobResult(SubmittedJobInfoUsageReportExt value) {
        this.getResourceUsageReportForJobResult = value;
    }

}
