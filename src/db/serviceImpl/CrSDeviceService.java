package db.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import db.model.CrSDevice;
import db.service.*;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrSDeviceService implements ICrSDeviceService {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public List<CrSDevice> findDevice(String building, String roomNumber) throws SQLException {
        // TODO Auto-generated method stub
        String sql = "call GetClassroomDevice(?,?);";
        return qr.query(conn, sql, new BeanListHandler<CrSDevice>(CrSDevice.class, processor), building, roomNumber);

    }

}