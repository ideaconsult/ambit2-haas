
package cz.it4i.hpcaas.usermgmgmt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCommandTemplateParameterExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCommandTemplateParameterExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommandTemplateParameterExt" type="{http://hpcaas.it4i.cz/}CommandTemplateParameterExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCommandTemplateParameterExt", propOrder = {
    "commandTemplateParameterExt"
})
public class ArrayOfCommandTemplateParameterExt {

    @XmlElement(name = "CommandTemplateParameterExt", nillable = true)
    protected List<CommandTemplateParameterExt> commandTemplateParameterExt;

    /**
     * Gets the value of the commandTemplateParameterExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commandTemplateParameterExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommandTemplateParameterExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandTemplateParameterExt }
     * 
     * 
     */
    public List<CommandTemplateParameterExt> getCommandTemplateParameterExt() {
        if (commandTemplateParameterExt == null) {
            commandTemplateParameterExt = new ArrayList<CommandTemplateParameterExt>();
        }
        return this.commandTemplateParameterExt;
    }

}
