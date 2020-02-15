package db.inter;

import java.sql.SQLException;
import java.util.List;

import db.model.CrFault;

public interface ICrFaultDao {
    List<CrFault> selectAll() throws SQLException;

    void updateState(String faultId, String adminId) throws SQLException;

    void insert(CrFault obj) throws SQLException;

    List<CrFault> selectPage(Integer pageNo, Integer pageSize) throws SQLException;
}
