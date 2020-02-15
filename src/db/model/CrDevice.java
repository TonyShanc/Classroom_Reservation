package db.model;

/**
 * �豸ʵ�弯������
 *
 * @author ����
 * @version 0.1
 */

public class CrDevice implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String device_id = null;
    private String version = null;
    private String unit = null;
    private String device_name = null;

    public CrDevice() {

    }

    public void setDeviceId(String device_id) {
        this.device_id = device_id;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDeviceName(String device_name) {
        this.device_name = device_name;
    }

    public String getDeviceId() {
        return device_id;
    }

    public String getVersion() {
        return version;
    }

    public String getUnit() {
        return unit;
    }

    public String getDeviceName() {
        return device_name;
    }
}
