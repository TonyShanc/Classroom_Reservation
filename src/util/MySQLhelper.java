package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��װ�˶�MySQl�Ĵ���
 *
 * @author ����
 */
public class MySQLhelper {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_reservation?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "shanchao");
            return connection;
        } catch (SQLException e) {
            System.out.println("���ݿ�����ʧ��");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("��������ʧ��");
        } finally {
            System.out.println("���ݿ����ӳɹ�");
        }
        return null;
    }

    //������Ǹ�ָ�룬ָ�����ݿ��ѯ�Ľ��,����next������һ�н��
    public static void closeResult(ResultSet rSet) {
        try {
            rSet.close();
        } catch (Exception e) {
            System.out.println("�رս����ʱ����");
        }
    }

    public static void closePreparedStatement(PreparedStatement pStatement) {
        try {
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("�ر�preparedStatementʱ����");
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("�ر�����ʧ��");
        }

    }
}
