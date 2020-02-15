package db.access;

import db.model.CrDevice;
import util.JdbcUtils;
import util.MySQLhelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;

import db.inter.ICrEquippedDao;

public class CrEquippedDao implements ICrEquippedDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);

    public List<CrDevice> findDeviceByClassroom(String building, String roomNumber) throws SQLException {
        String sql = "call ";
        return null;

    }

}
