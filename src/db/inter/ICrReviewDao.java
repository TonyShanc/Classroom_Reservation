package db.inter;

import java.sql.SQLException;

import db.model.CrReview;

public interface ICrReviewDao {
    void updatePass(String orderId, String adminId, String reason) throws SQLException;

    void updateFail(String orderId, String adminId, String reason) throws SQLException;

    void InsertOrder(String orderId) throws SQLException;
}
