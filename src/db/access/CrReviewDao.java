package db.access;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;

import db.inter.ICrReviewDao;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrReviewDao implements ICrReviewDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public void updatePass(String orderId, String adminId, String reason) throws SQLException {
        String sql = "update review set admin_id=?, reason=?, review_state='pass' where order_id=?;";
        qr.update(conn, sql, adminId, reason, orderId);
    }

    @Override
    public void updateFail(String orderId, String adminId, String reason) throws SQLException {
        String sql = "update review set admin_id=?, reason=?, review_state='fail' where order_id=?;";
        qr.update(conn, sql, adminId, reason, orderId);
    }

    @Override
    public void InsertOrder(String orderId) throws SQLException {
        String sql = "insert into review values (?,null,\"wait\",null);";
        qr.update(conn, sql, orderId);
    }
}
