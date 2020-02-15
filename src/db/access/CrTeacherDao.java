package db.access;

import java.sql.Connection;
import java.sql.SQLException;

import db.inter.ICrTeacherDao;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import db.model.CrStudent;
import db.model.CrTeacher;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrTeacherDao implements ICrTeacherDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);
    BeanHandler<CrTeacher> beanHandler = new BeanHandler<>(CrTeacher.class);

    @Override
    public void insert(CrTeacher obj) throws SQLException {
        String sql = "insert into teacher values(?,?,?,?,?)";
        qr.update(conn, sql, obj.getId(), obj.getName(), obj.getPassword(), obj.getDeptName());
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from teacher where id = ?;";
        qr.update(conn, sql, id);
    }

    @Override
    public void update(CrTeacher obj) throws SQLException {
        String sql = "update teacher set name = ?, mail = ?, password = ?, dept_name = ? where id = ?";
        qr.update(conn, sql, obj.getDeptName(), obj.getMail(), obj.getPassword(), obj.getDeptName(), obj.getId());

    }

    public CrTeacher findByIdPassword(String id, String password) throws SQLException {
        String sql = "select * from Teacher where id = ? and password = ?;";
        return qr.query(conn, sql, beanHandler, id, password);
    }

    public void updatePasswordMail(String id, String password, String mail) throws SQLException {
        String sql = "update student set password = ?, mail = ? where id = ?";
        qr.update(conn, sql, password, mail, id);
    }

    public CrTeacher select(String id) throws SQLException {
        String sql = "select * from teacher where ID = ?;";
        return qr.query(conn, sql, new BeanHandler<CrTeacher>(CrTeacher.class, processor), id);
    }
}
