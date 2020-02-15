package db.service;

import java.sql.SQLException;

public interface ICrDeleteService {
    void deleteByUserAndOrderId(Integer orderId) throws SQLException;
}
