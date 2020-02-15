package util;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ������װ
 *
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 ����2:15:12
 */
public class JdbcUtils {

    // ���ӳ�
    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * DBUtils���������
     */

    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }

}
