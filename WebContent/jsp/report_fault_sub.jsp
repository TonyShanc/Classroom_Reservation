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
    <form action="/Classroom_Reservation/ReportFaultServlet" name="Reportfault" method="post">

        <div>
            <label>教学楼：</label>
            <input type="text" name="building">
        </div>
        <div>
            <label>教室号：</label>
            <input type="text" name="roomNumber">
        </div>
        <div>
            <label>故障内容: </label>
            <textarea name="context" rows="5" cols="30" placeholder="请输入理由"></textarea>
        </div>

        <button type="submit">提交</button>
        <button type="reset">清空</button>
    </form>
</div>
</body>