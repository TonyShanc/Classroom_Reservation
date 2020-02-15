<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <!-- 以上代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面。 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>教室预约系统</title>
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
    <link rel="stylesheet" type="text/css" href="/Classroom_Reservation/css/room_operate.css">
</head>
<body>
<header>
    <div class="logo">
        <h1 class="vertical-center">教室预约系统</h1>
    </div>
    <div class="logoff">
        <a href="#"><span><em class="username"></em>（<em class="usernum"></em>）</span></a>
        <a href="login.html" id="logout"><img src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header><!-- header结束 -->
<div class="container" style="margin:20px auto">
    <nav class="nav-list">
        <a href="index.html" class="nav-item" id="nav-item1">
            <span class="iconfont">&#xe63e;</span>
            <span class="item-info">主页</span>
        </a>
        <a href="room_select.html" class="nav-item" id="nav-item2">
            <span class="iconfont">&#xe604;</span>
            <span class="item-info">预约实验室</span>
        </a>
        <a href="room_register.html" class="nav-item" id="nav-item3">
            <span class="iconfont">&#xe601;</span>
            <span class="item-info">联系管理员</span>
        </a>
        <a href="cancel_reserve.html" class="nav-item" id="nav-item4">
            <span class="iconfont">&#xe64a;</span>
            <span class="item-info">取消预约</span>
        </a>
        <a href="room_release.html" class="nav-item" id="nav-item5">
            <span class="iconfont">&#xe751;</span>
            <span class="item-info">可借教室</span>
        </a>
        <a href="reserve_record.html" class="nav-item" id="nav-item6">
            <span class="iconfont">&#xe610;</span>
            <span class="item-info" style="display: none;">释放教室</span>
        </a>
        <a href="default_record.html" class="nav-item" id="nav-item7">
            <span class="iconfont">&#xe65f;</span>
            <span class="item-info">超时使用记录</span>
        </a>
        <a href="notice.html" class="nav-item" id="nav-item8">
            <span class="iconfont">&#xe600;</span>
            <span class="item-info">公告栏</span>
        </a>
        <span class="triangle" style="left:727px;"></span>
    </nav>
        <%session.setAttribute("building", request.getParameter("building"));
			session.setAttribute("roomNumber", request.getParameter("roomNumber"));%>
    <script type="text/javascript" src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/Classroom_Reservation/script/common.js"></script>
    <form action="/Classroom_Reservation/SubmitOrderServlet" name="SubmitOrderServlet" method="post">
        <br>
        <br>
        <div style="text-align: center">
            <textarea name="reason" rows="8" cols="50" placeholder="请输入预约理由"></textarea>
            <br>
            <button type="submit" class="btn btn-default">提交</button>
            <button type="reset" class="btn btn-default">重置</button>
        </div>
    </form>
</body>
</html>