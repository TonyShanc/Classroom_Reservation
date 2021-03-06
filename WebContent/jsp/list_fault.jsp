<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">s
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <!-- 以上代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面。 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>华师计算机实验室预约系统——取消教室预约</title>
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
</head>
<body>
<header>
    <div class="logo">
        <h1 class="vertical-center">教室预约系统</h1>
    </div>
    <div class="logoff">
        <a href="#"><span><em class="username"><%=session.getAttribute("id") %></em>（<em
                class="usernum"><%=session.getAttribute("name") %></em>）</span></a>
        <a href="/Classroom_Reservation/login.jsp" id="logout"><img src="/Classroom_Reservation/images/out.png"
                                                                    alt="注销登录"></a>
    </div>
</header><!-- header结束 -->
<div class="container" style="margin:20px auto;">
    <nav class="nav-list">
        <a href="/Classroom_Reservation/jsp/index_admin.jsp" class="nav-item" id="nav-item1">
            <span class="iconfont">&#xe63e;</span>
            <span class="item-info">主页</span>
        </a>
        <a href="/Classroom_Reservation/OrderReviewServlet" class="nav-item" id="nav-item2">
            <span class="iconfont">&#xe604;</span>
            <span class="item-info">预约审核</span>
        </a>
        <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item3">
            <span class="iconfont">&#xe601;</span>
            <span class="item-info">联系管理员</span>
        </a>
        <a href="cancel_reserve.html" class="nav-item" id="nav-item4">
            <span class="iconfont">&#xe64a;</span>
            <span class="item-info" style="display: none;">取消预约</span>
        </a>
        <a href="/Classroom_Reservation/jsp/revise_admin_info.jsp" class="nav-item" id="nav-item5">
            <span class="iconfont">&#xe751;</span>
            <span class="item-info">修改密码</span>
        </a>
        <a href="reserve_record.html" class="nav-item" id="nav-item6">
            <span class="iconfont">&#xe610;</span>
            <span class="item-info"></span>
        </a>
        <a class="nav-item" id="nav-item7">
            <span class="iconfont">&#xe65f;</span>
            <span class="item-info">查看用户信息</span>
        </a>
        <a class="nav-item" id="nav-item8">
            <span class="iconfont">&#xe600;</span>
            <span class="item-info">公告栏</span>
        </a>
        <span class="triangle" style="left:459px"></span>
    </nav>
</div>
<%@ include file="/jsp/list_fault_sub.jsp" %>
<script type="text/javascript" src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/Classroom_Reservation/script/common.js"></script>
</body>
</html>