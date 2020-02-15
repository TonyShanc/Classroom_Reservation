package db.access;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import db.inter.ICrCompanyRepreDao;
import db.model.CrCompanyRepre;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrCompanyRepreDao implements ICrCompanyRepreDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public void insert(CrCompanyRepre obj) throws SQLException {
        String sql = "insert into company_repre values(?,?,?,?,?,?,?);";
        qr.update(conn, sql, obj.getId(), obj.getName(), obj.getMail(), obj.getPassword(), obj.getCompanyName(), obj.getPosition(), obj.getArea());

    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from company_repre where id = ?;";
        qr.update(conn, sql, id);
    }

    @Override
    public void update(CrCompanyRepre obj) throws SQLException {
        String sql = "update company_repre set name = ?, mail=?, password = ?, company_name = ?, position = ?, area = ? where id = ?;";
        qr.update(conn, sql, obj.getName(), obj.getMail(), obj.getPassword(), obj.getCompanyName(), obj.getPosition(), obj.getArea(), obj.getId());

    }

    @Override
    public CrCompanyRepre findOne(String Id, String password) throws SQLException {
        String sql = "select * from company_repre where id = ? and password = ?;";
        return qr.query(conn, sql, new BeanHandler<CrCompanyRepre>(CrCompanyRepre.class, processor), Id, password);
    }

    @Override
    public void updatePasswordMail(String id, String password, String mail) throws SQLException {
        String sql = "update student set password = ?, mail = ? where id = ?;";
        qr.update(conn, sql, password, mail, id);
    }

    @Override
    public void updateInfo(String id, String password, String companyName, String position, String area, String mail) throws SQLException {
        String sql = "update company_repre set password=?, company_name=?, position=?, area=?, mail=? where id=?;";
        qr.update(conn, sql, password, companyName, position, area, mail, id);
    }

    @Override
    public CrCompanyRepre select(String id) throws SQLException {
        String sql = "select * from company_repre where ID = ?;";
        return qr.query(conn, sql, new BeanHandler<CrCompanyRepre>(CrCompanyRepre.class, processor), id);
    }
}
