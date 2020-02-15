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

import db.access.*;
import db.model.*;
import util.Convert;

/**
 * Servlet implementation class ViewUserInfoServlet
 */
@WebServlet("/ViewUserInfoServlet")
public class ViewUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserInfoServlet() {
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
        String userId = request.getParameter("userId");
        System.out.println("������");
        System.out.println(userId);
        CrStudentDao crStudentDao = new CrStudentDao();
        CrTeacherDao crTeacherDao = new CrTeacherDao();
        CrCompanyRepreDao crCompanyRepreDao = new CrCompanyRepreDao();
        try {
            if (crStudentDao.select(userId) != null) {
                System.out.println(1);
                CrStudent obj = new CrStudent();
                request.setAttribute("objType", 1);
                try {
                    obj = crStudentDao.select(userId);
                    request.setAttribute("obj", obj);
                    request.getRequestDispatcher("/jsp/view_user_info.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (crTeacherDao.select(userId) != null) {
                System.out.println(2);
                request.setAttribute("objType", 2);
                CrTeacher obj = new CrTeacher();
                try {
                    obj = crTeacherDao.select(userId);
                    request.setAttribute("obj", obj);
                    request.getRequestDispatcher("/jsp/view_user_info.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (crCompanyRepreDao.select(userId) != null) {
                System.out.println(3);
                request.setAttribute("objType", 3);
                CrCompanyRepre obj = new CrCompanyRepre();
                try {
                    obj = crCompanyRepreDao.select(userId);
                    request.setAttribute("obj", obj);
                    request.getRequestDispatcher("/jsp/view_user_info.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                Convert.alertAndBack(out, "��������Ƿ���", -1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
