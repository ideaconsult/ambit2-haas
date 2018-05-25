
package cz.it4i.hpcaas.jobmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobSpecificationExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JobSpecificationExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="priority" type="{http://hpcaas.it4i.cz/}JobPriorityExt"/>
 *         &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="waitingLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="walltimeLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notificationEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notifyOnAbort" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="notifyOnFinish" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="notifyOnStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clusterNodeTypeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="environmentVariables" type="{http://hpcaas.it4i.cz/}ArrayOfEnvironmentVariableExt" minOccurs="0"/>
 *         &lt;element name="tasks" type="{http://hpcaas.it4i.cz/}ArrayOfTaskSpecificationExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobSpecificationExt", propOrder = {
    "name",
    "minCores",
    "maxCores",
    "priority",
    "project",
    "waitingLimit",
    "walltimeLimit",
    "notificationEmail",
    "phoneNumber",
    "notifyOnAbort",
    "notifyOnFinish",
    "notifyOnStart",
    "clusterNodeTypeId",
    "environmentVariables",
    "tasks"
})
public class JobSpecificationExt {

    protected String name;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer minCores;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer maxCores;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected JobPriorityExt priority;
    protected String project;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer waitingLimit;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer walltimeLimit;
    protected String notificationEmail;
    protected String phoneNumber;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean notifyOnAbort;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean notifyOnFinish;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean notifyOnStart;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long clusterNodeTypeId;
    protected ArrayOfEnvironmentVariableExt environmentVariables;
    protected ArrayOfTaskSpecificationExt tasks;

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
     * Gets the value of the minCores property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinCores() {
        return minCores;
    }

    /**
     * Sets the value of the minCores property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinCores(Integer value) {
        this.minCores = value;
    }

    /**
     * Gets the value of the maxCores property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxCores() {
        return maxCores;
    }

    /**
     * Sets the value of the maxCores property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxCores(Integer value) {
        this.maxCores = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link JobPriorityExt }
     *     
     */
    public JobPriorityExt getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobPriorityExt }
     *     
     */
    public void setPriority(JobPriorityExt value) {
        this.priority = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Gets the value of the waitingLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWaitingLimit() {
        return waitingLimit;
    }

    /**
     * Sets the value of the waitingLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWaitingLimit(Integer value) {
        this.waitingLimit = value;
    }

    /**
     * Gets the value of the walltimeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWalltimeLimit() {
        return walltimeLimit;
    }

    /**
     * Sets the value of the walltimeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWalltimeLimit(Integer value) {
        this.walltimeLimit = value;
    }

    /**
     * Gets the value of the notificationEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationEmail() {
        return notificationEmail;
    }

    /**
     * Sets the value of the notificationEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationEmail(String value) {
        this.notificationEmail = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the notifyOnAbort property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyOnAbort() {
        return notifyOnAbort;
    }

    /**
     * Sets the value of the notifyOnAbort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyOnAbort(Boolean value) {
        this.notifyOnAbort = value;
    }

    /**
     * Gets the value of the notifyOnFinish property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyOnFinish() {
        return notifyOnFinish;
    }

    /**
     * Sets the value of the notifyOnFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyOnFinish(Boolean value) {
        this.notifyOnFinish = value;
    }

    /**
     * Gets the value of the notifyOnStart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyOnStart() {
        return notifyOnStart;
    }

    /**
     * Sets the value of the notifyOnStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyOnStart(Boolean value) {
        this.notifyOnStart = value;
    }

    /**
     * Gets the value of the clusterNodeTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClusterNodeTypeId() {
        return clusterNodeTypeId;
    }

    /**
     * Sets the value of the clusterNodeTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClusterNodeTypeId(Long value) {
        this.clusterNodeTypeId = value;
    }

    /**
     * Gets the value of the environmentVariables property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEnvironmentVariableExt }
     *     
     */
    public ArrayOfEnvironmentVariableExt getEnvironmentVariables() {
        return environmentVariables;
    }

    /**
     * Sets the value of the environmentVariables property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEnvironmentVariableExt }
     *     
     */
    public void setEnvironmentVariables(ArrayOfEnvironmentVariableExt value) {
        this.environmentVariables = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTaskSpecificationExt }
     *     
     */
    public ArrayOfTaskSpecificationExt getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTaskSpecificationExt }
     *     
     */
    public void setTasks(ArrayOfTaskSpecificationExt value) {
        this.tasks = value;
    }

}
