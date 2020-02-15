package db.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import db.service.ICrDeleteService;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrDeleteService implements ICrDeleteService {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();

    @Override
    public void deleteByUserAndOrderId(Integer orderId) throws SQLException {
        String sql1 = "delete from order_info where order_id = ?;";
        String sql2 = "delete from review where order_id = ?;";
        qr.update(conn, sql2, orderId);
        qr.update(conn, sql1, orderId);
    }
}
