package db.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import db.inter.ICrOrderInfoDao;
import db.model.CrFault;
import db.model.CrOrderInfo;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrOrderInfoDao implements ICrOrderInfoDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public List<CrOrderInfo> selectPage(Integer pageNo, Integer pageSize) throws SQLException {
        String sql = "select * from order_info where order_id in (select order_id from review where review_state='wait') limit " + (pageNo - 1) * pageSize + "," + pageSize;
        return qr.query(conn, sql, new BeanListHandler<CrOrderInfo>(CrOrderInfo.class, processor));
    }

    @Override
    public int InsertReturnOrderId(CrOrderInfo obj) throws SQLException {
        String sql = "insert into order_info values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//传入参数：Statement.RETURN_GENERATED_KEYS
        pstmt.setString(1, obj.getOrderId());
        pstmt.setTimestamp(2, obj.getCreationTime());
        pstmt.setString(3, obj.getUserId());
        pstmt.setString(4, obj.getBuilding());
        pstmt.setString(5, obj.getRoomNumber());
        pstmt.setTimestamp(6, obj.getBeginTime());
        pstmt.setTimestamp(7, obj.getEndTime());
        pstmt.setString(8, obj.getReason());
        pstmt.executeUpdate();//执行sql
        ResultSet rs = pstmt.getGeneratedKeys(); //获取自增键
        rs.next();
        return rs.getInt(1);//取得ID
    }

    @Override
    public List<CrOrderInfo> findPageOrderByUserId(Integer userId, Integer pageNo, Integer pageSize) throws SQLException {
        String sql = "select * from order_info join review using(order_id) where user_id = ? limit " + (pageNo - 1) * pageSize + "," + pageSize + ";";
        return qr.query(conn, sql, new BeanListHandler<CrOrderInfo>(CrOrderInfo.class, processor), userId);
    }

    @Override
    public int checkReviewType(String orderId) throws SQLException {
        String sql = "select review_state from review where order_id = ?;";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        int orderId1 = Integer.parseInt(orderId);
        pstmt.setInt(1, orderId1);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        String state = rs.getString(1);
        if (state.equals("wait")) return 0;
        else if (state.equals("fail")) return 1;
        else if (state.equals("pass")) return 2;
        else return -1;
    }
}
