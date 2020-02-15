<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="db.model.CrAdmin" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/Classroom_Reservation/css/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/layout.css" rel="stylesheet" type="text/css"/>
    <title>Insert title here</title>
</head>
<body>
<table class="table table-fixed">
    <thead>
    <tr>
        <th>序号</th>
        <th>工号</th>
        <th>姓名</th>
        <th>用户邮箱</th>
    </tr>
    </thead>
    <tbody>
    <%

        if (request.getAttribute("pageNo") == null) {

            request.setAttribute("pageNo", 1);
        }
        if (request.getAttribute("AdminList") != null) {
            List<CrAdmin> list = (List<CrAdmin>) request.getAttribute("AdminList");
            String[][] data = new String[list.size()][4];
            CrAdmin crAdmin = new CrAdmin();
            for (int i = 0; i < list.size(); i++) {
                crAdmin = (CrAdmin) list.get(i);%>
    <tr>
        <td><%=i + 1%>
        </td>
        <td><%=crAdmin.getId()%>
        </td>
        <td><%=crAdmin.getName()%>
        </td>
        <td><%=crAdmin.getPassword()%>
        </td>
    </tr>
    <%} %>

    <%} %>

    </tbody>
</table>

<div style="text-align:center">
    <button onclick="location.href='LinkAdminServlet?page=<%=1+(Integer)request.getAttribute("pageNo")%>'">下一页</button>
    <button onclick="location.href='LinkAdminServlet?page=<%=(Integer)request.getAttribute("pageNo")-1%>'">上一页</button>
</div>
</body>
</html>