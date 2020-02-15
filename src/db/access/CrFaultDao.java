package db.access;

import db.model.CrCompanyRepre;
import db.model.CrFault;
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
import org.apache.commons.dbutils.handlers.BeanListHandler;
import db.inter.ICrFaultDao;

public class CrFaultDao implements ICrFaultDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public List<CrFault> selectAll() throws SQLException {

        String sql = "select * from fault";
        return qr.query(conn, sql, new BeanListHandler<CrFault>(CrFault.class, processor));
    }

    @Override
    public void updateState(String adminId, String faultId) throws SQLException {
        String sql = "update fault set verify_state = ?, admin_id = ? where fault_id = ?";
        qr.update(conn, sql, "pass", adminId, faultId);
    }

    @Override
    public void insert(CrFault obj) throws SQLException {
        String sql = "insert into fault values(?,?,?,?,?,?,\"wait\",?);";
        qr.update(conn, sql, obj.getFaultId(), obj.getAdminId(), obj.getUserId(), obj.getBuilding(), obj.getRoomNumber(), obj.getContext(), obj.getStime());
    }

    @Override
    public List<CrFault> selectPage(Integer pageNo, Integer pageSize) throws SQLException {
        String sql = "select * from fault limit  " + (pageNo - 1) * pageSize + "," + pageSize;
        return qr.query(conn, sql, new BeanListHandler<CrFault>(CrFault.class, processor));
    }
}
