package db.inter;

import java.sql.SQLException;

import db.model.CrCompanyRepre;

public interface ICrCompanyRepreDao {
    CrCompanyRepre findOne(String Id, String password) throws SQLException;

    CrCompanyRepre select(String id) throws SQLException;

    void insert(CrCompanyRepre obj) throws SQLException;

    void delete(String id) throws SQLException;

    void update(CrCompanyRepre obj) throws SQLException;

    void updatePasswordMail(String id, String password, String mail) throws SQLException;

    void updateInfo(String id, String password, String companyName, String position, String area, String mail) throws SQLException;
}
