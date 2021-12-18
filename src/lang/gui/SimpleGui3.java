package lang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //import ActionListener and ActionEvent

public class SimpleGui3 implements ActionListener {
    JButton button;
    JFrame frame;

    public static void main(String[] args) {
        var gui = new SimpleGui3();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Click me");
        button.addActionListener(this); // register to the button

        var drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button); // very zone
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); // very zone

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) { // implement interface
        // button.setText("I have been clacked");
        frame.repaint();
    }

}
