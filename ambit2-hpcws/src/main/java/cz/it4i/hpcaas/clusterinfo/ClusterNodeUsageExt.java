
package cz.it4i.hpcaas.clusterinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterNodeUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterNodeUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeType" type="{http://hpcaas.it4i.cz/}ClusterNodeTypeExt" minOccurs="0"/>
 *         &lt;element name="nodesUsed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coresUsedPerNode" type="{http://hpcaas.it4i.cz/}ArrayOfInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterNodeUsageExt", propOrder = {
    "nodeType",
    "nodesUsed",
    "coresUsedPerNode"
})
public class ClusterNodeUsageExt {

    protected ClusterNodeTypeExt nodeType;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nodesUsed;
    protected ArrayOfInt coresUsedPerNode;

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
     * Gets the value of the nodesUsed property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNodesUsed() {
        return nodesUsed;
    }

    /**
     * Sets the value of the nodesUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNodesUsed(Integer value) {
        this.nodesUsed = value;
    }

    /**
     * Gets the value of the coresUsedPerNode property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getCoresUsedPerNode() {
        return coresUsedPerNode;
    }

    /**
     * Sets the value of the coresUsedPerNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setCoresUsedPerNode(ArrayOfInt value) {
        this.coresUsedPerNode = value;
    }

}
