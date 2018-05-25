
package cz.it4i.hpcaas.usermgmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourceLimitationExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceLimitationExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalMaxCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCoresPerJob" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceLimitationExt", propOrder = {
    "totalMaxCores",
    "maxCoresPerJob"
})
public class ResourceLimitationExt {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer totalMaxCores;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer maxCoresPerJob;

    /**
     * Gets the value of the totalMaxCores property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalMaxCores() {
        return totalMaxCores;
    }

    /**
     * Sets the value of the totalMaxCores property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalMaxCores(Integer value) {
        this.totalMaxCores = value;
    }

    /**
     * Gets the value of the maxCoresPerJob property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxCoresPerJob() {
        return maxCoresPerJob;
    }

    /**
     * Sets the value of the maxCoresPerJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxCoresPerJob(Integer value) {
        this.maxCoresPerJob = value;
    }

}
