
package cz.it4i.hpcaas.filetransfer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJobFileContentExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJobFileContentExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JobFileContentExt" type="{http://hpcaas.it4i.cz/}JobFileContentExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJobFileContentExt", propOrder = {
    "jobFileContentExt"
})
public class ArrayOfJobFileContentExt {

    @XmlElement(name = "JobFileContentExt", nillable = true)
    protected List<JobFileContentExt> jobFileContentExt;

    /**
     * Gets the value of the jobFileContentExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobFileContentExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobFileContentExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JobFileContentExt }
     * 
     * 
     */
    public List<JobFileContentExt> getJobFileContentExt() {
        if (jobFileContentExt == null) {
            jobFileContentExt = new ArrayList<JobFileContentExt>();
        }
        return this.jobFileContentExt;
    }

}
