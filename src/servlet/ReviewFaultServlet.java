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
import javax.servlet.jsp.JspWriter;

import db.access.CrFaultDao;
import db.model.CrFault;
import util.Convert;

/**
 * Servlet implementation class ReviewFaultServlet
 */
@WebServlet("/ReviewFaultServlet")
public class ReviewFaultServlet extends HttpServlet {
    static Integer pageNo = 1;
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewFaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String faultId = request.getParameter("faultId");
        String adminId = request.getParameter("adminId");
        String pageNo = request.getParameter("page");
        CrFaultDao crFaultDao = new CrFaultDao();
        PrintWriter out = response.getWriter();
        if (faultId != null && adminId != null) {
            try {
                crFaultDao.updateState(adminId, faultId);
                Convert.alertAndBack(out, "ͨ���ɹ�", -1);
                Convert.reload(out);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (pageNo == null) {
                try {
                    request.setAttribute("pageNo", 1);
                    List<CrFault> list;
                    list = crFaultDao.selectPage(1, 15);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/jsp/list_fault.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (pageNo.equals("0")) {
                try {
                    Convert.alertAndBack(out, "����ǰ��û����", -1);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (Integer.valueOf(pageNo) >= 1) {

                try {
                    Integer page = Integer.valueOf(pageNo);
                    request.setAttribute("pageNo", page);
                    List<CrFault> list;
                    list = crFaultDao.selectPage(page, 15);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/jsp/list_fault.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else
                try {
                    Convert.alertAndBack(out, "��������Ƿ�", -1);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
