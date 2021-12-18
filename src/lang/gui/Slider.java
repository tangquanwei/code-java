package lang.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.MouseEvent;

class Node<E> {
    E val;
    Node<E> next;

    Node(E val) {
        this.val = val;
    }

    Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
    }
}

public class Slider {
    public void go() {
        JFrame frame = new JFrame("Slide");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel(new BorderLayout());
        frame.getContentPane().add(pane);
        frame.setBounds(200, 200, 800, 500);
        frame.setVisible(true);

        Node<ImageIcon> list = new Node<>(new ImageIcon("D:/workspaceFolder/CODE_WEB/img/maoban.png"));
        list.next = new Node<>(new ImageIcon("D:/workspaceFolder/CODE_WEB/img/maomi.png"));
        list.next.next = new Node<>(new ImageIcon("D:/workspaceFolder/CODE_WEB/img/maowo.png"));
        list.next.next.next = new Node<>(new ImageIcon("D:\\workspaceFolder\\CODE_WEB\\img\\maoxianqiu.png"), list);

        JLabel label = new JLabel(list.val);

        JButton bt0 = new JButton("P");
        bt0.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setIcon(list.next.val);
            }
        });
        JButton bt1 = new JButton("N");
        bt1.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
      

            }
        });

        pane.add(label, BorderLayout.CENTER);
        pane.add(bt0, BorderLayout.LINE_START);
        pane.add(bt1, BorderLayout.LINE_END);
    }

    public static void main(String[] args) {
        new Slider().go();
    }
}
