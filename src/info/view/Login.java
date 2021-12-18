package info.view;

import javax.swing.*;
import javax.swing.event.*;

import org.junit.jupiter.api.Test;

import info.model.User;
import lang.jdbc.JDBCUtils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Login {
    private static HashMap<String, String> user;
    static {
        user = new HashMap<String, String>();
        user.put("000", "111");
    }

    enum CheckResult {
        SUCCESS, PASSWORD_WRONG, USERNAME_WRONG,
    }

    public static void login() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));
        frame.setSize(500, 300);
        frame.setLocation(500, 200);
        JLabel jLabel1 = new JLabel("请输入用户名");
        JLabel jLabel2 = new JLabel("请输入密码");
        JLabel jLabel3 = new JLabel();
        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();
        Container pane = frame.getContentPane();
        JButton jButton = new JButton("确定");
        JButton jButton1 = new JButton("注册");
        jButton.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                String username = jTextField.getText();
                char[] password = jPasswordField.getPassword();
                String passwd = new String(password).trim();
                username = username.trim();
                switch (cheakInfoWithDB(username, passwd)) {
                case SUCCESS:
                    jLabel3.setText("欢迎 " + username);
                    break;

                case PASSWORD_WRONG:
                    jLabel3.setText("密码错误");
                    break;

                case USERNAME_WRONG:
                    jLabel3.setText("用户名错误");
                    break;
                }
            }
        });
        jButton1.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = jTextField.getText();
                char[] password = jPasswordField.getPassword();
                String passwd = new String(password).trim();
                username = username.trim();
                if (cheakInfoWithDB(username, passwd) != CheckResult.SUCCESS) {
                    int result = addInfoToDB(username, passwd);
                    System.out.println(result);
                    jLabel3.setText("注册成功 :)");
                } else {
                    jLabel3.setText("你已经注册过了");
                }
            }
        });

        pane.add(jLabel1);
        pane.add(jTextField);
        pane.add(jLabel2);
        pane.add(jPasswordField);
        pane.add(jButton);
        pane.add(jButton1);
        pane.add(jLabel3);

        frame.setVisible(true);
    }

    public static int addInfoToDB(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取连接对象
            connection = JDBCUtils.getConnection();
            // 2.获取执行对象statement// 3.定义sql
            statement = connection.prepareStatement("insert into login (username,password) values (?,?)");
            statement.setString(1, username);
            statement.setString(2, password);
            // 4.执行sql
            int result = statement.executeUpdate();
            // 5.处理结果
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
        return -1;
    }

    @Test
    public static CheckResult cheakInfoWithDB(String username, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.定义sql
            String query = "select * from login where username=?";
            // 2.获取连接对象
            connection = JDBCUtils.getConnection();
            // 3.获取执行对象statement
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            // 4.执行sql
            resultSet = statement.executeQuery();
            // 5.处理结果
            while (resultSet.next()) {
                if (username.equals(resultSet.getString(2))) {
                    if (password.equals(resultSet.getString(3))) {
                        User user2 = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                        System.out.println(user2);
                        return CheckResult.SUCCESS;
                    } else {
                        return CheckResult.PASSWORD_WRONG;
                    }

                } else {
                    return CheckResult.USERNAME_WRONG;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
        return CheckResult.USERNAME_WRONG;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::login);
    }

}
