package util;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspWriter;

public class Convert {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String cutStringWithDots(String string, int length) {
        return string.length() > length ? string.substring(0, length) + "..." : string;
    }

    public static Timestamp getNowTime() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        return d;
    }

    public static String dateToTimestamp(String date) {
        String date1 = date.substring(0, 2);
        String date2 = date.substring(3, 5);
        String date3 = date.substring(6, 10);
        String date4 = date.substring(11, 19);
        return date3 + "-" + date1 + "-" + date2 + " " + date4;
    }

    public static Timestamp dateToTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static Timestamp stringToTimestamp(String str) {
        Timestamp time = Timestamp.valueOf(str);
        return time;
    }

    public static Timestamp urlParamaterToTimestamp(String paramater) throws ParseException {
        String[] s = paramater.split("T");
        return Convert.dateToTimestamp((simpleDateFormat.parse(s[0] + " " + s[1])));
    }

    public static void jump(PrintWriter out, String url) throws Exception {
        out.println("<script type=\"text/javascript\" charset=\"UTF-8\">");
        out.println("window.location.href=\"" + url + "\";");
        out.println("</script>");
    }

    public static void alert(PrintWriter out, String msg) throws Exception {
        msg = URLEncoder.encode(msg, "UTF-8");
        out.println("<script type=\"text/javascript\"charset=\"UTF-8\">");
        if (msg != null) {
            out.println("alert(decodeURIComponent(\"" + msg + "\"));");
        }
        out.println("</script>");
    }

    public static void alertAndJump(PrintWriter out, String msg, String url) throws Exception {
        msg = URLEncoder.encode(msg, "UTF-8");
        out.println("<script type=\"text/javascript\" charset=\"UTF-8\">");
        if (msg != null) {
            out.println("alert(decodeURIComponent(\"" + msg + "\"));");
        }
        if (url != null) {
            out.println("window.location.href=\"" + url + "\";");
        }
        out.println("</script>");
    }

    public static void alertAndBack(JspWriter out, String msg, int backPageNumberPositive) throws Exception {
        msg = URLEncoder.encode(msg, "UTF-8");
        out.println("<script type=\"text/javascript\" charset=\"utf-8\">");
        if (msg != null) {
            out.println("alert(decodeURIComponent(\"" + msg + "\"));");
        }
        out.println("history.go(" + (backPageNumberPositive) + ");");
        out.println("</script>");
    }

    public static void alertAndBack(PrintWriter out, String msg, int backPageNumberPositive) throws Exception {
        msg = URLEncoder.encode(msg, "UTF-8");
        out.println("<script type=\"text/javascript\" charset=\"UTF-8\">");
        if (msg != null) {
            out.println("alert(decodeURIComponent(\"" + msg + "\"));");
        }
        out.println("history.go(" + (backPageNumberPositive) + ");");
        out.println("</script>");
    }

    public static void reload(PrintWriter out) {
        out.println("<script type=\"text/javascript\" charset=\"UTF-8\">");
        out.println("location.replace(location.href);");
        out.println("</script>");
    }

    public static String timestampToDateString(Timestamp ts) throws Exception {
        return simpleDateFormat.format(new Date(ts.getTime()));
    }
}