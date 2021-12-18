package lang.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

public class Graphic {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new GraphicFrame();
            frame.setTitle("Hello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class GraphicFrame extends JFrame {
    public GraphicFrame() {
        add(new GraphicComponent());
        pack();
    }

}

class GraphicComponent extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintCompoent(Graphics g) {
        g.drawString("Quanwei", MESSAGE_X, MESSAGE_Y);
    }

    public Dimension getPreferSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
