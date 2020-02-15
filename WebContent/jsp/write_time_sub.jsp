<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/Classroom_Reservation/css/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/Classroom_Reservation/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body class="padding10">
<div class="form1-column">
    <form id="ff" method="post">
        <div class="form-column1">
            <div class="form-column-left">
                <input type="text" class="easyui-combobox easyui-datetimebox" name="startTime" label="开始时间(整点):"
                       style="width:100px" data-options="required:true" placeholder="必须为整点">
            </div>
        </div>
        <div class="form-column1">
            <div class="form-column-left">
                <input type="text" class="easyui-combobox easyui-datetimebox" name="endTime" label="结束时间(整点):"
                       style="width:100px" data-options="required:true" placeholder="必须为整点">
            </div>
        </div>
        <button class="easyui-linkbutton btnPrimary" style="text-align:right" type="submit">提交</button>
    </form>
</div>

<script src="/Classroom_Reservation/script/jquery2.1.1.js" type="text/javascript"></script>
<script src="/Classroom_Reservation/script/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/Classroom_Reservation/script/combobox_data.js" type="text/javascript"></script>
<script type="text/javascript">
</script>

</body>
</html>