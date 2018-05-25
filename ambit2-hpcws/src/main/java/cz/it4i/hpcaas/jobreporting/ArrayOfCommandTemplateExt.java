
package cz.it4i.hpcaas.jobreporting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCommandTemplateExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCommandTemplateExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommandTemplateExt" type="{http://hpcaas.it4i.cz/}CommandTemplateExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCommandTemplateExt", propOrder = {
    "commandTemplateExt"
})
public class ArrayOfCommandTemplateExt {

    @XmlElement(name = "CommandTemplateExt", nillable = true)
    protected List<CommandTemplateExt> commandTemplateExt;

    /**
     * Gets the value of the commandTemplateExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commandTemplateExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommandTemplateExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandTemplateExt }
     * 
     * 
     */
    public List<CommandTemplateExt> getCommandTemplateExt() {
        if (commandTemplateExt == null) {
            commandTemplateExt = new ArrayList<CommandTemplateExt>();
        }
        return this.commandTemplateExt;
    }

}
