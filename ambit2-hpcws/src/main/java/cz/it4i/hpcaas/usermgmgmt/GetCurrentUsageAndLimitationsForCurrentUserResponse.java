
package cz.it4i.hpcaas.usermgmgmt;

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
 *         &lt;element name="GetCurrentUsageAndLimitationsForCurrentUserResult" type="{http://hpcaas.it4i.cz/}ArrayOfResourceUsageExt" minOccurs="0"/>
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
    "getCurrentUsageAndLimitationsForCurrentUserResult"
})
@XmlRootElement(name = "GetCurrentUsageAndLimitationsForCurrentUserResponse")
public class GetCurrentUsageAndLimitationsForCurrentUserResponse {

    @XmlElement(name = "GetCurrentUsageAndLimitationsForCurrentUserResult")
    protected ArrayOfResourceUsageExt getCurrentUsageAndLimitationsForCurrentUserResult;

    /**
     * Gets the value of the getCurrentUsageAndLimitationsForCurrentUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResourceUsageExt }
     *     
     */
    public ArrayOfResourceUsageExt getGetCurrentUsageAndLimitationsForCurrentUserResult() {
        return getCurrentUsageAndLimitationsForCurrentUserResult;
    }

    /**
     * Sets the value of the getCurrentUsageAndLimitationsForCurrentUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResourceUsageExt }
     *     
     */
    public void setGetCurrentUsageAndLimitationsForCurrentUserResult(ArrayOfResourceUsageExt value) {
        this.getCurrentUsageAndLimitationsForCurrentUserResult = value;
    }

}
