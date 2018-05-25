
package cz.it4i.hpcaas.jobreporting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNodeTypeAggregatedUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNodeTypeAggregatedUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NodeTypeAggregatedUsageExt" type="{http://hpcaas.it4i.cz/}NodeTypeAggregatedUsageExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNodeTypeAggregatedUsageExt", propOrder = {
    "nodeTypeAggregatedUsageExt"
})
public class ArrayOfNodeTypeAggregatedUsageExt {

    @XmlElement(name = "NodeTypeAggregatedUsageExt", nillable = true)
    protected List<NodeTypeAggregatedUsageExt> nodeTypeAggregatedUsageExt;

    /**
     * Gets the value of the nodeTypeAggregatedUsageExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodeTypeAggregatedUsageExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodeTypeAggregatedUsageExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NodeTypeAggregatedUsageExt }
     * 
     * 
     */
    public List<NodeTypeAggregatedUsageExt> getNodeTypeAggregatedUsageExt() {
        if (nodeTypeAggregatedUsageExt == null) {
            nodeTypeAggregatedUsageExt = new ArrayList<NodeTypeAggregatedUsageExt>();
        }
        return this.nodeTypeAggregatedUsageExt;
    }

}
