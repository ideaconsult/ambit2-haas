
package cz.it4i.hpcaas.jobmgmt;

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
 *         &lt;element name="specification" type="{http://hpcaas.it4i.cz/}JobSpecificationExt" minOccurs="0"/>
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
    "specification",
    "sessionCode"
})
@XmlRootElement(name = "CreateJob")
public class CreateJob {

    protected JobSpecificationExt specification;
    protected String sessionCode;

    /**
     * Gets the value of the specification property.
     * 
     * @return
     *     possible object is
     *     {@link JobSpecificationExt }
     *     
     */
    public JobSpecificationExt getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobSpecificationExt }
     *     
     */
    public void setSpecification(JobSpecificationExt value) {
        this.specification = value;
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
