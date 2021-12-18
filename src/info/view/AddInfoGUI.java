package info.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import info.model.Info;

import java.awt.*;
import java.awt.event.*;

public class AddInfoGUI {
    JCheckBox male, female;
    JTextField tf0, tf1, tf2;
    JList<Integer> yearList, monthList, dayList;
    JTextArea ta;
    Info info = new Info();

    public static void main(String[] args) {
        var add = new AddInfoGUI();
        add.gui();
    }

    public void gui() {
        JFrame frame = new JFrame(); // ? 框架
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelOuter = new JPanel();
        panelOuter.setBackground(Color.GRAY);
        panelOuter.setLayout(new BoxLayout(panelOuter, BoxLayout.Y_AXIS));
        JLabel[] labels = new JLabel[6];
        labels[0] = new JLabel("名字 : ");
        labels[1] = new JLabel("性别 : ");
        labels[2] = new JLabel("编号 : ");
        labels[3] = new JLabel("成绩 : ");
        labels[4] = new JLabel("生日 : ");
        labels[5] = new JLabel("简历 : ");

        tf0 = new JTextField("Quanwei");
        tf1 = new JTextField("ID ...");
        tf2 = new JTextField("Score");

        ta = new JTextArea(5, 20);
        ta.setText("请输入你的简历...\n");
        JScrollPane scroller = new JScrollPane(ta); // 滚动条
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        male = new JCheckBox("男"); // Cheakbox
        female = new JCheckBox("女");
        male.addItemListener(new CheakListener());
        female.addItemListener(new CheakListener());

        // 生日
        Integer[] year = new Integer[23];
        for (Integer i = 2021 - 23, j = 0; i < 2021; ++i, ++j) {
            year[j] = i; // int -> Integer
        }
        Integer[] month = new Integer[12];
        for (Integer i = 1; i <= 12; ++i) {
            month[i - 1] = i;
        }
        Integer[] day = new Integer[31];
        for (Integer i = 1; i <= 31; ++i) {
            day[i - 1] = i;
        }
        yearList = new JList<Integer>(year);
        monthList = new JList<Integer>(month);
        dayList = new JList<Integer>(day);
        JScrollPane scroller0 = new JScrollPane(yearList); // add to scroller
        scroller0.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller0.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        yearList.setVisibleRowCount(1);
        yearList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        yearList.addListSelectionListener(new YearListener()); // add listener
        JScrollPane scroller1 = new JScrollPane(monthList);
        scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        monthList.setVisibleRowCount(1);
        monthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        monthList.addListSelectionListener(new YearListener());
        JScrollPane scroller2 = new JScrollPane(dayList);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        dayList.setVisibleRowCount(1);
        dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dayList.addListSelectionListener(new YearListener());

        JPanel[] panelInners = new JPanel[6];
        for (int i = 0; i < panelInners.length; i++) {
            panelInners[i] = new JPanel();
        }
        panelInners[0].add(labels[0]);
        panelInners[0].add(tf0);
        panelInners[1].add(labels[1]);
        panelInners[1].add(male);
        panelInners[1].add(female);
        panelInners[2].add(labels[2]);
        panelInners[2].add(tf1);
        panelInners[3].add(labels[3]);
        panelInners[3].add(tf2);
        panelInners[4].add(labels[4]);
        panelInners[4].add(scroller0); // add scroller instead of list
        panelInners[4].add(scroller1);
        panelInners[4].add(scroller2);
        panelInners[5].add(labels[5]);
        panelInners[5].add(scroller);

        for (int i = 0; i < panelInners.length; i++) {
            panelOuter.add(panelInners[i]);
        }
        frame.getContentPane().add(BorderLayout.CENTER, panelOuter);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    public class CheakListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (male.isSelected()) {
                female.setSelected(false);
            } else {
                male.setSelected(false);
            }
        }
    }

    public class YearListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) { // 没有if 会得到两次事件
                info.birthday[0] = (Integer) yearList.getSelectedValue();// assign to birthday
            }
        }
    }

    public class MonthListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) { 
                info.birthday[1] = (Integer) monthList.getSelectedValue();
            }
        }
    }

    public class DayListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) { 
                info.birthday[2] = (Integer) dayList.getSelectedValue();
            }
        }
    }

}
