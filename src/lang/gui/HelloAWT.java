package lang.gui;

import java.awt.*;
import java.awt.event.*;

public class HelloAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("awt 1");
        Label label = new Label("hello");
        label.setBackground(Color.GREEN);
        label.setSize(20, 10);
        frame.add(label);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
