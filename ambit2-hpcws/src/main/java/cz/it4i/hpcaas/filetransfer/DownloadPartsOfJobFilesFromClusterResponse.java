
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
 *         &lt;element name="DownloadPartsOfJobFilesFromClusterResult" type="{http://hpcaas.it4i.cz/}ArrayOfJobFileContentExt" minOccurs="0"/>
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
    "downloadPartsOfJobFilesFromClusterResult"
})
@XmlRootElement(name = "DownloadPartsOfJobFilesFromClusterResponse")
public class DownloadPartsOfJobFilesFromClusterResponse {

    @XmlElement(name = "DownloadPartsOfJobFilesFromClusterResult")
    protected ArrayOfJobFileContentExt downloadPartsOfJobFilesFromClusterResult;

    /**
     * Gets the value of the downloadPartsOfJobFilesFromClusterResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJobFileContentExt }
     *     
     */
    public ArrayOfJobFileContentExt getDownloadPartsOfJobFilesFromClusterResult() {
        return downloadPartsOfJobFilesFromClusterResult;
    }

    /**
     * Sets the value of the downloadPartsOfJobFilesFromClusterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJobFileContentExt }
     *     
     */
    public void setDownloadPartsOfJobFilesFromClusterResult(ArrayOfJobFileContentExt value) {
        this.downloadPartsOfJobFilesFromClusterResult = value;
    }

}
