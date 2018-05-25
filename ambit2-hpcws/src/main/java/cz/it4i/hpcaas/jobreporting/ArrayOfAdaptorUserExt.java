
package cz.it4i.hpcaas.jobreporting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAdaptorUserExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAdaptorUserExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdaptorUserExt" type="{http://hpcaas.it4i.cz/}AdaptorUserExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAdaptorUserExt", propOrder = {
    "adaptorUserExt"
})
public class ArrayOfAdaptorUserExt {

    @XmlElement(name = "AdaptorUserExt", nillable = true)
    protected List<AdaptorUserExt> adaptorUserExt;

    /**
     * Gets the value of the adaptorUserExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adaptorUserExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdaptorUserExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdaptorUserExt }
     * 
     * 
     */
    public List<AdaptorUserExt> getAdaptorUserExt() {
        if (adaptorUserExt == null) {
            adaptorUserExt = new ArrayList<AdaptorUserExt>();
        }
        return this.adaptorUserExt;
    }

}
