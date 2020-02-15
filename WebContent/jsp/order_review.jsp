<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="db.model.CrOrderInfo" %>
<!DOCTYPE html>
<html lang="en">
<%
    request.setCharacterEncoding("utf-8");
%>
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
        <a href="#"><span><em class="username"><%=session.getAttribute("name").toString()%></em>（<em
                class="usernum"><%=session.getAttribute("id").toString()%></em>）</span></a>
        <a href="login.html" id="logout"><img src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header><!-- header结束 -->
<div class="container" style="margin:20px auto">
    <nav class="nav-list">
        <a href="/Classroom_Reservation/jsp/index_admin.jsp" class="nav-item" id="nav-item1">
            <span class="iconfont">&#xe63e;</span>
            <span class="item-info">主页</span>
        </a>
        <a href="/Classroom_Reservation/jsp/revise_admin_info.jsp" class="nav-item" id="nav-item2">
            <span class="iconfont">&#xe604;</span>
            <span class="item-info">修改密码</span>
        </a>
        <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item3">
            <span class="iconfont">&#xe601;</span>
            <span class="item-info">联系管理员</span>
        </a>
        <a href="/Classroom_Reservation/ReviewFaultServlet" class="nav-item" id="nav-item4">
            <span class="iconfont">&#xe64a;</span>
            <span class="item-info">故障审核</span>
        </a>
        <a href="/Classroom_Reservation/jsp/view_user_info.jsp" class="nav-item" id="nav-item5">
            <span class="iconfont">&#xe751;</span>
            <span class="item-info">查询用户信息</span>
        </a>
        <a href="reserve_record.html" class="nav-item" id="nav-item6">
            <span class="iconfont">&#xe610;</span>
            <span class="item-info" style="display: none;">释放教室</span>
        </a>
        <a class="nav-item" id="nav-item7">
            <span class="iconfont">&#xe65f;</span>
            <span class="item-info">公告</span>
        </a>
        <a class="nav-item" id="nav-item8">
            <span class="iconfont">&#xe600;</span>
            <span class="item-info">V0.1</span>
        </a>
        <span class="triangle" style="left:727px;"></span>
    </nav>
    <div class="reserve-content">
        <table id="reserve_record">
            <tbody>
            <tr>
                <th>序号</th>
                <th>借用人ID</th>
                <th>教学楼</th>
                <th>教室</th>
                <th>起始时间</th>
                <th>终止时间</th>
                <th>理由</th>
                <th>操作</th>
            </tr>
            <%
                if (request.getAttribute("list") != null) {
                    List<CrOrderInfo> list = (List<CrOrderInfo>) request.getAttribute("list");
                    Integer num = 1;
                    for (CrOrderInfo aOrder : list) {
            %>

            <tr>
                <td><%=num++%>
                </td>
                <td><%=aOrder.getUserId()%>
                </td>
                <td><%=aOrder.getBuilding()%>
                </td>
                <td><%=aOrder.getRoomNumber()%>
                </td>
                <td><%=aOrder.getBeginTime()%>
                </td>
                <td><%=aOrder.getEndTime()%>
                </td>
                <td><%=aOrder.getReason()%>
                </td>
                <td>
                    <button type="button" id="btn"
                            onclick="location.href='/Classroom_Reservation/jsp/admin_write_reason.jsp?orderId=<%=aOrder.getOrderId() %>&adminId=<%=session.getAttribute("id")%>&reviewType=pass'">
                        通过
                    </button>
                    <button type="button" id="btn"
                            onclick="location.href='/Classroom_Reservation//jsp/admin_write_reason.jsp?orderId=<%=aOrder.getOrderId() %>&adminId=<%=session.getAttribute("id")%>&reviewType=fail'">
                        否决
                    </button>
                </td>
            </tr>
            <%
                    }
                }%>
            </tbody>
        </table>
    </div>
</div>
<div style="text-align: center">
    <button
            onclick="location.href='OrderReviewServlet?page=<%=1+(Integer)request.getAttribute("pageNo")%>'">下一页
    </button>
    <button
            onclick="location.href='OrderReviewServlet?page=<%=(Integer)request.getAttribute("pageNo")-1%>'">上一页
    </button>
</div>
<script type="text/javascript" src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/Classroom_Reservation/script/common.js"></script>
</body>
</html>