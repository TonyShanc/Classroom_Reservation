<%@page import="db.model.CrAdmin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<form method="post" action="/Classroom_Reservation/LoginServlet">
    <h1>用户登录</h1>
    <p>
        登录id <input type="text" name="userid"/>
    </p>
    <p>
        登录密码 <input type="password" name="password"/>
    </p>


    <%
        if (request.getAttribute("admin") != null) {
            CrAdmin crAdmin = (CrAdmin) request.getAttribute("admin");
            String name = crAdmin.getName();
    %>
    <td><%=name%>
    </td>
    <%} %>

    <input type="submit" value="登   录"/> <input type="reset" value="重     置"/>
</form>
</body>
</html>