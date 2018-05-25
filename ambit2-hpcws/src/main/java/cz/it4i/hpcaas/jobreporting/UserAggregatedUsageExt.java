
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserAggregatedUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAggregatedUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://hpcaas.it4i.cz/}AdaptorUserExt" minOccurs="0"/>
 *         &lt;element name="nodeTypeReports" type="{http://hpcaas.it4i.cz/}ArrayOfNodeTypeAggregatedUsageExt" minOccurs="0"/>
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
@XmlType(name = "UserAggregatedUsageExt", propOrder = {
    "user",
    "nodeTypeReports",
    "totalCorehoursUsage"
})
public class UserAggregatedUsageExt {

    protected AdaptorUserExt user;
    protected ArrayOfNodeTypeAggregatedUsageExt nodeTypeReports;
    @XmlElement(required = true, type = Double.class, nillable = true)
    protected Double totalCorehoursUsage;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link AdaptorUserExt }
     *     
     */
    public AdaptorUserExt getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdaptorUserExt }
     *     
     */
    public void setUser(AdaptorUserExt value) {
        this.user = value;
    }

    /**
     * Gets the value of the nodeTypeReports property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNodeTypeAggregatedUsageExt }
     *     
     */
    public ArrayOfNodeTypeAggregatedUsageExt getNodeTypeReports() {
        return nodeTypeReports;
    }

    /**
     * Sets the value of the nodeTypeReports property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNodeTypeAggregatedUsageExt }
     *     
     */
    public void setNodeTypeReports(ArrayOfNodeTypeAggregatedUsageExt value) {
        this.nodeTypeReports = value;
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
