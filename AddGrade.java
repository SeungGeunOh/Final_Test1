import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class AddGrade extends JFrame{
	public String [] Grade_str = {"", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
	public double [] Grade_dou = {4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0};
	public double ave;
	JComboBox Grade1 = new JComboBox(Grade_str);
	JComboBox Grade2 = new JComboBox(Grade_str);
	JComboBox Grade3 = new JComboBox(Grade_str);
	JComboBox Grade4 = new JComboBox(Grade_str);
	JComboBox Grade5 = new JComboBox(Grade_str);
	JComboBox Grade6 = new JComboBox(Grade_str);
	JComboBox Grade7 = new JComboBox(Grade_str);
	JComboBox Grade8 = new JComboBox(Grade_str);
	JButton input = new JButton("입력");
	
	AddGrade() {
		setTitle("성적입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(9,3));
		add(new JLabel("논리학 [3]", SwingConstants.CENTER));
		add(Grade1);
		add(new JLabel("프로그래밍설계방법론 [4]", SwingConstants.CENTER));
		add(Grade2);
		add(new JLabel("영어커뮤니케이션1 [2]", SwingConstants.CENTER));
		add(Grade3);
		add(new JLabel("미분방정식 [3]", SwingConstants.CENTER));
		add(Grade4);
		add(new JLabel("확률과통계 [3]", SwingConstants.CENTER));
		add(Grade5);
		add(new JLabel("진로탐색과커리어 [1]", SwingConstants.CENTER));
		add(Grade6);
		add(new JLabel("교양1 [2]", SwingConstants.CENTER));
		add(Grade7);
		add(new JLabel("교양2 [2]", SwingConstants.CENTER));
		add(Grade8);
		add(new JLabel());
		add(input);
		setSize(400,500); // 870 50
		setVisible(true);
	}

}
