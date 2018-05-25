
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterNodeTypeExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterNodeTypeExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfNodes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coresPerNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxWalltime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="possibleCommands" type="{http://hpcaas.it4i.cz/}ArrayOfCommandTemplateExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterNodeTypeExt", propOrder = {
    "id",
    "name",
    "description",
    "numberOfNodes",
    "coresPerNode",
    "maxWalltime",
    "possibleCommands"
})
public class ClusterNodeTypeExt {

    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long id;
    protected String name;
    protected String description;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numberOfNodes;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer coresPerNode;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer maxWalltime;
    protected ArrayOfCommandTemplateExt possibleCommands;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the numberOfNodes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Sets the value of the numberOfNodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfNodes(Integer value) {
        this.numberOfNodes = value;
    }

    /**
     * Gets the value of the coresPerNode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCoresPerNode() {
        return coresPerNode;
    }

    /**
     * Sets the value of the coresPerNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCoresPerNode(Integer value) {
        this.coresPerNode = value;
    }

    /**
     * Gets the value of the maxWalltime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxWalltime() {
        return maxWalltime;
    }

    /**
     * Sets the value of the maxWalltime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxWalltime(Integer value) {
        this.maxWalltime = value;
    }

    /**
     * Gets the value of the possibleCommands property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCommandTemplateExt }
     *     
     */
    public ArrayOfCommandTemplateExt getPossibleCommands() {
        return possibleCommands;
    }

    /**
     * Sets the value of the possibleCommands property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCommandTemplateExt }
     *     
     */
    public void setPossibleCommands(ArrayOfCommandTemplateExt value) {
        this.possibleCommands = value;
    }

}
