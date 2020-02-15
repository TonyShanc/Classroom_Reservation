package db.access;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import db.model.CrDevice;
import db.inter.ICrDeviceDao;
import util.JdbcUtils;
import util.MySQLhelper;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class CrDeviceDao implements ICrDeviceDao {

    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();

    @Override
    public void insert(CrDevice obj) throws SQLException {
        String sql = "insert into device values(?,?,?,?);";
        qr.update(conn, sql, obj.getDeviceId(), obj.getDeviceName(), obj.getUnit(), obj.getVersion());

    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from deivce where device_id = ?";
        qr.update(conn, sql, id);
    }

    @Override
    public void update(CrDevice obj) throws SQLException {
        String sql = "update device set deivce_name = ?, unit = ?, version = ? where device_id = ?;";
        qr.update(conn, sql, obj.getDeviceName(), obj.getUnit(), obj.getVersion(), obj.getDeviceId());

    }

    @Override
    public CrDevice findByDeviceId(String device_id) throws SQLException {
        String sql = "select * from deivce where deivce_id = ?;";
        return qr.query(conn, sql, new BeanHandler<CrDevice>(CrDevice.class), device_id);
    }
}
