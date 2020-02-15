package db.inter;

import java.sql.SQLException;

import db.model.CrTeacher;

public interface ICrTeacherDao {
    void insert(CrTeacher obj) throws SQLException;

    CrTeacher select(String id) throws SQLException;

    void delete(String id) throws SQLException;

    void update(CrTeacher obj) throws SQLException;

    CrTeacher findByIdPassword(String id, String password) throws SQLException;

    void updatePasswordMail(String id, String password, String mail) throws SQLException;
}
