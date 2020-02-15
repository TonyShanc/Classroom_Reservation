package db.inter;

import java.sql.SQLException;

import db.model.CrAdmin;

import java.io.Serializable;
import java.util.List;

public interface ICrAdminDao {
    CrAdmin findOne(String adminId, String adminPassword) throws SQLException;

    void insert(CrAdmin obj) throws SQLException;

    void delete(String id) throws SQLException;

    void update(CrAdmin obj) throws SQLException;

    void updatePassword(String id, String password) throws SQLException;

    List<CrAdmin> findAll() throws SQLException;

    List<CrAdmin> findPage(Integer pageNo, Integer pageSize) throws SQLException;
}