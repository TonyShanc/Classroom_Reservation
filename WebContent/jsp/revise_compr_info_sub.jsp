<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="db.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

</head>
<body class="padding10">


<div style="width:100%;text-align:center">
    <form action="/Classroom_Reservation/ReviseUserInfoServlet"
          name="ReviseUserInfo" method="post">
        <%
            CrCompanyRepre c = new CrCompanyRepre();
            c = (CrCompanyRepre) session.getAttribute("loginer");
        %>
        <div>
            <label>密 码：</label> <input type="password"
                                       value="<%=c.getPassword()%>" name="newPassword">
        </div>
        <div>
            <label>邮 箱：</label> <input type="email" value="<%=c.getMail()%>"
                                       name="email">
        </div>
        <div>
            <label>公司名称: </label> <input type="text"
                                         value="<%=c.getCompanyName()%>" name="companyName">
        </div>

        <div>
            <label>申请人职位: </label> <input type="text"
                                          value="<%=c.getPosition()%>" name="position">
        </div>
        <div>
            <label>公司地区:</label> <input type="text" value="<%=c.getArea()%>"
                                        name="area">
        </div>
        <button type="submit">提交</button>
        <button type="reset">还原</button>
    </form>
</div>
</body>