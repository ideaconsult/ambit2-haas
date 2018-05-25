
package cz.it4i.hpcaas.filetransfer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTaskFileOffsetExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTaskFileOffsetExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaskFileOffsetExt" type="{http://hpcaas.it4i.cz/}TaskFileOffsetExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTaskFileOffsetExt", propOrder = {
    "taskFileOffsetExt"
})
public class ArrayOfTaskFileOffsetExt {

    @XmlElement(name = "TaskFileOffsetExt", nillable = true)
    protected List<TaskFileOffsetExt> taskFileOffsetExt;

    /**
     * Gets the value of the taskFileOffsetExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskFileOffsetExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskFileOffsetExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskFileOffsetExt }
     * 
     * 
     */
    public List<TaskFileOffsetExt> getTaskFileOffsetExt() {
        if (taskFileOffsetExt == null) {
            taskFileOffsetExt = new ArrayList<TaskFileOffsetExt>();
        }
        return this.taskFileOffsetExt;
    }

}
