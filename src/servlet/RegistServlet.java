package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.access.CrCompanyRepreDao;
import db.model.CrCompanyRepre;
import util.Convert;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
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

        try {
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String companyName = request.getParameter("companyName");
            String position = request.getParameter("position");
            String area = request.getParameter("area");
            String password = request.getParameter("password");
            String mail = request.getParameter("mail");
            CrCompanyRepre crCompanyRepre = new CrCompanyRepre();
            CrCompanyRepreDao crCompanyRepreDao = new CrCompanyRepreDao();
            crCompanyRepre.setArea(area);
            crCompanyRepre.setCompanyName(companyName);
            crCompanyRepre.setId(phoneNumber);
            crCompanyRepre.setMail(mail);
            crCompanyRepre.setPassword(password);
            crCompanyRepre.setPosition(position);
            crCompanyRepre.setName(name);
            crCompanyRepreDao.insert(crCompanyRepre);
            Convert.alertAndBack(out, "ע��ɹ���", -1);

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
