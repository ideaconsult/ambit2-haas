
package cz.it4i.hpcaas.jobreporting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUserAggregatedUsageExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUserAggregatedUsageExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserAggregatedUsageExt" type="{http://hpcaas.it4i.cz/}UserAggregatedUsageExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUserAggregatedUsageExt", propOrder = {
    "userAggregatedUsageExt"
})
public class ArrayOfUserAggregatedUsageExt {

    @XmlElement(name = "UserAggregatedUsageExt", nillable = true)
    protected List<UserAggregatedUsageExt> userAggregatedUsageExt;

    /**
     * Gets the value of the userAggregatedUsageExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userAggregatedUsageExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserAggregatedUsageExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserAggregatedUsageExt }
     * 
     * 
     */
    public List<UserAggregatedUsageExt> getUserAggregatedUsageExt() {
        if (userAggregatedUsageExt == null) {
            userAggregatedUsageExt = new ArrayList<UserAggregatedUsageExt>();
        }
        return this.userAggregatedUsageExt;
    }

}
