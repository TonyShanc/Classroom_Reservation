<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="db.model.*" %>
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
</head>
<body>
<header>
    <div class="logo">
        <h1 class="vertical-center">教室预约系统</h1>
    </div>
    <div class="logoff">
        <a href="#"><span><em class="username"><%=session.getAttribute("name")%></em>（<em
                class="usernum"><%=session.getAttribute("id")%></em>）</span></a> <a
            href="login.html" id="logout"><img
            src="/Classroom_Reservation/images/out.png" alt="注销登录"></a>
    </div>
</header>
<!-- header结束 -->
<div class="container" style="margin: 20px auto;">
    <nav class="nav-list">
        <a href="/Classroom_Reservation/jsp/index_admin.jsp" class="nav-item" id="nav-item1"> <span
                class="iconfont">&#xe63e;</span> <span class="item-info">主页</span>
        </a> <a href="/Classroom_Reservation/jsp/revise_admin_info.jsp" class="nav-item" id="nav-item2"> <span
            class="iconfont">&#xe604;</span> <span class="item-info">修改密码</span>
    </a> <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item3"> <span
            class="iconfont">&#xe601;</span> <span class="item-info"
                                                   style="display: none;">联系管理员</span>
    </a> <a href="/Classroom_Reservation/LinkAdminServlet" class="nav-item" id="nav-item4"> <span
            class="iconfont">&#xe64a;</span> <span class="item-info">联系管理员</span>
    </a> <a href="room_release.html" class="nav-item" id="nav-item5"> <span
            class="iconfont">&#xe751;</span> <span class="item-info">取消预约</span>
    </a> <a href="/Classroom_Reservation/ReviewFaultServlet" class="nav-item" id="nav-item6"> <span
            class="iconfont">&#xe610;</span> <span class="item-info">故障审核</span>
    </a> <a class="nav-item" id="nav-item7"> <span
            class="iconfont">&#xe65f;</span> <span class="item-info">公告</span>
    </a> <a class="nav-item" id="nav-item8"> <span
            class="iconfont">&#xe600;</span> <span class="item-info">V0.1</span>
    </a> <span class="triangle" style="left: 325px;"></span>
    </nav>

    <div style="width: 100%; text-align: center">
        <form action="/Classroom_Reservation/ViewUserInfoServlet"
              name="ViewUserInfoServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">用户ID：</label> <input type="text"
                                                                    name="userId">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>

        <table style="margin:0 auto;" border="1" cellspacing="0" cellpadding="10">
            <%
                if (request.getAttribute("obj") != null) {
            %>
            <%Integer objType = (Integer) request.getAttribute("objType");%>
            <%
                if (objType.equals(1)) {
                    CrStudent obj = new CrStudent();
                    obj = (CrStudent) request.getAttribute("obj");
            %>
            <tr>
                <td>学号</td>
                <td><%=obj.getId()%>
                </td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><%=obj.getName()%>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><%=obj.getMail()%>
                </td>
            </tr>
            <tr>
                <td>部门</td>
                <td><%=obj.getDeptName() %>
                </td>
            </tr>
            <tr>
                <td>入学年份</td>
                <td><%=obj.getEnrollment() %>
                </td>
            </tr>
            <tr>
                <td>类别</td>
                <td><%=obj.getStuType()%>
                </td>
            </tr>

            <%} %>
            <%
                if (objType.equals(2)) {
                    CrTeacher obj = new CrTeacher();
                    obj = (CrTeacher) request.getAttribute("obj");
            %>
            <tr>
                <td>工号</td>
                <td><%=obj.getId()%>
                </td>
            </tr>
            <tr>
                <td>教师姓名</td>
                <td><%=obj.getName()%>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><%=obj.getMail()%>
                </td>
            </tr>
            <%} %>
            <%
                if (objType.equals(3)) {
                    CrCompanyRepre obj = new CrCompanyRepre();
                    obj = (CrCompanyRepre) request.getAttribute("obj");
            %>
            <tr>
                <td>工号</td>
                <td><%=obj.getId()%>
                </td>
            </tr>
            <tr>
                <td>企业代表姓名</td>
                <td><%=obj.getName()%>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><%=obj.getMail()%>
                </td>
            </tr>
            <tr>
                <td>公司</td>
                <td><%=obj.getCompanyName()%>
                </td>
            </tr>
            <tr>
                <td>职位</td>
                <td><%=obj.getPosition()%>
                </td>
            </tr>
            <%} %>
            <%} %>
        </table>

    </div>
</div>
<script type="text/javascript"
        src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
        src="/Classroom_Reservation/script/common.js"></script>
</body>
</html>