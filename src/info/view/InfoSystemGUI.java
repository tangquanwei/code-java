/**
 * 信息管理系统 
 * 功能: 
 * 0. 添加信息 
 * 1. 删除信息 
 * 2. 查找信息 
 * 3. 修改信息 
 * 4. 信息排序 
 * 5. 显示信息 
 * 6. 清空信息 
 * 7. 退出系统
 * @author Tang Quanwei
 * @version v0.1
 */
package info.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class InfoSystemGUI {
    JFrame frame;

    public static void main(String[] args) {
        var gui = new InfoSystemGUI();
        gui.go();
    }

    
    public void go() {
        frame = new JFrame(); // ? 框架
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] buttons = new JButton[8]; // ? 部件
        buttons[0] = new JButton("0. 添加信息 ");
        buttons[1] = new JButton("1. 删除信息 ");
        buttons[2] = new JButton("2. 查找信息 ");
        buttons[3] = new JButton("3. 修改信息 ");
        buttons[4] = new JButton("4. 信息排序 ");
        buttons[5] = new JButton("5. 显示信息 ");
        buttons[6] = new JButton("6. 清空信息 ");
        buttons[7] = new JButton("7. 退出系统 ");

        buttons[0].addActionListener(new Button0Listener());

        JPanel panel0 = new JPanel(); // ? 面板
        panel0.setBackground(Color.DARK_GRAY);
        BoxLayout loyout = new BoxLayout(panel0, BoxLayout.Y_AXIS);
        panel0.setLayout(loyout);
        for (int i = 0; i < buttons.length; i++) {
            panel0.add(buttons[i]); // add one by one
        }

        JLabel wellcomeLabel = new JLabel("欢迎使用信息管理系统 :)");

        var panel1 = new JPanel();
        panel1.add(wellcomeLabel);

        frame.getContentPane().add(BorderLayout.WEST, panel0);
        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        frame.setSize(600, 300);
        frame.setVisible(true);
    }

    /**
     * ButtonListeners
     */
    public class Button0Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            var add = new AddInfoGUI();
            add.gui();
        }
    }

}
