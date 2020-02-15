package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.access.CrOrderInfoDao;
import db.access.CrReviewDao;
import util.Convert;

/**
 * Servlet implementation class ReviewChangeState
 */
@WebServlet("/ReviewChangeStateServlet")
public class ReviewChangeStateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewChangeStateServlet() {
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
        HttpSession session = request.getSession();
        String reason = null;
        reason = request.getParameter("reason");
        System.out.println("reason:" + reason);
        String reviewType = (String) session.getAttribute("reviewType");
        System.out.println("reviewType:" + reviewType);
        PrintWriter out = response.getWriter();
        CrReviewDao crReviewDao = new CrReviewDao();
        String adminId = (String) session.getAttribute("adminId");
        System.out.println("adminId" + adminId);
        String orderId = (String) session.getAttribute("orderId");
        System.out.println("orderId:" + orderId);
        if (reviewType.equals("pass")) {
            try {
                crReviewDao.updatePass(orderId, adminId, reason);
                Convert.alertAndBack(out, "ͨ���ɹ����Ѵ�����û�", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (reviewType.equals("fail")) {
            try {
                crReviewDao.updateFail(orderId, adminId, reason);
                Convert.alertAndBack(out, "�ܾ��ɹ����Ѵ�����û�", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                Convert.alertAndBack(out, "��������Ƿ���", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
