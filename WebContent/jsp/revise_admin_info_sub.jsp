<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

</head>
<body class="padding10">
<div style="width:100%;text-align:center">
    <form action="/Classroom_Reservation/ReviseAdminInfoServlet" name="ReviseAdminInfo" method="post">
        <div class="form-group">
            <label for="exampleInputName2">管理员新密码：</label>
            <input type="text" class="form-control" name="newPassword" placeholder=" ">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
        <button type="reset" class="btn btn-default">重置</button>
    </form>
</div>
</body>
</html>