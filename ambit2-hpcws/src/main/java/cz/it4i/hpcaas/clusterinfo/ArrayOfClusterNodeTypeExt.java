
package cz.it4i.hpcaas.clusterinfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterNodeTypeExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterNodeTypeExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterNodeTypeExt" type="{http://hpcaas.it4i.cz/}ClusterNodeTypeExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterNodeTypeExt", propOrder = {
    "clusterNodeTypeExt"
})
public class ArrayOfClusterNodeTypeExt {

    @XmlElement(name = "ClusterNodeTypeExt", nillable = true)
    protected List<ClusterNodeTypeExt> clusterNodeTypeExt;

    /**
     * Gets the value of the clusterNodeTypeExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterNodeTypeExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterNodeTypeExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterNodeTypeExt }
     * 
     * 
     */
    public List<ClusterNodeTypeExt> getClusterNodeTypeExt() {
        if (clusterNodeTypeExt == null) {
            clusterNodeTypeExt = new ArrayList<ClusterNodeTypeExt>();
        }
        return this.clusterNodeTypeExt;
    }

}
