package lang.gui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.*;

public class Menu {
    public void go() {
        JFrame frame = new JFrame("VS code");
        frame.setLayout(new BorderLayout());
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar bar = new JMenuBar();
        JMenu jMenu1 = new JMenu("File");
        JMenu jMenu2 = new JMenu("Edit");
        JMenu jMenu3 = new JMenu("Selection");
        JMenu jMenu4 = new JMenu("View");
        JMenu jMenu5 = new JMenu("Go");
        JMenu jMenu6 = new JMenu("Run");
        JMenu jMenu7 = new JMenu("Terminal");
        JMenu jMenu8 = new JMenu("Help");
        bar.add(jMenu1);
        bar.add(jMenu2);
        bar.add(jMenu3);
        bar.add(jMenu4);
        bar.add(jMenu5);
        bar.add(jMenu6);
        bar.add(jMenu7);
        bar.add(jMenu8);
        JMenuItem jMenuItem1 = new JMenuItem("New File");
        JMenuItem jMenuItem2 = new JMenuItem("New Windows");
        JMenuItem jMenuItem3 = new JMenuItem("New File...");
        JMenuItem jMenuItem4 = new JMenuItem("Open File");
        JMenuItem jMenuItem5 = new JMenuItem("Open Floder");
        JMenuItem jMenuItem6 = new JMenuItem("Open Workplace from File...");
        JMenuItem jMenuItem7 = new JMenuItem("Open Recent");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jMenuItem1);
        buttonGroup.add(jMenuItem2);
        buttonGroup.add(jMenuItem3);
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem4);
        jMenu1.add(jMenuItem5);
        jMenu1.add(jMenuItem6);
        jMenu1.add(jMenuItem7);
        jMenu1.addSeparator();

        frame.getContentPane().add(bar,BorderLayout.PAGE_START);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Menu().go();
    }
}
