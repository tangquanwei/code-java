package lang.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

/**
 * Swing
 */
public class Swing {

    public static void gui() {
        JFrame frame = new JFrame("Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 4));
        frame.setSize(1000, 500);
        frame.setLocation(500, 200);
        frame.setVisible(true);
        Dimension dime = new Dimension(100, 100);
        ImageIcon icon0 = new ImageIcon("D:\\workspaceFolder\\CODE_JAVA\\img\\猫咪.png");
        ImageIcon icon1 = new ImageIcon("D:\\workspaceFolder\\CODE_WEB\\img\\maobao.png");
        JLabel label = new JLabel("label");
        label.setIcon(icon0);
        label.setBorder(BorderFactory.createEtchedBorder(Color.CYAN, Color.GRAY));

        JButton bt0 = new JButton(icon0);
        bt0.setPreferredSize(dime);
        bt0.setPressedIcon(icon1);

        JButton bt1 = new JButton(icon1);

        JButton bt2 = new JButton("bt2");
        bt2.setBorder(BorderFactory.createTitledBorder("边框标题XXX"));
        bt2.setBorderPainted(true);

        JButton bt3 = new JButton("bt3");
        bt3.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                label.setText("asafasfa");
                System.out.println("mouseDragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved");
            }
        });

        JButton bt4 = new JButton("bt4");
        MouseInputAdapter mouseInputAdapter = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("点击了");
            }
        };
        bt4.addMouseListener(mouseInputAdapter);

        Container pane = frame.getContentPane();
        pane.add(bt0);
        pane.add(bt1);
        pane.add(bt2);
        pane.add(bt3);
        pane.add(bt4);
        pane.add(label, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Swing::gui);
        // SwingUtilities.invokeLater(Swing::testJButton);
        // new Swing().testBorder();
    }

    public void testBorder() {
        // * 斜面边框
        // * static Border createBevelBorder(...);
        // * 虚线边框
        // * static Border createDashedBorder(...);
        // * “浮雕化”边框
        // * static Border createEtchedBorder(...);
        // * 凹入斜面边缘的边框
        // * static Border createLoweredBevelBorder(...);
        // * 具有凸出斜面边缘的边框
        // * static Border createRaisedBevelBorder(...);
        // * 凸起软斜面
        // * static Border createRaisedSoftBevelBorder(...);
        // * 合成边框
        // * static CompoundBorder createCompoundBorder(...);
        // * 类似衬边的边框
        // * static MatteBorder createMatteBorder(...);
        // * 共享斜面边框
        // * static Border createSharedBevel(...)
        // * 软斜面边框
        // * static Border createSoftBevelBorder(...);
        // * 画笔边框
        // * static Border createStrokeBorder(...);
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jf.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JPanel panel01 = createPanel();
        panel01.setBorder(BorderFactory.createLineBorder(Color.RED)); // 线边框
        JPanel panel02 = createPanel();
        panel02.setBorder(BorderFactory.createTitledBorder("边框标题XXX")); // 标题边框
        JPanel panel03 = createPanel();
        panel03.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // 凸起软斜面
        JPanel panel04 = createPanel();
        panel04.setBorder(BorderFactory.createLoweredBevelBorder()); // 凹入斜面
        panel.add(panel01);
        panel.add(panel02);
        panel.add(panel03);
        panel.add(panel04);
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(180, 180));
        panel.add(new JLabel("一个标签"));
        panel.add(new JButton("一个按钮"));
        panel.add(new JRadioButton("单选按钮"));
        panel.add(new JCheckBox("复选框"));
        return panel;
    }

}

class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println(e.getPoint());
        System.out.println(e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");

    }

}

class MyMouseInputListener implements MouseInputListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
        System.out.println(e.getClickCount());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged");

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");

    }

}