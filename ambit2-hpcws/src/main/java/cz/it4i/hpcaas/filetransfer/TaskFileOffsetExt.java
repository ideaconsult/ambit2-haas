
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskFileOffsetExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskFileOffsetExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="submittedTaskInfoId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fileType" type="{http://hpcaas.it4i.cz/}SynchronizableFilesExt"/>
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskFileOffsetExt", propOrder = {
    "submittedTaskInfoId",
    "fileType",
    "offset"
})
public class TaskFileOffsetExt {

    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long submittedTaskInfoId;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected SynchronizableFilesExt fileType;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long offset;

    /**
     * Gets the value of the submittedTaskInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubmittedTaskInfoId() {
        return submittedTaskInfoId;
    }

    /**
     * Sets the value of the submittedTaskInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubmittedTaskInfoId(Long value) {
        this.submittedTaskInfoId = value;
    }

    /**
     * Gets the value of the fileType property.
     * 
     * @return
     *     possible object is
     *     {@link SynchronizableFilesExt }
     *     
     */
    public SynchronizableFilesExt getFileType() {
        return fileType;
    }

    /**
     * Sets the value of the fileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynchronizableFilesExt }
     *     
     */
    public void setFileType(SynchronizableFilesExt value) {
        this.fileType = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOffset(Long value) {
        this.offset = value;
    }

}
