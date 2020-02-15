package db.access;

import db.model.CrCompanyRepre;
import db.model.CrStudent;
import util.JdbcUtils;
import util.MySQLhelper;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;

import db.inter.ICrStudentDao;;

public class CrStudentDao implements ICrStudentDao {

    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);
    BeanHandler<CrStudent> beanHandler = new BeanHandler<>(CrStudent.class);

    @Override
    public void insert(CrStudent obj) throws SQLException {
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        qr.update(conn, sql, obj.getId(), obj.getName(), obj.getMail(), obj.getPassword(), obj.getEnrollment(), obj.getStuType(), obj.getDeptName());
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from student where id = ?;";
        qr.update(conn, sql, id);
    }

    @Override
    public void update(CrStudent obj) throws SQLException {
        String sql = "update student set name = ?, mail = ?, password = ?, enrollment = ?, stu_type = ?, dept_name = ? where id = ?";
        qr.update(conn, sql, obj.getDeptName(), obj.getMail(), obj.getPassword(), obj.getEnrollment(), obj.getStuType(), obj.getDeptName(), obj.getId());

    }

    public CrStudent findByIdPassword(String id, String password) throws SQLException {
        String sql = "select * from student where id = ? and password = ?;";
        return qr.query(conn, sql, beanHandler, id, password);
    }

    public void updatePasswordMail(String id, String password, String mail) throws SQLException {
        String sql = "update student set password = ?, mail = ? where id = ?";
        qr.update(conn, sql, password, mail, id);
    }

    @Override
    public CrStudent select(String id) throws SQLException {
        String sql = "select * from student where ID = ?;";
        return qr.query(conn, sql, new BeanHandler<CrStudent>(CrStudent.class, processor), id);
    }
}
