<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="db.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <!-- 以上代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面。 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>教室预约系统</title>
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/main.css">
</head>
<body>
<!--[if lte IE8]>
<p class="browserupdate">您的浏览器版本太老，请到<a href="http://browsehappy.com">这里</a>更新，以获取最佳的浏览体验。</p>
<![endif]-->
<header>
    <div class="logo">
        <h1 class="vertical-center">教室预约系统</h1>
    </div>
    <div class="logoff">
        <a href="#"><span><em class="username">
			<%
                String loginer = null;
                String id = null;

                if (request.getAttribute("loginer") != null) {
            %>
            		<%
                        if (request.getAttribute("loginType").equals(0)) {
                            CrAdmin crAdmin = (CrAdmin) request.getAttribute("loginer");
                            loginer = crAdmin.getName();
                            id = crAdmin.getId();
                            session.setAttribute("loginer", crAdmin);
                            session.setAttribute("loginType", 0);
                            session.setAttribute("name", loginer);
                            session.setAttribute("id", id);
                    %>
            		<%=loginer%>
       <%} %>
<%} %>
			</em>注<em class="usernum"></em>销👉</span></a>
        <a href="login.html" id="logout"><img src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header><!-- header结束 -->
<div class="container">
    <section class="person-info box">
        <img src="/Classroom_Reservation/images/my.png" alt="用户图片" class="horizontal-center">
        <div class="horizontal-center">
            <span>姓名：<em class="username"><%=loginer%></em></span>
            <span>ID：<em class="usernum"><%=id%></em></span>
        </div>
    </section>
    <section class="seat-select box">
        <img src="/Classroom_Reservation/images/seat1.png" alt="实验室预约" class="horizontal-center">
        <span class="horizontal-center">修改密码</span>
        <a href="/Classroom_Reservation/jsp/revise_admin_info.jsp"></a>
    </section>
    <section class="seat-operate">
        <div class="register box">
            <img src="/Classroom_Reservation/images/write.png" alt="联系管理员" class="vertical-center">
            <span class="vertical-center">联系管理员</span>
            <a href="/Classroom_Reservation/LinkAdminServlet"></a>
        </div>
        <div class="cancel-reserve box">
            <img src="/Classroom_Reservation/images/delete.png" alt="取消预约" class="vertical-center">
            <span class="vertical-center">预约审核</span>
            <a href="/Classroom_Reservation/OrderReviewServlet"></a>
        </div>
    </section>
    <section class="seat-release box">
        <img src="/Classroom_Reservation/images/recyle.png" alt="可借教室" class="horizontal-center">
        <span class="horizontal-center">查询用户信息</span>
        <a href="/Classroom_Reservation/jsp/view_user_info.jsp"></a>
    </section>
    <section class="reserve-record box">
        <img src="/Classroom_Reservation/images/record.png" alt="故障报告" class="vertical-center">
        <span class="vertical-center">故障审核</span>
        <a href="/Classroom_Reservation/ReviewFaultServlet"></a>
    </section>
    <section class="notice-board box">
        <img src="/Classroom_Reservation/images/warning.png" alt="公告栏" class="vertical-center">
        <div class="notice-info vertical-center">
            <h3>公告</h3>
            <p>此版本仅用于测试</p>

        </div>
    </section>
    <section class="default-record box">
        <img src="/Classroom_Reservation/images/wrong.png" alt="关于本web项目" class="vertical-center">
        <span class="vertical-center">V0.01</span>
    </section>
</div><!-- container结束 -->
<script type="text/javascript" src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/Classroom_Reservation/script/main.js"></script>
</body>
</html>