
package cz.it4i.hpcaas.jobmgmt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEnvironmentVariableExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEnvironmentVariableExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EnvironmentVariableExt" type="{http://hpcaas.it4i.cz/}EnvironmentVariableExt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEnvironmentVariableExt", propOrder = {
    "environmentVariableExt"
})
public class ArrayOfEnvironmentVariableExt {

    @XmlElement(name = "EnvironmentVariableExt", nillable = true)
    protected List<EnvironmentVariableExt> environmentVariableExt;

    /**
     * Gets the value of the environmentVariableExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the environmentVariableExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvironmentVariableExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvironmentVariableExt }
     * 
     * 
     */
    public List<EnvironmentVariableExt> getEnvironmentVariableExt() {
        if (environmentVariableExt == null) {
            environmentVariableExt = new ArrayList<EnvironmentVariableExt>();
        }
        return this.environmentVariableExt;
    }

}
