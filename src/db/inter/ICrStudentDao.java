package db.inter;

import java.sql.SQLException;

import db.model.CrStudent;

public interface ICrStudentDao {
    void insert(CrStudent obj) throws SQLException;

    void delete(String id) throws SQLException;

    void update(CrStudent obj) throws SQLException;

    CrStudent select(String id) throws SQLException;

    void updatePasswordMail(String id, String password, String mail) throws SQLException;

    CrStudent findByIdPassword(String id, String password) throws SQLException;
}
