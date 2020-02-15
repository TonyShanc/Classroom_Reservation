package db.inter;

import java.sql.SQLException;
import java.util.List;

import db.model.CrOrderInfo;

public interface ICrOrderInfoDao {
    List<CrOrderInfo> selectPage(Integer pageNo, Integer pageSize) throws SQLException;

    int InsertReturnOrderId(CrOrderInfo obj) throws SQLException;

    List<CrOrderInfo> findPageOrderByUserId(Integer userId, Integer pageNo, Integer pageSize) throws SQLException;

    int checkReviewType(String device_id) throws SQLException;//wait return 0; fail return 1; pass return 2
}
