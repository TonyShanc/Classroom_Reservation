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

import db.access.CrOrderInfoDao;
import db.access.CrReviewDao;
import db.model.CrOrderInfo;
import util.Convert;

/**
 * Servlet implementation class OrderReviewServlet
 */
@WebServlet("/OrderReviewServlet")
public class OrderReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderReviewServlet() {
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
        String page = request.getParameter("page");
        CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
        if (page == null) {
            try {
                request.setAttribute("pageNo", 1);
                List<CrOrderInfo> list = crOrderInfoDao.selectPage(1, 7);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/order_review.jsp").forward(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else if (page.equals("0")) {
            try {
                Convert.alertAndBack(out, "����ǰ��û����", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (Integer.valueOf(page) >= 1) {

            try {
                Integer pageNo = Integer.valueOf(page);
                request.setAttribute("pageNo", pageNo);
                List<CrOrderInfo> list;
                list = crOrderInfoDao.selectPage(pageNo, 7);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/order_review.jsp").forward(request, response);
            } catch (SQLException e) {
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
