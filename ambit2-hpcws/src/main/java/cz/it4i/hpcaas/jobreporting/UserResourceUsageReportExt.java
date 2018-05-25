
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UserResourceUsageReportExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserResourceUsageReportExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://hpcaas.it4i.cz/}AdaptorUserExt" minOccurs="0"/>
 *         &lt;element name="nodeTypeReports" type="{http://hpcaas.it4i.cz/}ArrayOfNodeTypeAggregatedUsageExt" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
@XmlType(name = "UserResourceUsageReportExt", propOrder = {
    "user",
    "nodeTypeReports",
    "startTime",
    "endTime",
    "totalCorehoursUsage"
})
public class UserResourceUsageReportExt {

    protected AdaptorUserExt user;
    protected ArrayOfNodeTypeAggregatedUsageExt nodeTypeReports;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
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
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
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
