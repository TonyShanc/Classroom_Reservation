<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <!-- 以上代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面。 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>教室预约系统——修改信息</title>
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/room_select.css">
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

        <a href="#"><span><em><%=session.getAttribute("name")%></em>（<em><%=session.getAttribute("id")%></em>）</span></a>
        <a href="login.jsp" id="logout"><img src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header><!-- header结束 -->
<div class="container">
    <nav class="nav-list">
        <a href="/Classroom_Reservation/jsp/index_user.jsp" class="nav-item" id="nav-item1">
            <span class="iconfont">&#xe63e;</span>
            <span class="item-info">主页</span>
        </a>
        <a href="room_select.html" class="nav-item" id="nav-item2">
            <span class="iconfont">&#xe604;</span>
            <span class="item-info"></span>
        </a>
        <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item3">
            <span class="iconfont">&#xe601;</span>
            <span class="item-info">联系管理员</span>
        </a>
        <a href="/Classroom_Reservation/UserCancelOrderServlet" class="nav-item" id="nav-item4">
            <span class="iconfont">&#xe64a;</span>
            <span class="item-info">取消预约</span>
        </a>
        <a href="/Classroom_Reservation/jsp/report_fault.jsp" class="nav-item" id="nav-item5">
            <span class="iconfont">&#xe751;</span>
            <span class="item-info">上报故障</span>
        </a>
        <a href="/Classroom_Reservation/jsp/report_fault.jsp" class="nav-item" id="nav-item6">
            <span class="iconfont">&#xe610;</span>
            <span class="item-info">预约教室</span>
        </a>
        <a class="nav-item" id="nav-item7">
            <span class="iconfont">&#xe65f;</span>
            <span class="item-info">公告</span>
        </a>
        <a class="nav-item" id="nav-item8">
            <span class="iconfont">&#xe600;</span>
            <span class="item-info">V0.1</span>
        </a>
        <span class="triangle"></span>
    </nav>
</div>
<%@ include file="/jsp/revise_compr_info_sub.jsp" %>
</body>
</html>