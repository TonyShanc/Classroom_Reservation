package db.model;

import java.sql.Timestamp;

/**
 * ��˹�ϵ��������
 *
 * @author ����
 * @version 0.1
 */
public class CrReview implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String order_id = null;
    private String admin_id = null;
    private String reason = null;
    private String review_state = "wait";
    private Timestamp deal_time = null;

    public CrReview() {

    }

    public void setOrderId(String order_id) {
        this.order_id = order_id;
    }

    public void setAdminId(String admin_id) {
        this.admin_id = admin_id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setReviewState(String review_state) {
        this.review_state = review_state;
    }

    public void setDealTime(Timestamp deal_time) {
        this.deal_time = deal_time;
    }

    public String getOrderId() {
        return order_id;
    }

    public String getAdminId() {
        return admin_id;
    }

    public String getReason() {
        return reason;
    }

    public String getReviewState() {
        return review_state;
    }

    public Timestamp getDealTime() {
        return deal_time;
    }
}
