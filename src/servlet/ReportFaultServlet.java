package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.access.CrFaultDao;
import db.model.CrFault;
import util.Convert;

/**
 * Servlet implementation class ReportFaultServlet
 */
@WebServlet("/ReportFaultServlet")
public class ReportFaultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportFaultServlet() {
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
        String userId = (String) session.getAttribute("id");
        String adminId = null;
        String building = request.getParameter("building");
        String roomNumber = request.getParameter("roomNumber");
        String context = request.getParameter("context");
        Timestamp stime = new Timestamp(System.currentTimeMillis());
        CrFault crFault = new CrFault();
        CrFaultDao crFaultDao = new CrFaultDao();
        crFault.setuserId(userId);
        crFault.setFaultId(null);
        crFault.setAdminId(adminId);
        crFault.setRoomNumber(roomNumber);
        crFault.setBuilding(building);
        System.out.println(building);
        System.out.println(userId);
        System.out.println(context);
        crFault.setContext(context);
        crFault.setVerifyState("wait");
        crFault.setStime(stime);
        try {
            crFaultDao.insert(crFault);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            Convert.alertAndBack(out, "�����ϱ��ɹ�", -1);
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
