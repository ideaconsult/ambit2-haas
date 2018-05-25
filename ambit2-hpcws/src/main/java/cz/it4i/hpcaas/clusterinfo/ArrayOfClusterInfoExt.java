
package cz.it4i.hpcaas.clusterinfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterInfoExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterInfoExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterInfoExt" type="{http://hpcaas.it4i.cz/}ClusterInfoExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterInfoExt", propOrder = {
    "clusterInfoExt"
})
public class ArrayOfClusterInfoExt {

    @XmlElement(name = "ClusterInfoExt", nillable = true)
    protected List<ClusterInfoExt> clusterInfoExt;

    /**
     * Gets the value of the clusterInfoExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterInfoExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterInfoExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterInfoExt }
     * 
     * 
     */
    public List<ClusterInfoExt> getClusterInfoExt() {
        if (clusterInfoExt == null) {
            clusterInfoExt = new ArrayList<ClusterInfoExt>();
        }
        return this.clusterInfoExt;
    }

}
