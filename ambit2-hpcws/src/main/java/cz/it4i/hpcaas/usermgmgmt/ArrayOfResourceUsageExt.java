
package cz.it4i.hpcaas.usermgmgmt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfResourceUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfResourceUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResourceUsageExt" type="{http://hpcaas.it4i.cz/}ResourceUsageExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfResourceUsageExt", propOrder = {
    "resourceUsageExt"
})
public class ArrayOfResourceUsageExt {

    @XmlElement(name = "ResourceUsageExt", nillable = true)
    protected List<ResourceUsageExt> resourceUsageExt;

    /**
     * Gets the value of the resourceUsageExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceUsageExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceUsageExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceUsageExt }
     * 
     * 
     */
    public List<ResourceUsageExt> getResourceUsageExt() {
        if (resourceUsageExt == null) {
            resourceUsageExt = new ArrayList<ResourceUsageExt>();
        }
        return this.resourceUsageExt;
    }

}
