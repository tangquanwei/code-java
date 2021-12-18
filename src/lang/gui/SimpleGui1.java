package lang.gui;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //@ 1 create a frame
        JButton button = new JButton("Click me"); //@ 2 create a button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program when the wiodow is closed
        frame.getContentPane().add(button); //@3 add button to frame's pane
        frame.setSize(300, 300);
        frame.setVisible(true); //@4 show frame
    }

    public void changeIt() {

    }
}
