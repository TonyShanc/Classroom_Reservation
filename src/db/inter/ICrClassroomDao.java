package db.inter;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import db.model.CrClassroom;

public interface ICrClassroomDao {
    List<CrClassroom> findPageByBuilding(String catBuilding, Integer pageSize, Integer pageNo) throws SQLException;

    List<CrClassroom> findByCapacityMore(String least_capacity) throws SQLException;

    void delete(String building, String roomNum) throws SQLException;

    void insert(CrClassroom obj) throws SQLException;

    void update(CrClassroom obj) throws SQLException;

    List<CrClassroom> findIdleClassroom(Timestamp beginTime, Timestamp endTime, Integer pageNo, Integer pageSize) throws SQLException;
}
