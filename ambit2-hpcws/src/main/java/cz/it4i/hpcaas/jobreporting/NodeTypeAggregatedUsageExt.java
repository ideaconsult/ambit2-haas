
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NodeTypeAggregatedUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NodeTypeAggregatedUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clusterNodeType" type="{http://hpcaas.it4i.cz/}ClusterNodeTypeExt" minOccurs="0"/>
 *         &lt;element name="submittedJobs" type="{http://hpcaas.it4i.cz/}ArrayOfSubmittedJobInfoUsageReportExt" minOccurs="0"/>
 *         &lt;element name="totalCorehoursUsage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NodeTypeAggregatedUsageExt", propOrder = {
    "clusterNodeType",
    "submittedJobs",
    "totalCorehoursUsage"
})
public class NodeTypeAggregatedUsageExt {

    protected ClusterNodeTypeExt clusterNodeType;
    protected ArrayOfSubmittedJobInfoUsageReportExt submittedJobs;
    @XmlElement(required = true, type = Double.class, nillable = true)
    protected Double totalCorehoursUsage;

    /**
     * Gets the value of the clusterNodeType property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterNodeTypeExt }
     *     
     */
    public ClusterNodeTypeExt getClusterNodeType() {
        return clusterNodeType;
    }

    /**
     * Sets the value of the clusterNodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterNodeTypeExt }
     *     
     */
    public void setClusterNodeType(ClusterNodeTypeExt value) {
        this.clusterNodeType = value;
    }

    /**
     * Gets the value of the submittedJobs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSubmittedJobInfoUsageReportExt }
     *     
     */
    public ArrayOfSubmittedJobInfoUsageReportExt getSubmittedJobs() {
        return submittedJobs;
    }

    /**
     * Sets the value of the submittedJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSubmittedJobInfoUsageReportExt }
     *     
     */
    public void setSubmittedJobs(ArrayOfSubmittedJobInfoUsageReportExt value) {
        this.submittedJobs = value;
    }

    /**
     * Gets the value of the totalCorehoursUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalCorehoursUsage() {
        return totalCorehoursUsage;
    }

    /**
     * Sets the value of the totalCorehoursUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalCorehoursUsage(Double value) {
        this.totalCorehoursUsage = value;
    }

}
