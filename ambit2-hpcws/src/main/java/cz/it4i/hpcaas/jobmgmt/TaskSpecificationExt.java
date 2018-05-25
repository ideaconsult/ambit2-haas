
package cz.it4i.hpcaas.jobmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskSpecificationExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskSpecificationExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="walltimeLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="requiredNodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isExclusive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isRerunnable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="standardInputFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="standardOutputFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="standardErrorFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progressFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clusterTaskSubdirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commandTemplateId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="environmentVariables" type="{http://hpcaas.it4i.cz/}ArrayOfEnvironmentVariableExt" minOccurs="0"/>
 *         &lt;element name="dependsOn" type="{http://hpcaas.it4i.cz/}ArrayOfTaskSpecificationExt" minOccurs="0"/>
 *         &lt;element name="templateParameterValues" type="{http://hpcaas.it4i.cz/}ArrayOfCommandTemplateParameterValueExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskSpecificationExt", propOrder = {
    "name",
    "minCores",
    "maxCores",
    "walltimeLimit",
    "requiredNodes",
    "isExclusive",
    "isRerunnable",
    "standardInputFile",
    "standardOutputFile",
    "standardErrorFile",
    "progressFile",
    "logFile",
    "clusterTaskSubdirectory",
    "commandTemplateId",
    "environmentVariables",
    "dependsOn",
    "templateParameterValues"
})
public class TaskSpecificationExt {

    protected String name;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer minCores;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer maxCores;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer walltimeLimit;
    protected String requiredNodes;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean isExclusive;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean isRerunnable;
    protected String standardInputFile;
    protected String standardOutputFile;
    protected String standardErrorFile;
    protected String progressFile;
    protected String logFile;
    protected String clusterTaskSubdirectory;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long commandTemplateId;
    protected ArrayOfEnvironmentVariableExt environmentVariables;
    protected ArrayOfTaskSpecificationExt dependsOn;
    protected ArrayOfCommandTemplateParameterValueExt templateParameterValues;

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
     * Gets the value of the requiredNodes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiredNodes() {
        return requiredNodes;
    }

    /**
     * Sets the value of the requiredNodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiredNodes(String value) {
        this.requiredNodes = value;
    }

    /**
     * Gets the value of the isExclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsExclusive() {
        return isExclusive;
    }

    /**
     * Sets the value of the isExclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsExclusive(Boolean value) {
        this.isExclusive = value;
    }

    /**
     * Gets the value of the isRerunnable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRerunnable() {
        return isRerunnable;
    }

    /**
     * Sets the value of the isRerunnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRerunnable(Boolean value) {
        this.isRerunnable = value;
    }

    /**
     * Gets the value of the standardInputFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardInputFile() {
        return standardInputFile;
    }

    /**
     * Sets the value of the standardInputFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardInputFile(String value) {
        this.standardInputFile = value;
    }

    /**
     * Gets the value of the standardOutputFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardOutputFile() {
        return standardOutputFile;
    }

    /**
     * Sets the value of the standardOutputFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardOutputFile(String value) {
        this.standardOutputFile = value;
    }

    /**
     * Gets the value of the standardErrorFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardErrorFile() {
        return standardErrorFile;
    }

    /**
     * Sets the value of the standardErrorFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardErrorFile(String value) {
        this.standardErrorFile = value;
    }

    /**
     * Gets the value of the progressFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgressFile() {
        return progressFile;
    }

    /**
     * Sets the value of the progressFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgressFile(String value) {
        this.progressFile = value;
    }

    /**
     * Gets the value of the logFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogFile() {
        return logFile;
    }

    /**
     * Sets the value of the logFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogFile(String value) {
        this.logFile = value;
    }

    /**
     * Gets the value of the clusterTaskSubdirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterTaskSubdirectory() {
        return clusterTaskSubdirectory;
    }

    /**
     * Sets the value of the clusterTaskSubdirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterTaskSubdirectory(String value) {
        this.clusterTaskSubdirectory = value;
    }

    /**
     * Gets the value of the commandTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCommandTemplateId() {
        return commandTemplateId;
    }

    /**
     * Sets the value of the commandTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCommandTemplateId(Long value) {
        this.commandTemplateId = value;
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
     * Gets the value of the dependsOn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTaskSpecificationExt }
     *     
     */
    public ArrayOfTaskSpecificationExt getDependsOn() {
        return dependsOn;
    }

    /**
     * Sets the value of the dependsOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTaskSpecificationExt }
     *     
     */
    public void setDependsOn(ArrayOfTaskSpecificationExt value) {
        this.dependsOn = value;
    }

    /**
     * Gets the value of the templateParameterValues property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCommandTemplateParameterValueExt }
     *     
     */
    public ArrayOfCommandTemplateParameterValueExt getTemplateParameterValues() {
        return templateParameterValues;
    }

    /**
     * Sets the value of the templateParameterValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCommandTemplateParameterValueExt }
     *     
     */
    public void setTemplateParameterValues(ArrayOfCommandTemplateParameterValueExt value) {
        this.templateParameterValues = value;
    }

}
