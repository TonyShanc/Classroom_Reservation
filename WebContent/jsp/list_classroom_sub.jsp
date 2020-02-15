<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/Classroom_Reservation/css/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/layout2.css" rel="stylesheet" type="text/css"/>
</head>
<body class="padding10">
<div class="form1-column" align="center">
    <form id="ff" action="/Classroom_Reservation/SearchIdleClassroomServlet" method="post">


        <input type="text" class="easyui-combobox easyui-datetimebox"" name="beginTime" label="开始时间:"
        style="width:300px;" />

        <input type="text" class="easyui-combobox easyui-datetimebox"" name="endTime" label ="结束时间:"
        style="width:300px;" />
        <button class="easyui-linkbutton btnPrimary" type="submit" style="margin:15px">查询</button>
    </form>
</div>

<script src="/Classroom_Reservation/script/jquery2.1.1.js" type="text/javascript"></script>
<script src="/Classroom_Reservation/script/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/Classroom_Reservation/script/combobox_data.js" type="text/javascript"></script>
<script type="text/javascript">
</script>

</body>
</html>