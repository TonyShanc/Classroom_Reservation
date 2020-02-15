<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="db.model.CrOrderInfo" %>
<%@ page import="db.access.CrOrderInfoDao" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 以上代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面。 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>教室预约系统</title>
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
    <link rel="stylesheet" type="text/css"
          href="/Classroom_Reservation/css/room_operate.css">
</head>
<body>
<header>
    <div class="logo">
        <h1 class="vertical-center">教室预约系统</h1>
    </div>
    <div class="logoff">
        <a href="#"><span><em class="username"></em>（<em
                class="usernum"></em>）</span></a> <a href="login.html" id="logout"><img
            src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header>
<!-- header结束 -->
<div class="container" style="margin: 20px auto">
    <nav class="nav-list">
        <a href="/Classroom_Reservation/jsp/index_user.jsp" class="nav-item"
           id="nav-item1"> <span class="iconfont">&#xe63e;</span> <span
                class="item-info">主页</span>
        </a>

        <%if (session.getAttribute("loginType").equals(3)) { %>
        <a href="/Classroom_Reservation/jsp/revise_compr_info.jsp" class="nav-item" id="nav-item2"> <span
                class="iconfont">&#xe604;</span> <span class="item-info">修改信息</span></a>
        <%} %>
        <%if (session.getAttribute("loginType").equals(3) == false) { %>
        <a href="/Classroom_Reservation/jsp/revise_user_info.jsp" class="nav-item" id="nav-item2"><span
                class="iconfont">&#xe604;</span> <span class="item-info">修改信息</span></a>
        <%} %>

        <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item3">
            <span class="iconfont">&#xe601;</span>
            <span class="item-info"> 联系管理员</span>
        </a> <a href="/Classroom_Reservation/jsp/list_classroom.jsp" class="nav-item" id="nav-item4">
        <span class="iconfont">&#xe64a;</span> <span class="item-info">预约教室</span>
    </a> <a href="/Classroom_Reservation/jsp/report_fault.jsp" class="nav-item" id="nav-item5"> <span
            class="iconfont">&#xe751;</span> <span class="item-info">故障报告</span>
    </a> <a href="reserve_record.html" class="nav-item" id="nav-item6"> <span
            class="iconfont">&#xe610;</span> <span class="item-info"
                                                   style="display: none;">取消预约</span>
    </a> <a class="nav-item" id="nav-item7"> <span
            class="iconfont">&#xe65f;</span> <span class="item-info">公告</span>
    </a> <a class="nav-item" id="nav-item8"> <span
            class="iconfont">&#xe600;</span> <span class="item-info">V0.1</span>
    </a> <span class="triangle" style="left: 727px;"></span>
    </nav>
    <div class="reserve-content">
        <table id="reserve_record">
            <tbody>
            <tr>
                <th>序号</th>
                <th>教学楼</th>
                <th>教室</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>理由</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <%
                if (request.getAttribute("pageNo") == null) {
                    request.setAttribute("pageNo", 1);
                }
            %>
            <%
                if (request.getAttribute("list") != null) {
                    List<CrOrderInfo> list = (List<CrOrderInfo>) request.getAttribute("list");
                    Integer num = 1;
                    CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
                    for (CrOrderInfo aOrder : list) {
                        int state = -1;
                        String orderId = aOrder.getOrderId();
                        state = crOrderInfoDao.checkReviewType(orderId);
            %>
            <tr>
                <td><%=num++%>
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
                <%
                    if (state == 0) {
                %>
                <td><%="wait"%>
                </td>
                <%
                    }
                %>
                <%
                    if (state == 1) {
                %>
                <td><%="fail"%>
                </td>
                <%
                    }
                %>
                <%
                    if (state == 2) {
                %>
                <td><%="pass"%>
                </td>
                <%
                    }
                %>
                <%
                    if (state == 0) {
                %>
                <td>
                    <button type="button" id="btn"
                            onclick="location.href='UserCancelOrderServlet?orderId=<%=orderId%>'">取消
                    </button>
                        <%
								}
							%>
                <td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>

    </div>
</div>

<script type="text/javascript"
        src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
        src="/Classroom_Reservation/script/common.js"></script>
<div style="text-align: center">
    <button
            onclick="location.href='UserCancelOrderServlet?page=<%=1 + (Integer) request.getAttribute("pageNo")%>'">下一页
    </button>
    <button
            onclick="location.href='UserCancelOrderServlet?page=<%=(Integer) request.getAttribute("pageNo") - 1%>'">上一页
    </button>
</div>
</body>
</html>