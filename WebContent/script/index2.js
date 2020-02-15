'use strict';
(function () {
    var $wsRegBox = $('#wsRegBox'),
        $wsRegLink = $('#wsRegLink'),
        $wsLoginBox = $('#wsLoginBox'),
        $wsLoginLink = $('#wsLoginLink'),
        $wsFpwLoginLink = $('#wsFpwLoginLink'),//找回密码弹窗的登录链接
        $wsFindpwBox = $('#wsFindpwBox'),
        $wsFindpwLink = $('#wsFindpwLink'),
        $wsAskBtn = $('#wsAskBtn'),
        $popMask = $('#popMask'),
        len = 0,
        i = 0,
        url = '',
        $jsInput = $('.js_input_txt').find('input'),
        $wsLrfBox = $('#wsLrfBox'),
        /* 注册 */
        $regForm = $('#regForm'),
        $regRead = $('#regRead'),
        $regSub = $('#regSub'),
        $emailLabel = $('#emailLabel'),
        $email = $('#email'),
        emailVal,
        SubHasDisAbled = $regSub.is(':disabled'),
        /* 登录 */
        $jsReload = $('.js_reload'),
        $loginForm = $('#loginForm'),
        lunVal, licVal, lpwVal,
        $loginUserName = $('#loginUserName'),
        $loginIntCode = $('#loginIntCode'),
        $loginPassWord = $('#loginPassWord'),
        $lpwLabel = $('#lpwLabel'),
        $lunLabel = $('#lunLabel'),
        $rememberBtn = $('#rememberBtn'),
        readmeVal,
        /* 找回密码 */
        $findForm = $('#findForm'),
        /* 密码重置 */
        $wsResetPwBox = $('#wsResetPwBox'),
        $resetForm = $('#resetForm'),
        /* css3动画变量 */
        eventTransitionEnd = 'webkitTransitionEnd mozTransitionEnd oTransitionEnd transitionend',
        eventArr = ['webkitTransitionEnd', 'mozTransitionEnd', ' oTransitionEnd', 'transitionend'],
        eventLen = eventArr.length,
        thisEvent = '',
        isIE = window.ActiveXObject || "ActiveXObject" in window,
        $isShowId = $('#isShowId'),
        isShowId = $isShowId.val(),
        et,
        ua = navigator.userAgent.toLowerCase(),
        s,
        Sys = {};
    /* 浏览器校验 */
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
            (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
                (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;


    $(function () {
        if (isIE) {
            $('html').addClass('ie-style');
        }
        if (Sys.safari) {//如果是safari
            $wsFindpwBox.addClass('safari-style');
        }
        if (window.external && window.external.twGetRunPath) {
            et = external.twGetRunPath();
            if (et && et.toLowerCase().indexOf("360") > -1) {
                $('html').addClass('ie-style');
            }
        }
        if (isShowId == 'wsResetPwBox') {
            $wsResetPwBox.show();
            $popMask.show();
        }
        $wsAskBtn.off('click').on('click', function () {
            $wsLrfBox.fadeIn();
            $popMask.fadeIn();
        });
        $popMask.off('click').on('click', function () {
            $wsLrfBox.fadeOut();
            $wsResetPwBox.fadeOut();
            $(this).fadeOut();
        });
        $wsLoginLink.off('click').on('click', function () {
            if (isIE) {
                $wsRegBox.hide();
                $wsLoginBox.show();
            } else {
                $wsLoginBox.off(eventTransitionEnd);
                $wsRegBox.addClass('flipY-in');
                $wsLoginBox.addClass('flipY-out');
            }

            if (window.external && window.external.twGetRunPath) {//如果是360老版本浏览器
                et = external.twGetRunPath();
                if (et && et.toLowerCase().indexOf("360") > -1) {
                    $wsRegBox.hide();
                    $wsLoginBox.show();
                }
            }

        });
        $wsRegLink.off('click').on('click', function () {
            if (isIE) {
                $wsLoginBox.hide();
                $wsRegBox.show();
            } else {
                $wsRegBox.off(eventTransitionEnd);
                $wsLoginBox.removeClass('flipY-out');
                $wsRegBox.removeClass('flipY-in');
            }

            if (window.external && window.external.twGetRunPath) {//如果是360老版本浏览器
                et = external.twGetRunPath();
                if (et && et.toLowerCase().indexOf("360") > -1) {
                    $wsLoginBox.hide();
                    $wsRegBox.show();
                }
            }
        });
        $wsFindpwLink.off('click').on('click', function () {
            if (isIE) {
                $wsLoginBox.hide();
                $wsFindpwBox.show();
            } else {
                $wsFindpwBox.off(eventTransitionEnd);
                $wsLoginBox.addClass('flipX-in');
                $wsFindpwBox.addClass('flipX-out');
            }

            if (window.external && window.external.twGetRunPath) {//如果是360老版本浏览器
                et = external.twGetRunPath();
                if (et && et.toLowerCase().indexOf("360") > -1) {
                    $wsLoginBox.hide();
                    $wsFindpwBox.show();
                }
            }
        });
        $wsFpwLoginLink.off('click').on('click', function () {
            if (isIE) {
                $wsFindpwBox.hide();
                $wsLoginBox.show();
            } else {
                $wsLoginBox.off(eventTransitionEnd);
                $wsFindpwBox.removeClass('flipX-out');
                $wsLoginBox.removeClass('flipX-in');
            }

            if (window.external && window.external.twGetRunPath) {//如果是360老版本浏览器
                et = external.twGetRunPath();
                if (et && et.toLowerCase().indexOf("360") > -1) {
                    $wsFindpwBox.hide();
                    $wsLoginBox.show();
                }
            }

        });

    });
})();