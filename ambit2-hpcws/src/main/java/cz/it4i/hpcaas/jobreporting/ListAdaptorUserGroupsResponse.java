
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListAdaptorUserGroupsResult" type="{http://hpcaas.it4i.cz/}ArrayOfAdaptorUserGroupExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listAdaptorUserGroupsResult"
})
@XmlRootElement(name = "ListAdaptorUserGroupsResponse")
public class ListAdaptorUserGroupsResponse {

    @XmlElement(name = "ListAdaptorUserGroupsResult")
    protected ArrayOfAdaptorUserGroupExt listAdaptorUserGroupsResult;

    /**
     * Gets the value of the listAdaptorUserGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAdaptorUserGroupExt }
     *     
     */
    public ArrayOfAdaptorUserGroupExt getListAdaptorUserGroupsResult() {
        return listAdaptorUserGroupsResult;
    }

    /**
     * Sets the value of the listAdaptorUserGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAdaptorUserGroupExt }
     *     
     */
    public void setListAdaptorUserGroupsResult(ArrayOfAdaptorUserGroupExt value) {
        this.listAdaptorUserGroupsResult = value;
    }

}
