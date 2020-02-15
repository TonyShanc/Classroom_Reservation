package db.access;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;

import util.MySQLhelper;
import db.model.CrAdmin;
import util.JdbcUtils;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import db.inter.ICrAdminDao;

public class CrAdminDao implements ICrAdminDao {

    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public void insert(CrAdmin obj) throws SQLException {
        String sql = "insert into admin values(?,?,?,?);";
        qr.update(conn, sql, obj.getId(), obj.getName(), obj.getPassword(), obj.getMail());
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from admin where id = ?;";
        qr.update(conn, sql, id);
    }

    @Override
    public void update(CrAdmin obj) throws SQLException {
        String sql = "update admin set name = ?,password = ?, mail = ?,where id = ?;";
        qr.update(conn, sql, obj.getName(), obj.getPassword(), obj.getMail(), obj.getId());
    }

    @Override
    public CrAdmin findOne(String adminId, String adminPassword) throws SQLException {
        String sql = "select * from admin where ID = ? and password = ?;";
        return qr.query(conn, sql, new BeanHandler<CrAdmin>(CrAdmin.class), adminId, adminPassword);

    }

    @Override
    public List<CrAdmin> findAll() throws SQLException {
        String sql = "select * from admin;";
        return qr.query(conn, sql, new BeanListHandler<CrAdmin>(CrAdmin.class));

    }

    public void updatePassword(String id, String password) throws SQLException {
        String sql = "update admin set password = ? where id = ?;";
        qr.update(conn, sql, password, id);
    }

    public List<CrAdmin> findPage(Integer pageNo, Integer pageSize) throws SQLException {
        String sql = "select * from admin limit " + (pageNo - 1) * pageSize + "," + pageSize + ";";
        return qr.query(conn, sql, new BeanListHandler<CrAdmin>(CrAdmin.class, processor));
    }
}