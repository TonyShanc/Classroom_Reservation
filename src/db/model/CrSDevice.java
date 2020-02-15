package db.model;

public class CrSDevice implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String deviceName = null;
    Integer availableNum = null;

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }
}
