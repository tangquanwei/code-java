package lang.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.*;

public class Main {


    public void window1() {
        JFrame frame = new JFrame("Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(500, 200);
        frame.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                frame.setTitle("点击坐标为(" + x + ", " + y + ")");
            }
        });

        frame.setVisible(true);
    }

    

    


}
