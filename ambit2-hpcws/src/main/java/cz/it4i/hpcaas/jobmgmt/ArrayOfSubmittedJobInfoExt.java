
package cz.it4i.hpcaas.jobmgmt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSubmittedJobInfoExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSubmittedJobInfoExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubmittedJobInfoExt" type="{http://hpcaas.it4i.cz/}SubmittedJobInfoExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSubmittedJobInfoExt", propOrder = {
    "submittedJobInfoExt"
})
public class ArrayOfSubmittedJobInfoExt {

    @XmlElement(name = "SubmittedJobInfoExt", nillable = true)
    protected List<SubmittedJobInfoExt> submittedJobInfoExt;

    /**
     * Gets the value of the submittedJobInfoExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the submittedJobInfoExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubmittedJobInfoExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubmittedJobInfoExt }
     * 
     * 
     */
    public List<SubmittedJobInfoExt> getSubmittedJobInfoExt() {
        if (submittedJobInfoExt == null) {
            submittedJobInfoExt = new ArrayList<SubmittedJobInfoExt>();
        }
        return this.submittedJobInfoExt;
    }

}
