<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="db.model.CrFault" %>
<%@ page import="db.access.CrFaultDao" %>
<%@ page import="java.util.List" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/Classroom_Reservation/css/easyui.css" rel="stylesheet"
          type="text/css"/>
    <link href="/Classroom_Reservation/css/font-awesome.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/layout.css" rel="stylesheet"
          type="text/css"/>
    <title>Insert title here</title>
</head>
<body>
<table class="table table-fixed">
    <thead>
    <tr>
        <th>序号</th>
        <th>用户ID</th>
        <th>审核管理员ID</th>
        <th>教学楼</th>
        <th>教室</th>
        <th>故障内容</th>
        <th>审核状态</th>
        <th>上报时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (request.getAttribute("pageNo") == null) {
            request.setAttribute("pageNo", 1);
        }
        if (request.getAttribute("list") != null) {
            List<CrFault> list = (List<CrFault>) request.getAttribute("list");
            String[][] data = new String[list.size()][7];
            CrFault crFault = new CrFault();
            for (int i = 0; i < list.size(); i++) {
                crFault = (CrFault) list.get(i);
    %>
    <tr>
        <td><%=i + 1%>
        </td>
        <td><%=crFault.getUserId()%>
        </td>
        <td><%=crFault.getAdminId()%>
        </td>
        <td><%=crFault.getBuilding()%>
        </td>
        <td><%=crFault.getRoomNumber()%>
        </td>
        <td><%=crFault.getContext()%>
        </td>
        <td><%=crFault.getVerifyState()%>
        </td>
        <td><%=crFault.getStime().toString()%>
        </td>
        <td>
            <button type="button" id="btn"
                    onclick="location.href='ReviewFaultServlet?faultId=<%=crFault.getFaultId() %>&adminId=<%=session.getAttribute("id")%>'">
                通过
            </button>
        </td>
    </tr>
    <%
        }
    %>

    <%
        }
    %>

    </tbody>
</table>
<div style="text-align:center">
    <button onclick="location.href='ReviewFaultServlet?page=<%=1+(Integer)request.getAttribute("pageNo")%>'">下一页
    </button>
    <button onclick="location.href='ReviewFaultServlet?page=<%=(Integer)request.getAttribute("pageNo")-1%>'">上一页
    </button>
</div>
</body>
</html>