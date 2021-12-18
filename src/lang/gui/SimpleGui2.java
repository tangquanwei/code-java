package lang.gui;

import javax.swing.*;
import java.awt.event.*; //import ActionListener and ActionEvent

public class SimpleGui2 implements ActionListener { // SimpleGui is a ActionListener
    JButton button;

    public static void main(String[] args) {
        var gui = new SimpleGui2();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Clack me");
        button.addActionListener(this); // register to the button
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) { // implement interface
        button.setText("I have been clacked");
    }

}