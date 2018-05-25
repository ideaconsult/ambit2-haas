
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="submittedJobInfoId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="relativeFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "submittedJobInfoId",
    "relativeFilePath",
    "sessionCode"
})
@XmlRootElement(name = "DownloadFileFromCluster")
public class DownloadFileFromCluster {

    protected long submittedJobInfoId;
    protected String relativeFilePath;
    protected String sessionCode;

    /**
     * Gets the value of the submittedJobInfoId property.
     * 
     */
    public long getSubmittedJobInfoId() {
        return submittedJobInfoId;
    }

    /**
     * Sets the value of the submittedJobInfoId property.
     * 
     */
    public void setSubmittedJobInfoId(long value) {
        this.submittedJobInfoId = value;
    }

    /**
     * Gets the value of the relativeFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelativeFilePath() {
        return relativeFilePath;
    }

    /**
     * Sets the value of the relativeFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativeFilePath(String value) {
        this.relativeFilePath = value;
    }

    /**
     * Gets the value of the sessionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionCode() {
        return sessionCode;
    }

    /**
     * Sets the value of the sessionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionCode(String value) {
        this.sessionCode = value;
    }

}
