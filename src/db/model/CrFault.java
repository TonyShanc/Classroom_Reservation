package db.model;

import java.sql.Timestamp;

public class CrFault implements java.io.Serializable {

    private String faultId = null;
    private String userId = null;
    private String adminId = null;
    private String building = null;
    private String roomNumber = null;
    private String context = null;
    private String verifyState = "wait";
    private Timestamp stime = null;

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setVerifyState(String verifyState) {
        this.verifyState = verifyState;
    }

    public void setStime(Timestamp stime) {
        this.stime = stime;
    }


    public String getAdminId() {
        return adminId;
    }

    public String getFaultId() {
        return faultId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getContext() {
        return context;
    }

    public String getVerifyState() {
        return verifyState;
    }

    public Timestamp getStime() {
        return stime;
    }

}
