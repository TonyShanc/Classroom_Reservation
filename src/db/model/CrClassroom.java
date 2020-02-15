package db.model;

/**
 * ���ҵ�����
 *
 * @author ����
 * @version 0.1
 */

public class CrClassroom implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    String building = null;
    String roomNumber = null;
    String capacity = null;

    public CrClassroom() {

    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setRoomNumber(String room_number) {
        this.roomNumber = room_number;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCapacity() {
        return capacity;
    }

}
