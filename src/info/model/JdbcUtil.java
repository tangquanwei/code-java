package info.model;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Description: 抽取jdbc
 * @ClassName: JDBCUtils
 * @Author: QUANWEI
 * @Date: 2021/11/6 12:29
 * @Version: 1.0
 */
public class JdbcUtil {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;

    static {
        try {
            // 读取资源文件
            Properties properties = new Properties();
            // 获取src路径下的文件的方式-->ClassLoader
            ClassLoader loader = JdbcUtil.class.getClassLoader();
            URL resource = loader.getResource("jdbc.properties");
            String path = resource.getPath();
            // System.out.println(path);
            // 加载文件
            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /**
     * url:"jdbc:mysql:///quanwei", user:"root", password:",./,./",
     * driver:"com.mysql.cj.jdbc.Driver"
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
