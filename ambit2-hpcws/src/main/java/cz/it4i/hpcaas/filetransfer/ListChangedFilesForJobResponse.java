
package cz.it4i.hpcaas.filetransfer;

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
 *         &lt;element name="ListChangedFilesForJobResult" type="{http://hpcaas.it4i.cz/}ArrayOfString" minOccurs="0"/>
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
    "listChangedFilesForJobResult"
})
@XmlRootElement(name = "ListChangedFilesForJobResponse")
public class ListChangedFilesForJobResponse {

    @XmlElement(name = "ListChangedFilesForJobResult")
    protected ArrayOfString listChangedFilesForJobResult;

    /**
     * Gets the value of the listChangedFilesForJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getListChangedFilesForJobResult() {
        return listChangedFilesForJobResult;
    }

    /**
     * Sets the value of the listChangedFilesForJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setListChangedFilesForJobResult(ArrayOfString value) {
        this.listChangedFilesForJobResult = value;
    }

}
