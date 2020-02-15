package servlet;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.model.*;
import util.Convert;
import db.access.*;

/**
 * Servlet implementation class ReviseUserInfoServlet
 */
@WebServlet("/ReviseUserInfoServlet")
public class ReviseUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviseUserInfoServlet() {
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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("loginType").equals(1)) {
            String id = session.getAttribute("id").toString();
            String newPassword = request.getParameter("newPassword");
            String email = request.getParameter("email");
            CrStudent crStudent = new CrStudent();
            CrStudentDao crStudentDao = new CrStudentDao();
            try {
                crStudentDao.updatePasswordMail(id, newPassword, email);
                Convert.alertAndBack(out, "ѧ����Ϣ�޸ĳɹ���", -1);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (session.getAttribute("loginType").equals(2)) {
            String id = session.getAttribute("id").toString();
            String newPassword = request.getParameter("newPassword");
            String email = request.getParameter("email");
            CrTeacher crTeacher = new CrTeacher();
            CrTeacherDao crTeacherDao = new CrTeacherDao();
            try {
                crTeacherDao.updatePasswordMail(id, newPassword, email);
                Convert.alertAndBack(out, "��ʦ��Ϣ�޸ĳɹ���", -1);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (session.getAttribute("loginType").equals(3)) {
            String name = (String) session.getAttribute("name");
            String id = session.getAttribute("id").toString();
            String newPassword = request.getParameter("newPassword");
            String mail = request.getParameter("email");
            String area = request.getParameter("area");
            String companyName = request.getParameter("companyName");
            String position = request.getParameter("position");
            CrCompanyRepre crCompanyRepre = new CrCompanyRepre();
            crCompanyRepre.setArea(area);
            crCompanyRepre.setCompanyName(companyName);
            crCompanyRepre.setId(id);
            crCompanyRepre.setMail(mail);
            crCompanyRepre.setName(name);
            crCompanyRepre.setPassword(newPassword);
            crCompanyRepre.setPosition(position);
            session.setAttribute("loginer", crCompanyRepre);
            CrCompanyRepreDao crCompanyRepreDao = new CrCompanyRepreDao();
            System.out.println(mail + "  " + area);
            try {

                crCompanyRepreDao.updateInfo(id, newPassword, companyName, position, area, mail);
                Convert.alertAndBack(out, "��ҵ������Ϣ�޸ĳɹ���", -1);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                Convert.alert(out, "��������");
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
