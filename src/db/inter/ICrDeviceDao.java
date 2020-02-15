package db.inter;

import db.model.CrDevice;

import java.sql.SQLException;

public interface ICrDeviceDao {
    CrDevice findByDeviceId(String device_id) throws SQLException;

    //	List<CrDevice> findByDeviceName(String device_Name) throws SQLException;
    void update(CrDevice obj) throws SQLException;

    void delete(String id) throws SQLException;

    void insert(CrDevice obj) throws SQLException;


}
