
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobStateExt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JobStateExt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Configuring"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Queued"/>
 *     &lt;enumeration value="Running"/>
 *     &lt;enumeration value="Finished"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Canceled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JobStateExt")
@XmlEnum
public enum JobStateExt {

    @XmlEnumValue("Configuring")
    CONFIGURING("Configuring"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Queued")
    QUEUED("Queued"),
    @XmlEnumValue("Running")
    RUNNING("Running"),
    @XmlEnumValue("Finished")
    FINISHED("Finished"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled");
    private final String value;

    JobStateExt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JobStateExt fromValue(String v) {
        for (JobStateExt c: JobStateExt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
