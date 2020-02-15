package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.access.CrClassroomDao;
import db.model.CrClassroom;
import db.model.CrFault;
import util.Convert;

/**
 * Servlet implementation class SearchIdleClassroomServlet
 */
@WebServlet("/SearchIdleClassroomServlet")
public class SearchIdleClassroomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdleClassroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String pageNo = request.getParameter("page");
        CrClassroomDao crClassroomDao = new CrClassroomDao();

        if (request.getParameter("beginTime") != null && request.getParameter("endTime") != null) {
            session.setAttribute("beginTime", request.getParameter("beginTime"));
            session.setAttribute("endTime", request.getParameter("endTime"));
        }
        if (pageNo == null) {
            try {
                if (session.getAttribute("beginTime") == null) {
                    try {
                        Convert.alertAndBack(out, "��������Ƿ���", -1);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                String beginTime1 = (String) session.getAttribute("beginTime");
                String endTime1 = (String) session.getAttribute("endTime");
                System.out.println(beginTime1);
                System.out.println(endTime1);
                String beginTime2 = Convert.dateToTimestamp(beginTime1);
                String endTime2 = Convert.dateToTimestamp(endTime1);
                System.out.println(beginTime2);
                System.out.println(endTime2);
                Timestamp beginTime = Convert.stringToTimestamp(beginTime2);
                Timestamp endTime = Convert.stringToTimestamp(endTime2);
                System.out.println(beginTime.toString());
                System.out.println(endTime.toString());
                request.setAttribute("pageNo", 1);
                List<CrClassroom> list = crClassroomDao.findIdleClassroom(beginTime, endTime, 1, 5);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/list_classroom.jsp").forward(request, response);
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
            if (session.getAttribute("beginTime") == null) {
                try {
                    Convert.alertAndBack(out, "��������Ƿ���", -1);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                String beginTime1 = (String) session.getAttribute("beginTime");
                String endTime1 = (String) session.getAttribute("endTime");
                String beginTime2 = Convert.dateToTimestamp(beginTime1);
                String endTime2 = Convert.dateToTimestamp(endTime1);
                Timestamp beginTime = Convert.stringToTimestamp(beginTime2);
                Timestamp endTime = Convert.stringToTimestamp(endTime2);
                Integer page = Integer.valueOf(pageNo);
                request.setAttribute("pageNo", page);
                List<CrClassroom> list = crClassroomDao.findIdleClassroom(beginTime, endTime, page, 5);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/jsp/list_classroom.jsp").forward(request, response);
            } catch (Exception e) {
                try {
                    Convert.alertAndBack(out, "��������Ƿ���", -1);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } else
            try {
                Convert.alertAndBack(out, "��������Ƿ���", -1);
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
