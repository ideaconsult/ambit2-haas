
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SynchronizableFilesExt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SynchronizableFilesExt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LogFile"/>
 *     &lt;enumeration value="ProgressFile"/>
 *     &lt;enumeration value="StandardErrorFile"/>
 *     &lt;enumeration value="StandardOutputFile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SynchronizableFilesExt")
@XmlEnum
public enum SynchronizableFilesExt {

    @XmlEnumValue("LogFile")
    LOG_FILE("LogFile"),
    @XmlEnumValue("ProgressFile")
    PROGRESS_FILE("ProgressFile"),
    @XmlEnumValue("StandardErrorFile")
    STANDARD_ERROR_FILE("StandardErrorFile"),
    @XmlEnumValue("StandardOutputFile")
    STANDARD_OUTPUT_FILE("StandardOutputFile");
    private final String value;

    SynchronizableFilesExt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SynchronizableFilesExt fromValue(String v) {
        for (SynchronizableFilesExt c: SynchronizableFilesExt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
