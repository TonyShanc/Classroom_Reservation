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
    <form action="/Classroom_Reservation/ReviseUserInfoServlet" name="ReviseUserInfo" method="post">
        <div class="form-group">
            <label for="exampleInputName2">密码：</label>
            <input type="text" class="form-control" id="exampleInputName2" name="newPassword" placeholder=" ">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">邮箱：</label>
            <input type="email" class="form-control" id="exampleInputEmail2" name="email" placeholder=" ">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
        <button type="reset" class="btn btn-default">重置</button>
    </form>
</div>
</body>
</html>