package db.access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import db.inter.ICrClassroomDao;
import db.model.CrClassroom;
import util.JdbcUtils;
import util.MySQLhelper;

public class CrClassroomDao implements ICrClassroomDao {
    Connection conn = MySQLhelper.getConnection();
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    @Override
    public void delete(String building, String roomNum) throws SQLException {
        String sql = "delete from classroom where building = ? and room_number = ?;";
        qr.update(conn, sql, building, roomNum);
    }

    @Override
    public void update(CrClassroom obj) throws SQLException {
        String sql = "update classroom set capacity = ? where building = ? and room_number = ?;";
        qr.update(conn, sql, obj.getCapacity(), obj.getBuilding(), obj.getRoomNumber());
    }

    @Override
    public void insert(CrClassroom obj) throws SQLException {
        String sql = "insert into classroom values(?,?,?);";
        qr.update(conn, sql, obj.getBuilding(), obj.getRoomNumber(), obj.getCapacity());

    }

    @Override
    public List<CrClassroom> findPageByBuilding(String building, Integer pageSize, Integer pageNo) throws SQLException {
        String sql = "select * from classroom where building = ? limit " + (pageNo - 1) * pageSize + "," + pageSize;
        return qr.query(conn, sql, new BeanListHandler<CrClassroom>(CrClassroom.class), sql, building);
    }

    @Override
    public List<CrClassroom> findByCapacityMore(String least_capacity) throws SQLException {
        String sql = "select * from classroom where capacity = > ?;";
        return qr.query(conn, sql, new BeanListHandler<CrClassroom>(CrClassroom.class), least_capacity);
    }

    @Override
    public List<CrClassroom> findIdleClassroom(Timestamp beginTime, Timestamp endTime, Integer pageNo, Integer pageSize) throws SQLException {
        String sql = "WITH idle_classroom(building, room_number) as ("
                + "(select building,room_number from order_info join review using(order_id)"
                + "where review_state=\"fail\" or (review_state=\"pass\" and (begin_time<? and end_time<? or begin_time>? and end_time>? )))"
                + "UNION"
                + "(SELECT building, room_number from classroom where (building, room_number) not in (select building,room_number from order_info)))"
                + "select * from classroom where (building, room_number) in (SELECT * from idle_classroom)"
                + " limit " + (pageNo - 1) * pageSize + "," + pageSize;
        return qr.query(conn, sql, new BeanListHandler<CrClassroom>(CrClassroom.class, processor), beginTime, beginTime, endTime, endTime);
    }

}
