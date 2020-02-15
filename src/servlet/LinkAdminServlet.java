package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import db.model.*;
import util.Convert;
import db.access.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkTeacherServlet
 */
@WebServlet("/LinkAdminServlet")
public class LinkAdminServlet extends HttpServlet {
    static Integer pageNo = 1;
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkAdminServlet() {
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
        response.setContentType("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String pageNo = request.getParameter("page");
        if (pageNo == null) {
            CrAdmin crAdmin = new CrAdmin();
            CrAdminDao crAdminDao = new CrAdminDao();
            List<CrAdmin> list;
            try {
                list = crAdminDao.findPage(1, 15);
                request.setAttribute("pageNo", 1);
                request.setAttribute("AdminList", list);
                request.getRequestDispatcher("/jsp/link_Admin.jsp").forward(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (pageNo.equals("0")) {
            try {
                Convert.alertAndBack(out, "����ǰ��û����", -1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (Integer.valueOf(pageNo) >= 1) {
            try {
                CrAdmin crAdmin = new CrAdmin();
                CrAdminDao crAdminDao = new CrAdminDao();
                Integer page = Integer.valueOf(pageNo);
                System.out.println(page);
                List<CrAdmin> list = crAdminDao.findPage(page, 15);
                request.setAttribute("pageNo", page);
                request.setAttribute("AdminList", list);
                request.getRequestDispatcher("/jsp/link_Admin.jsp").forward(request, response);
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
