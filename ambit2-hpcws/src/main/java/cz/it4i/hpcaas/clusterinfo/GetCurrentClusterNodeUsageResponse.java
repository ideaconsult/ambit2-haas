
package cz.it4i.hpcaas.clusterinfo;

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
 *         &lt;element name="GetCurrentClusterNodeUsageResult" type="{http://hpcaas.it4i.cz/}ClusterNodeUsageExt" minOccurs="0"/>
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
    "getCurrentClusterNodeUsageResult"
})
@XmlRootElement(name = "GetCurrentClusterNodeUsageResponse")
public class GetCurrentClusterNodeUsageResponse {

    @XmlElement(name = "GetCurrentClusterNodeUsageResult")
    protected ClusterNodeUsageExt getCurrentClusterNodeUsageResult;

    /**
     * Gets the value of the getCurrentClusterNodeUsageResult property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterNodeUsageExt }
     *     
     */
    public ClusterNodeUsageExt getGetCurrentClusterNodeUsageResult() {
        return getCurrentClusterNodeUsageResult;
    }

    /**
     * Sets the value of the getCurrentClusterNodeUsageResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterNodeUsageExt }
     *     
     */
    public void setGetCurrentClusterNodeUsageResult(ClusterNodeUsageExt value) {
        this.getCurrentClusterNodeUsageResult = value;
    }

}
