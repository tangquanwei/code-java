package lang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Text {
    JTextArea text1;

    public static void main(String[] args) {
        var gui = new Text();
        gui.go();
    }

    void go() {
        var frame = new JFrame();
        frame.setTitle("Click me :)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image img = new ImageIcon("D:\\QUANWEI\\Pictures\\icon\\猫咪.png").getImage();
        frame.setIconImage(img); 

        JTextField text0 = new JTextField();
        text0.setText("Hello Tang Quanwei :)");

        text1 = new JTextArea(10, 20);
        text1.setText("Quanwei \n");

        JScrollPane scroller = new JScrollPane(text1); // 滚动条
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        var panel = new JPanel();
        panel.add(scroller);

        var button = new JButton("Click me　:）");
        button.addActionListener(new ClickListener());

        frame.getContentPane().add(BorderLayout.NORTH, text0);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300, 300);
        // frame.setLocation(500, 200);
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            text1.append("Button Clicked! \n");
        }

    }
}
