package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.access.CrOrderInfoDao;
import db.model.CrOrderInfo;
import db.serviceImpl.CrDeleteService;
import util.Convert;


/**
 * Servlet implementation class UserCancelOrderServlet
 */
@WebServlet("/UserCancelOrderServlet")
public class UserCancelOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCancelOrderServlet() {
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
        Integer userId = Integer.valueOf((String) session.getAttribute("id"));
        String orderId1 = request.getParameter("orderId");
        String page1 = request.getParameter("page");
        if (orderId1 != null) {
            CrDeleteService crDeleteService = new CrDeleteService();
            Integer orderId = Integer.valueOf(orderId1);
            try {
                crDeleteService.deleteByUserAndOrderId(orderId);
                Convert.alertAndBack(out, "ԤԼȡ���ɹ���", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (page1 == null) {
            request.setAttribute("pageNo", 1);
            CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
            try {
                List<CrOrderInfo> list = crOrderInfoDao.findPageOrderByUserId(userId, 1, 5);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/user_cancel_order.jsp").forward(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (page1.equals("0")) {
            try {
                Convert.alertAndBack(out, "����ǰ��û����", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (Integer.valueOf(page1) >= 1) {

            Integer page = Integer.valueOf(page1);
            request.setAttribute("pageNo", page);
            CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
            try {
                List<CrOrderInfo> list = crOrderInfoDao.findPageOrderByUserId(userId, page, 5);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/user_cancel_order.jsp").forward(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                Convert.alertAndBack(out, "��������Ƿ�", -1);
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
