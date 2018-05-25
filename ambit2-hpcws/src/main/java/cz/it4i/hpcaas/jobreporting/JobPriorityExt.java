
package cz.it4i.hpcaas.jobreporting;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobPriorityExt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JobPriorityExt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Lowest"/>
 *     &lt;enumeration value="VeryLow"/>
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="BelowAverage"/>
 *     &lt;enumeration value="Average"/>
 *     &lt;enumeration value="AboveAverage"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="VeryHigh"/>
 *     &lt;enumeration value="Critical"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JobPriorityExt")
@XmlEnum
public enum JobPriorityExt {

    @XmlEnumValue("Lowest")
    LOWEST("Lowest"),
    @XmlEnumValue("VeryLow")
    VERY_LOW("VeryLow"),
    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("BelowAverage")
    BELOW_AVERAGE("BelowAverage"),
    @XmlEnumValue("Average")
    AVERAGE("Average"),
    @XmlEnumValue("AboveAverage")
    ABOVE_AVERAGE("AboveAverage"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("VeryHigh")
    VERY_HIGH("VeryHigh"),
    @XmlEnumValue("Critical")
    CRITICAL("Critical");
    private final String value;

    JobPriorityExt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JobPriorityExt fromValue(String v) {
        for (JobPriorityExt c: JobPriorityExt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
