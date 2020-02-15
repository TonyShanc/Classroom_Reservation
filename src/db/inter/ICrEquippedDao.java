package db.inter;

import java.sql.SQLException;
import java.util.List;

import db.model.CrClassroom;
import db.model.CrDevice;

public interface ICrEquippedDao {
    List<CrDevice> findDeviceByClassroom(String building, String roomNumber) throws SQLException;
}
