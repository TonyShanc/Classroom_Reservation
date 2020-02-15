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

import db.access.*;
import db.model.*;
import util.Convert;

/**
 * Servlet implementation class ReviseAdminInfoServlet
 */
@WebServlet("/ReviseAdminInfoServlet")
public class ReviseAdminInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviseAdminInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("name"));
        String newPassword = request.getParameter("newPassword");
        String id = session.getAttribute("id").toString();
        if (session.getAttribute("loginType").equals(0)) {
            CrAdmin crAdmin = new CrAdmin();
            CrAdminDao crAdminDao = new CrAdminDao();
            try {
                crAdminDao.updatePassword(id, newPassword);
                Convert.alertAndJump(out, "����Ա��Ϣ�޸ĳɹ���", "/jsp/index_Admin.jsp");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
