
package cz.it4i.hpcaas.jobmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubmittedTaskInfoExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmittedTaskInfoExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://hpcaas.it4i.cz/}TaskStateExt"/>
 *         &lt;element name="allocatedTime" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="allocatedCoreIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmittedTaskInfoExt", propOrder = {
    "id",
    "name",
    "state",
    "allocatedTime",
    "allocatedCoreIds",
    "startTime",
    "endTime",
    "errorMessage",
    "allParameters"
})
public class SubmittedTaskInfoExt {

    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long id;
    protected String name;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected TaskStateExt state;
    @XmlElement(required = true, type = Double.class, nillable = true)
    protected Double allocatedTime;
    protected String allocatedCoreIds;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    protected String errorMessage;
    protected String allParameters;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link TaskStateExt }
     *     
     */
    public TaskStateExt getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskStateExt }
     *     
     */
    public void setState(TaskStateExt value) {
        this.state = value;
    }

    /**
     * Gets the value of the allocatedTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAllocatedTime() {
        return allocatedTime;
    }

    /**
     * Sets the value of the allocatedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAllocatedTime(Double value) {
        this.allocatedTime = value;
    }

    /**
     * Gets the value of the allocatedCoreIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllocatedCoreIds() {
        return allocatedCoreIds;
    }

    /**
     * Sets the value of the allocatedCoreIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllocatedCoreIds(String value) {
        this.allocatedCoreIds = value;
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
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the allParameters property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllParameters() {
        return allParameters;
    }

    /**
     * Sets the value of the allParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllParameters(String value) {
        this.allParameters = value;
    }

}
