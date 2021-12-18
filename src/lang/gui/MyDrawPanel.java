package lang.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        // g.setColor(Color.orange);
        // g.fillRect(20, 50, 100, 100);

        Image img =new
        ImageIcon("D:\\QUANWEI\\Pictures\\wallpaper\\backiee-96330.jog").getImage();
        g.drawImage(img, 1, 1, this);

        Graphics2D g2d = (Graphics2D) g;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);
        //gradent 坡度
        GradientPaint gradient=new GradientPaint(70,70,startColor,150,150,endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}
