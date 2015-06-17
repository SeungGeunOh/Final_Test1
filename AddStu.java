import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class AddStu extends JFrame {
	public FileOutputStream fout = null;
	public ObjectOutputStream oos = null;
	private JTextField StudentName = new JTextField();
	private JTextField StudentNum = new JTextField();
	private JTextField Major = new JTextField();
	private JTextField Address = new JTextField();
	private JTextField Call = new JTextField();
	private JTextField Email = new JTextField();
	private JButton btInput = new JButton("���");
	private JButton btSave = new JButton("����");
	private JPanel pnInput = new JPanel(new GridLayout(2, 8));
	private JPanel pnInput2 = new JPanel(new GridLayout(1, 2));
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	public ArrayList list = new ArrayList();
	private Student stdt;
	JButton Grade = new JButton("�����Է�");
	private String [] contents = {"X", "����1,2", "�����ٷ�", "����ɰ���", "�帲", "�������", "����帲", "�����ٸ�"};
	private JComboBox scholar = new JComboBox(contents);
	

	AddStu() {
		// �Է� �κ�
		pnInput.add(new JLabel("�̸�", SwingConstants.CENTER));
		pnInput.add(StudentName);
		pnInput.add(new JLabel("�й�", SwingConstants.CENTER));
		pnInput.add(StudentNum);
		pnInput.add(new JLabel("����", SwingConstants.CENTER));
		pnInput.add(Major);
		pnInput.add(new JLabel("�ּ�", SwingConstants.CENTER));
		pnInput.add(Address);
		pnInput.add(new JLabel("����ó", SwingConstants.CENTER));
		pnInput.add(Call);
		pnInput.add(new JLabel("�̸���", SwingConstants.CENTER));
		pnInput.add(Email);
		pnInput.add(new JLabel("����", SwingConstants.CENTER));
		pnInput.add(Grade);
		pnInput.add(new JLabel("���б�", SwingConstants.CENTER));
		pnInput.add(scholar);
		pnInput2.add(btInput);
		pnInput2.add(btSave);
		// ���̺� �κ�
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
		add(pnInput, BorderLayout.NORTH);
		add(pnInput2, BorderLayout.SOUTH);// �Էºκ� ����â�� �ֱ�
		add(scroll, BorderLayout.CENTER);// ���̺� �κ� ����â�� �ֱ�
		setSize(800, 600);
		setVisible(true);
		
		Grade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            AddGrade addgrade = new AddGrade();
	            addgrade.input.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				double total = 0;
	    				try {
	    					for (int i=0; i<10; i++) {
	    						if (((String)addgrade.Grade1.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i])))
	    							total += 3*addgrade.Grade_dou[i];																
	    						if (((String)addgrade.Grade2.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 4*addgrade.Grade_dou[i];								
	    						if (((String)addgrade.Grade3.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 2*addgrade.Grade_dou[i];																					
	    						if (((String)addgrade.Grade4.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 3*addgrade.Grade_dou[i];																	
	    						if (((String)addgrade.Grade5.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 3*addgrade.Grade_dou[i];																														
	    						if (((String)addgrade.Grade6.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += addgrade.Grade_dou[i];																						
	    						if (((String)addgrade.Grade7.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 2*addgrade.Grade_dou[i];									
	    						if (((String)addgrade.Grade8.getSelectedItem()).equals(String.valueOf(addgrade.Grade_str[i]))) 
	    							total += 2*addgrade.Grade_dou[i];								
	    					}
	    					addgrade.ave = total/20;
	    					JOptionPane.showMessageDialog(null, "���� ó�� �Ǿ����ϴ�.");
	    					addgrade.setVisible(false);
	    					Grade.setText(String.valueOf(addgrade.ave));
	    					
	    				} catch (Exception ex) {
	    				}
	    			}
	    		});
			}
		});

		btInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String studentName = StudentName.getText();
					int studentNum = Integer.parseInt(StudentNum.getText());
					String major = Major.getText();
					String address = Address.getText();
					String call = Call.getText();
					String email = Email.getText();
					String grade = Grade.getText();
					String scholarship = (String)scholar.getSelectedItem();
					String strData[] = {studentName, Integer.toString(studentNum), major, address, call, email, grade, scholarship};
					stdt = new Student(studentName, studentNum, major, address, call, email, grade, scholarship);
					list.add(stdt);
					model.addRow(strData);
					JOptionPane.showMessageDialog(null, "��� �Ǿ����ϴ�.");
					StudentName.setText("");
					StudentNum.setText("");
					Major.setText("");
					Address.setText("");
					Call.setText("");
					Email.setText("");
					Grade.setText("�����Է�");
					
				} catch (Exception ex) {
				}
			}
		});

		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fout = new FileOutputStream("student.dat"); 
					oos = new ObjectOutputStream(fout);
					
					oos.writeObject(list);
				
					
					JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�.");
					setVisible(false);
				} catch (Exception ex) {
				} finally {
					try {
						oos.close();
						fout.close();
					} catch (IOException ioe) {
					}
				}
			}
		});
	}
}