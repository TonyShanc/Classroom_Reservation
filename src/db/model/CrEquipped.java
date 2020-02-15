package db.model;

/**
 * �����Ǳ���ϵ��
 *
 * @author ����
 * @version 0.1
 */

public class CrEquipped implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String building = null;
    private String device_id = null;
    private String room_number = null;
    private String available_num = null;

    public CrEquipped() {

    }


    public void setBuilding(String building) {
        this.building = building;
    }

    public void setDeviceId(String device_id) {
        this.device_id = device_id;
    }

    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    public void setAvailableNum(String available_num) {
        this.available_num = available_num;
    }

    public String getBuilding() {
        return building;
    }

    public String getDeviceId() {
        return this.device_id;
    }

    public String getRoomNumber() {
        return room_number;
    }

    public String getAvailableNum() {
        return available_num;
    }
}
