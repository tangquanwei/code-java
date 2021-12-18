package lang.gui;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    final int centerX = 120;
    final int centerY = 120;
    int x = centerX;
    int y = centerY;// the coordinates of circle shape

    public static void main(String[] args) {
        var gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var drawPanel = new MyDrawPanel1();
        frame.getContentPane().add(drawPanel);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        for (int i = 0; i < 100; i++) {
            ++x;
            ++y;
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }

        }

    }

    /**
     * MyDrawPanel1
     */
    public class MyDrawPanel1 extends JPanel {
        public void paintComponent(Graphics g) {
            // g.setColor(Color.white);
            // g.fillRect(0, 0, this.getWidth(), this.getHeight());

            Graphics2D g2d = (Graphics2D) g;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color startColor = new Color(red, green, blue);

            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endColor = new Color(red, green, blue);
            // gradent 坡度
            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g.fillOval(x, y, 10, 10);
        }
    }

}
