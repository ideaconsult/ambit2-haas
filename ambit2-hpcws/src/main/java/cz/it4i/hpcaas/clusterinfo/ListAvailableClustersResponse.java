
package cz.it4i.hpcaas.clusterinfo;

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
 *         &lt;element name="ListAvailableClustersResult" type="{http://hpcaas.it4i.cz/}ArrayOfClusterInfoExt" minOccurs="0"/>
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
    "listAvailableClustersResult"
})
@XmlRootElement(name = "ListAvailableClustersResponse")
public class ListAvailableClustersResponse {

    @XmlElement(name = "ListAvailableClustersResult")
    protected ArrayOfClusterInfoExt listAvailableClustersResult;

    /**
     * Gets the value of the listAvailableClustersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClusterInfoExt }
     *     
     */
    public ArrayOfClusterInfoExt getListAvailableClustersResult() {
        return listAvailableClustersResult;
    }

    /**
     * Sets the value of the listAvailableClustersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClusterInfoExt }
     *     
     */
    public void setListAvailableClustersResult(ArrayOfClusterInfoExt value) {
        this.listAvailableClustersResult = value;
    }

}
