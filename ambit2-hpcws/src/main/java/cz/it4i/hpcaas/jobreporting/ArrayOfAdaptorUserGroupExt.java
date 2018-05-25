
package cz.it4i.hpcaas.jobreporting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAdaptorUserGroupExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAdaptorUserGroupExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdaptorUserGroupExt" type="{http://hpcaas.it4i.cz/}AdaptorUserGroupExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAdaptorUserGroupExt", propOrder = {
    "adaptorUserGroupExt"
})
public class ArrayOfAdaptorUserGroupExt {

    @XmlElement(name = "AdaptorUserGroupExt", nillable = true)
    protected List<AdaptorUserGroupExt> adaptorUserGroupExt;

    /**
     * Gets the value of the adaptorUserGroupExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adaptorUserGroupExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdaptorUserGroupExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdaptorUserGroupExt }
     * 
     * 
     */
    public List<AdaptorUserGroupExt> getAdaptorUserGroupExt() {
        if (adaptorUserGroupExt == null) {
            adaptorUserGroupExt = new ArrayList<AdaptorUserGroupExt>();
        }
        return this.adaptorUserGroupExt;
    }

}
