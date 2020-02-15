package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.access.CrOrderInfoDao;
import db.access.CrReviewDao;
import db.model.CrOrderInfo;
import db.model.CrReview;
import util.Convert;

/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String building = (String) session.getAttribute("building");
        String roomNumber = (String) session.getAttribute("roomNumber");
        String beginTime1 = (String) session.getAttribute("beginTime");
        String endTime1 = (String) session.getAttribute("endTime");
        String beginTime2 = Convert.dateToTimestamp(beginTime1);
        String endTime2 = Convert.dateToTimestamp(endTime1);
        String reason = request.getParameter("reason");
        Timestamp beginTime = Convert.stringToTimestamp(beginTime2);
        Timestamp endTime = Convert.stringToTimestamp(endTime2);
        String userId = (String) session.getAttribute("id");
        CrOrderInfo crOrderInfo = new CrOrderInfo();
        CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
        crOrderInfo.setBeginTime(beginTime);
        crOrderInfo.setEndTime(endTime);
        crOrderInfo.setBuilding(building);
        crOrderInfo.setCreationTime(Convert.getNowTime());
        crOrderInfo.setReason(reason);
        crOrderInfo.setUserId(userId);
        crOrderInfo.setOrderId(null);
        int orderId = 0;
        try {
            orderId = crOrderInfoDao.InsertReturnOrderId(crOrderInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            CrReviewDao crReviewDao = new CrReviewDao();
            crReviewDao.InsertOrder(String.valueOf(orderId));
            Convert.alertAndBack(out, "ԤԼ�ɹ�������ԤԼ�б�鿴��", -2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
