<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--[if lte IE 9]><html class="ie-style lt-ie9" xmlns="http://www.w3.org/1999/xhtml"> <![endif]-->
<!--[if gt IE 9]><!--><html><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>教室预约系统</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="Shortcut Icon" href="">
    <link rel="apple-touch-icon-precomposed" href="">
    <link rel="stylesheet" type="text/css" href="/Classroom_Reservation/css/top.css">
    <link rel="stylesheet" type="text/css" href="/Classroom_Reservation/css/index.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/normalize.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/common.css">
    <link rel="stylesheet" href="/Classroom_Reservation/css/main.css">
</head>
<body>
<!--content-->
<div class="login-container">
    <section class="img-display vertical-center">
        <img src="/Classroom_Reservation/images/library.png" alt="">
        <img src="/Classroom_Reservation/images/books1.png" alt="">
        <img src="/Classroom_Reservation/images/seat.png" alt="">
        <img src="/Classroom_Reservation/images/computer.png" alt="">
    </section>
    <section class="login vertical-center">
        <form action="/Classroom_Reservation/LoginServlet" name="mylogin" method="post" id="mylogin">
            <div><span>ID：</span><input type="text" name="userid" id="login_num" maxlength="11"></div>
            <div><span>密码：</span><input name="password" type="password" id="login_pwd"></div>
            <button class="login-btn">登录</button>
        </form>
        <button id="wsAskBtn">企业注册</button>
    </section>
</div>
<script type="text/javascript" src="/Classroom_Reservation/script/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/Classroom_Reservation/script/login.js"></script>

<!--content END-->
<!--Mask 遮罩-->
<div class="lg-mask" id="popMask"></div>
<div class="lg-lrf-box" id="wsLrfBox">
    <!-- 注册 -->
    <div class="lg-reg-box" id="wsRegBox">
        <div class="lg-reg-tit-box">
            <h2 class="lg-reg-tit">注册</h2>
        </div>
        <form class="lg-form" method="post" action="/Classroom_Reservation/RegistServlet" name="regist">

            <div class="lg-common-form-line lt-form-line clearfix">
                <div class="fl lg-common-input mr20 js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="number" id="real_name" name="phoneNumber" placeholder="手机号">
                    <div class="remind-icon lt-remind"><i class="arrow arrow-bottom remind-arrow">请输入手机号</i>
                    </div>
                </div>
                <div class="fl lg-common-input js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="mail" id="email" name="mail" placeholder="邮箱">
                    <div class="remind-icon lt-remind"><i class="arrow arrow-bottom remind-arrow"></i>请输入邮箱</div>
                </div>
            </div>
            <div class="lg-common-form-line lt-form-line clearfix">
                <div class="fl lg-common-input mr20 js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="text" id="real_name" name="name" placeholder="姓名">
                    <div class="remind-icon lt-remind"><i class="arrow arrow-bottom remind-arrow">请输入姓名</i>
                    </div>
                </div>
                <div class="fl lg-common-input js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="text" id="email" name="companyName" placeholder="公司">
                    <div class="remind-icon lt-remind"><i class="arrow arrow-bottom remind-arrow"></i>请输入公司名</div>
                </div>

            </div>

            <div class="lg-common-form-line bl-form-line clearfix mb38">
                <div class="fl lg-common-input mr20 js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="text" id="position" name="position" placeholder="职位">
                    <div class="remind-icon bl-remind"><i class="arrow arrow-bottom remind-arrow"></i>请输入职位</div>
                </div>
                <div class="fl lg-common-input clearfix js_input_txt">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="password" id="password" name="password" placeholder="密码">
                    <div class="remind-icon bl-remind"><i class="arrow arrow-bottom remind-arrow"></i>密码</div>
                </div>
            </div>
            <div class="lg-common-form-line lt-form-line clearfix">
                <div class="fl lg-common-input mr20 js_input_txt clearfix">
                    <label class="lg-common-input-label js_trend_label"></label>
                    <input type="text" id="area" name="area" placeholder="地区">
                    <div class="remind-icon lt-remind"><i class="arrow arrow-bottom remind-arrow">请输入地区</i>
                    </div>
                </div>

            </div>

            <div class="lg-common-form-line lg-check-box clearfix">
                <div class="lg-common-checkbox js_rc_input">
                    <input class="icheckbox checked" type="checkbox" checked="checked" id="regRead">
                </div>
            </div>
            <div class="lg-common-form-line lg-btn-line tac">
                <input type="submit" class="ma-at common-btn lg-common-pink-btn lg-login-btn" id="regSub" value="注册">
            </div>
            <div class="error"></div>
        </form>
    </div>

</div>
<div class="lg-mask tip-mask"></div>
</body>
<script src="http://cdn3.saikr.com/js/jquery-1.10.2.min.js?v=201605101110"></script>
<script src="/Classroom_Reservation/script/index2.js"></script>
</html>
