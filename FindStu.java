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
		setTitle("검색 결과");
		find = new JLabel("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = new DefaultTableModel();
		model.addColumn("이름");
		model.addColumn("학번");
		model.addColumn("전공");
		model.addColumn("주소");
		model.addColumn("연락처");
		model.addColumn("이메일");
		model.addColumn("성적");
		model.addColumn("장학금");
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
