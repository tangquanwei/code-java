package lang.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;


/**
 * @Description:
 * @ClassName: Login
 * @Author: QUANWEI
 * @Date: 2021/11/7 16:12
 * @Version: 1.0
 */
public class Login {
    public boolean login(String username, String password) {
        if (username == null || password == null) return false;
        /**
         * sql注入:
         * 请输入账号:
         * ko
         * 请输入密码:
         * a' or 'a'='a
         * select * from login where username='ko' and password='a' or 'a'='a'
         * 登录成功
         * 使用PrepaaredStatement
         */
        String query = "select * from login where username='" + username + "' and password='" + password + "'";
        System.out.println(query);
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            return set.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(set, statement, connection);
        }
        return false;
    }

    public boolean improvedLogin(String username, String password) {
        if (username == null || password == null) return false;
        String query = "select * from login where username=? and password=?";
        Connection connection = null;
        Statement statement = null;
        PreparedStatement prepareStatement = null;
        ResultSet set = null;
        try {
            //获取连接对象
            connection = JDBCUtils.getConnection();
//            获取执行对象
            prepareStatement = connection.prepareStatement(query);
//            给?赋值
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
//            执行sql
            set = prepareStatement.executeQuery();
            return set.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(set, prepareStatement, connection);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        scanner.close();
        System.out.println(new Login().improvedLogin(username, password) ? "登录成功" : "登陆失败");
    }

    @Test
    /**
     * 事务: 一个包含多个步骤的业务操作. 如果这个业务操作被事务管理,则这多个步骤要么同时成功要么同时失败
     * 操作:
     * 1.开启事务
     * 2.提交事务
     * 3.回滚事务
     */
    public void transaction() {
        String sql = "update students set name=? where id=?";
        Connection connection = null;
        Statement statement = null;
        PreparedStatement prepareStatement = null, ps1 = null;
        ResultSet set = null;
        try {
            //获取连接对象
            connection = JDBCUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
//            获取执行对象
            ps1 = connection.prepareStatement(sql);
            prepareStatement = connection.prepareStatement(sql);
//            给?赋值
            prepareStatement.setString(1, "权威");
            prepareStatement.setInt(2, 1);
            ps1.setString(1, "Tang");
            ps1.setInt(2, 3);
//            执行sql
            prepareStatement.executeUpdate();
//            int i=3/0;
            ps1.executeUpdate();
            //结束事务
            connection.commit();
        } catch (Exception e) {
            try {//回滚事务
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {

            JDBCUtils.close(set, prepareStatement, connection);
            JDBCUtils.close(null, ps1, null);
        }
    }
}
