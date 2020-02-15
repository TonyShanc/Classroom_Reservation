<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Do you come in?</h1>
<form method="post" action="/Classroom_Reservation/HelloServlet">
    Select:<br>
    <select name="select" style="width: 153px">
        <option value="1">yes</option>
        <option value="2">no</option>
    </select>
    <center>
        <input type="submit" value="提        交">
    </center>
</form>
</body>
</html>
