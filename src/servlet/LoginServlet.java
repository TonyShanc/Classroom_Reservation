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

import util.Convert;
import db.access.*;
import db.model.*;

/**
 * Servlet implementation class Demo2Servlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
//		Integer id = Integer.valueOf(request.getParameter("userid"));
//		String password = request.getParameter("password");
//		out.print(id);
//		out.print(password);
        response.setContentType("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            String id = request.getParameter("userid");
            String password = request.getParameter("password");
            CrAdminDao crAdminDao = new CrAdminDao();
            CrAdmin crAdmin = new CrAdmin();
            crAdmin = null;
            CrStudent crStudent = new CrStudent();
            crStudent = null;
            CrStudentDao crStudentDao = new CrStudentDao();
            CrTeacher crTeacher = new CrTeacher();
            crTeacher = null;
            CrTeacherDao crTeacherDao = new CrTeacherDao();
            CrCompanyRepre crCompanyRepre = new CrCompanyRepre();
            crCompanyRepre = null;
            CrCompanyRepreDao crCompanyRepreDao = new CrCompanyRepreDao();
            crAdmin = crAdminDao.findOne(id, password);
            crStudent = crStudentDao.findByIdPassword(id, password);
            crTeacher = crTeacherDao.findByIdPassword(id, password);
            crCompanyRepre = crCompanyRepreDao.findOne(id, password);

            if (crAdmin != null) {
                request.setAttribute("loginer", crAdmin);
                request.setAttribute("loginType", 0);
                Convert.alert(out, "管理员登录成功");
                request.getRequestDispatcher("/jsp/index_admin.jsp").forward(request, response);
            } else if (crStudent != null) {
                request.setAttribute("loginer", crStudent);
                request.setAttribute("loginType", 1);
                Convert.alert(out, "学生登陆成功");
                request.getRequestDispatcher("/jsp/index_user.jsp").forward(request, response);
            } else if (crTeacher != null) {
                request.setAttribute("loginer", crTeacher);
                request.setAttribute("loginType", 2);
                Convert.alert(out, "老师登陆成功");
                request.getRequestDispatcher("/jsp/index_user.jsp").forward(request, response);
            } else if (crCompanyRepre != null) {
                request.setAttribute("loginer", crCompanyRepre);
                request.setAttribute("loginType", 3);
                Convert.alert(out, "企业代表登录成功!");
                request.getRequestDispatcher("/jsp/index_user.jsp").forward(request, response);
            } else {
                Convert.alertAndJump(out, "ID或密码错误", "/Classroom_Reservation/jsp/login.jsp");
            }
        } catch (Exception e) {
            try {
                Convert.alertAndJump(out, "参数错误", "/Classroom_Reservation/jsp/login.jsp");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
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
