package lang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //import ActionListener and ActionEvent

public class TwoButtoms {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        var gui = new TwoButtoms();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Lable");
        labelButton.addActionListener(new LabelListener()); // register to the button
        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ColorListener()); // register to the button

        label = new JLabel("I am a label :)");
        var drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton); // very zone
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    /**
     * LabelListener
     */
    boolean isOn = true;

    public class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (isOn) {
                isOn = false;
                label.setText("Hello ");
            } else {
                isOn = true;
                label.setText("Tang Quanwei");
            }
        }
    }

    /**
     * ColorlListener
     */
    public class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
}
