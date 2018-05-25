
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
 *         &lt;element name="GetUserResourceUsageReportResult" type="{http://hpcaas.it4i.cz/}UserResourceUsageReportExt" minOccurs="0"/>
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
    "getUserResourceUsageReportResult"
})
@XmlRootElement(name = "GetUserResourceUsageReportResponse")
public class GetUserResourceUsageReportResponse {

    @XmlElement(name = "GetUserResourceUsageReportResult")
    protected UserResourceUsageReportExt getUserResourceUsageReportResult;

    /**
     * Gets the value of the getUserResourceUsageReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link UserResourceUsageReportExt }
     *     
     */
    public UserResourceUsageReportExt getGetUserResourceUsageReportResult() {
        return getUserResourceUsageReportResult;
    }

    /**
     * Sets the value of the getUserResourceUsageReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserResourceUsageReportExt }
     *     
     */
    public void setGetUserResourceUsageReportResult(UserResourceUsageReportExt value) {
        this.getUserResourceUsageReportResult = value;
    }

}
