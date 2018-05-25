
package cz.it4i.hpcaas.filetransfer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileTransferProtocolExt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileTransferProtocolExt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NetworkShare"/>
 *     &lt;enumeration value="SftpScp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileTransferProtocolExt")
@XmlEnum
public enum FileTransferProtocolExt {

    @XmlEnumValue("NetworkShare")
    NETWORK_SHARE("NetworkShare"),
    @XmlEnumValue("SftpScp")
    SFTP_SCP("SftpScp");
    private final String value;

    FileTransferProtocolExt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FileTransferProtocolExt fromValue(String v) {
        for (FileTransferProtocolExt c: FileTransferProtocolExt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
