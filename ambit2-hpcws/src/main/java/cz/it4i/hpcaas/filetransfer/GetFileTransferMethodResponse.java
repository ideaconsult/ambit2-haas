
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
 *         &lt;element name="GetFileTransferMethodResult" type="{http://hpcaas.it4i.cz/}FileTransferMethodExt" minOccurs="0"/>
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
    "getFileTransferMethodResult"
})
@XmlRootElement(name = "GetFileTransferMethodResponse")
public class GetFileTransferMethodResponse {

    @XmlElement(name = "GetFileTransferMethodResult")
    protected FileTransferMethodExt getFileTransferMethodResult;

    /**
     * Gets the value of the getFileTransferMethodResult property.
     * 
     * @return
     *     possible object is
     *     {@link FileTransferMethodExt }
     *     
     */
    public FileTransferMethodExt getGetFileTransferMethodResult() {
        return getFileTransferMethodResult;
    }

    /**
     * Sets the value of the getFileTransferMethodResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileTransferMethodExt }
     *     
     */
    public void setGetFileTransferMethodResult(FileTransferMethodExt value) {
        this.getFileTransferMethodResult = value;
    }

}
