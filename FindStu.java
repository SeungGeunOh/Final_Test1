import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FindStu extends JFrame {
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JLabel find;
	
	FindStu(int index, String index2) {
		setTitle("�˻� ���");
		find = new JLabel("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = new DefaultTableModel();
		model.addColumn("�̸�");
		model.addColumn("�й�");
		model.addColumn("����");
		model.addColumn("�ּ�");
		model.addColumn("����ó");
		model.addColumn("�̸���");
		model.addColumn("����");
		model.addColumn("���б�");
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(center);
		}
		add(find, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		setSize(800,600);
		setVisible(true);
	}
	public static void main(String []args){
		new FindStu();
	}
}
