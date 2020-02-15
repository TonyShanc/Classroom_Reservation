package db.model;

import java.sql.Timestamp;

/**
 * Ԥ����Ϣ������
 *
 * @author ����
 * @version 0.1
 */

public class CrOrderInfo implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String order_id = null;
    private Timestamp creation_time = null;
    private Timestamp begin_time = null;
    private Timestamp end_time = null;
    private String user_id = null;
    private String building = null;
    private String room_number = null;
    private String reason = null;
//	private CrClassroom classroom = null;

    public CrOrderInfo() {

    }

    /*	public void setCrClassroom(CrClassroom classroom) {
            this.classroom = classroom;
        }
    */
    public void setOrderId(String order_id) {
        this.order_id = order_id;
    }

    public void setCreationTime(Timestamp creation_time) {
        this.creation_time = creation_time;
    }

    public void setBeginTime(Timestamp begin_time) {
        this.begin_time = begin_time;
    }

    public void setEndTime(Timestamp end_time) {
        this.end_time = end_time;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrderId() {
        return order_id;
    }

    public Timestamp getCreationTime() {
        return creation_time;
    }

    public Timestamp getBeginTime() {
        return begin_time;
    }

    public Timestamp getEndTime() {
        return end_time;
    }

    public String getUserId() {
        return user_id;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoomNumber() {
        return room_number;
    }

    public String getReason() {
        return reason;
    }

}
