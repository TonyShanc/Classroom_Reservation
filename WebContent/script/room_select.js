function displaySelect(event, ele) {
    var table = ele.parent().find("table");
    if (event.type == "mouseenter") {
        table.show();
    } else {
        table.hide();
    }
}

function changeUseTime(event) {
    var target = event.target;
    if (target.nodeName == "TD") {
        var useTimeInput = $("#use_time");
        useTimeInput.val($(target).html());
    }
}

$(document).ready(function () {
    /*显示预约天数和起始日期的下拉框*/
    var use_time = $("#info2").find(".input");
    var use_date = $("#info3").find(".input");
    var table = $("table");
    use_time.on("mouseenter", function (event) {
        displaySelect(event, $(this));
    });
    use_time.on("mouseleave", function (event) {
        displaySelect(event, $(this));
    });
    use_date.on("mouseenter", function (event) {
        displaySelect(event, $(this));
    });
    use_date.on("mouseleave", function (event) {
        displaySelect(event, $(this));
    });
    table.on("mouseenter", function () {
        $(this).show();
    });
    table.on("mouseleave", function () {
        $(this).hide();
    });

    //选择预约天数，并更改input的值
    var td = $(".use-time-select").find("td");
    td.on("click", changeUseTime);

});


function changeUseDate(event) {
    var target = event.target;
    if (target.nodeName == "TD") {
        var useDateInput = $("#use_date");
        useDateInput.val($(target).html());
    }
}

$(document).ready(function () {
    /*显示预约天数和起始日期的下拉框*/
    var use_time = $("#info2").find(".input");
    var use_date = $("#info3").find(".input");
    var table = $("table");
    use_time.on("mouseenter", function (event) {
        displaySelect(event, $(this));
    });
    use_time.on("mouseleave", function (event) {
        displaySelect(event, $(this));
    });
    use_date.on("mouseenter", function (event) {
        displaySelect(event, $(this));
    });
    use_date.on("mouseleave", function (event) {
        displaySelect(event, $(this));
    });
    table.on("mouseenter", function () {
        $(this).show();
    });
    table.on("mouseleave", function () {
        $(this).hide();
    });

    //选择预约天数，并更改input的值
    var td = $(".use-date-select").find("td");
    td.on("click", changeUseDate);

});