package db.service;

import db.model.*;

import java.sql.SQLException;
import java.util.List;

public interface ICrSDeviceService {
    List<CrSDevice> findDevice(String building, String roomNumber) throws SQLException;
}
