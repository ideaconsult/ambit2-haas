
package cz.it4i.hpcaas.usermgmgmt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourceUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeType" type="{http://hpcaas.it4i.cz/}ClusterNodeTypeExt" minOccurs="0"/>
 *         &lt;element name="coresUsed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="limitation" type="{http://hpcaas.it4i.cz/}ResourceLimitationExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceUsageExt", propOrder = {
    "nodeType",
    "coresUsed",
    "limitation"
})
public class ResourceUsageExt {

    protected ClusterNodeTypeExt nodeType;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer coresUsed;
    protected ResourceLimitationExt limitation;

    /**
     * Gets the value of the nodeType property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterNodeTypeExt }
     *     
     */
    public ClusterNodeTypeExt getNodeType() {
        return nodeType;
    }

    /**
     * Sets the value of the nodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterNodeTypeExt }
     *     
     */
    public void setNodeType(ClusterNodeTypeExt value) {
        this.nodeType = value;
    }

    /**
     * Gets the value of the coresUsed property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCoresUsed() {
        return coresUsed;
    }

    /**
     * Sets the value of the coresUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCoresUsed(Integer value) {
        this.coresUsed = value;
    }

    /**
     * Gets the value of the limitation property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceLimitationExt }
     *     
     */
    public ResourceLimitationExt getLimitation() {
        return limitation;
    }

    /**
     * Sets the value of the limitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceLimitationExt }
     *     
     */
    public void setLimitation(ResourceLimitationExt value) {
        this.limitation = value;
    }

}
