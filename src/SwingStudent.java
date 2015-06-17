import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class SwingStudent extends JFrame {
	private String StudentName; // 학생이름
	private int StudentNum; // 학번
	private String Major; // 전공학과
	private String Address; // 주소
	private String Call; // 연락처
	private String Email; // 이메일
	public String Grade; // 성적
	private String Scholarship; // 장학금
	private ArrayList list = new ArrayList();
	private Student stdt;
	private String Contents[] = {"학생이름", "학번", "전공학과", "주소", "연락처", "이메일", "성적", "장학금"};
	private String ForContents[] = {"StudentName", "StudentNum", "Major", "Address", "Call", "Email", "Grade", "Scholarship"};
	private String cc[] = new String[7];
	private DefaultTableModel Model = new DefaultTableModel(Contents, 0);
	private JTable Tab = new JTable(Model);
	private JPanel Add = new JPanel();
	private File f = null;
	private int row, col, i;
	public FileOutputStream fout = null;
	public ObjectOutputStream oos = null;
	public FileInputStream fin = null;
	public ObjectInputStream ois = null;
	private File file;
	
	
	SwingStudent() {
		setTitle("학생관리프로그램"); // 타이틀 이름
		JButton StuAdd = new JButton("학생목록추가");
		JButton StuMod = new JButton("학생목록수정");
		JButton StuDel = new JButton("학생목록삭제");
		JButton StuFin = new JButton("학생목록검색");
		JButton setbt = new JButton("수정");
		JButton delbt = new JButton("삭제");
		JButton findbt = new JButton("검색");
		JLabel setlb = new JLabel(new ImageIcon("수정.png"));
		JLabel dellb = new JLabel(new ImageIcon("삭제.png"));
		JLabel findlb = new JLabel(new ImageIcon("검색.png"));
		JComboBox find1 = new JComboBox(Contents);
		JComboBox setfind1 = new JComboBox(Contents);
		JTextField find2 = new JTextField();
		JTextField setfind2 = new JTextField();
		JLabel delfind = new JLabel("", SwingConstants.CENTER);
		StuAdd.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		StuMod.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		StuDel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		StuFin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		JButton Open = new JButton("열기");
		JButton Save = new JButton("저장");
		JButton Exit = new JButton("종료");
		JScrollPane jsp;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		StuAdd.setLocation(30, 30);
		StuAdd.setSize(120, 50);
		add(StuAdd);
		StuMod.setLocation(160, 30);
		StuMod.setSize(120, 50);
		add(StuMod);
		StuDel.setLocation(290, 30);
		StuDel.setSize(120, 50);
		add(StuDel);
		StuFin.setLocation(420, 30);
		StuFin.setSize(120, 50);
		add(StuFin);
		
		setlb.setLocation(560, 40);  //수정 이미지
		setlb.setSize(50,30);
		add(setlb);
		setlb.setVisible(false);
		
		dellb.setLocation(560, 40); //삭제 이미지
		dellb.setSize(50,30);
		add(dellb);
		dellb.setVisible(false);
		
		findlb.setLocation(560, 40); //검색 이미지
		findlb.setSize(50,30);
		add(findlb);
		findlb.setVisible(false);
		
		setfind1.setLocation(630, 20); //수정 콤보
		setfind1.setSize(100,30);
		add(setfind1);
		setfind1.setVisible(false);
		
		setfind2.setLocation(630, 60); //수정 텍스트
		setfind2.setSize(100,30);
		add(setfind2);
		setfind2.setVisible(false);
		
		delfind.setLocation(630, 40); //삭제 텍스트
		delfind.setSize(100,30);
		add(delfind);
		delfind.setVisible(false);
		
		find1.setLocation(630, 20); //검색 콤보
		find1.setSize(100,30);
		add(find1);
		find1.setVisible(false);
		
		find2.setLocation(630, 60); //검색 텍스트
		find2.setSize(100,30);
		add(find2);
		find2.setVisible(false);
		
		setbt.setLocation(740, 40); //수정 버튼
		setbt.setSize(70,30);
		add(setbt);
		setbt.setVisible(false);
		
		delbt.setLocation(740, 40); //삭제 버튼
		delbt.setSize(70,30);
		add(delbt);
		delbt.setVisible(false);
		
		findbt.setLocation(740, 40); //검색 버튼
		findbt.setSize(70,30);
		add(findbt);
		findbt.setVisible(false);
		
		Open.setLocation(40,530); //검색 버튼
		Open.setSize(200,100);
		add(Open);
		
		Save.setLocation(330,530); //검색 버튼
		Save.setSize(200,100);
		add(Save);
		
		Exit.setLocation(620,530); //검색 버튼
		Exit.setSize(200,100);
		add(Exit);
		
	//	Exit.setLocation(770,30);
	//	Exit.setSize(50, 50);
	//	add(Exit);
		jsp = new JScrollPane(Tab);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = Tab.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(center);
		}
		jsp.setSize(710,400);
		jsp.setLocation(70,100);
		
		add(jsp);
		setSize(865,700); // 870 50
		setVisible(true);
		
	
		
		Tab.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = Tab.getSelectedRow();
				String get_name = (String) Model.getValueAt(row, 0);
				String get_num = (String) Model.getValueAt(row, 1);
				String get_major = (String) Model.getValueAt(row, 2);
				String get_address = (String) Model.getValueAt(row, 3);
				String get_call = (String) Model.getValueAt(row, 4);
				String get_email = (String) Model.getValueAt(row, 5);
				String get_grade = (String) Model.getValueAt(row, 6);
				String get_scholarship = (String) Model.getValueAt(row, 7);
				delfind.setText(get_name);

			}
		}
		);
	
		findbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String get_find = find2.getText();
				
				for (i=0; i<8; i++) {
					if (((String)find1.getSelectedItem()).equals(Contents[i])) {
						col = i;
					}
				}
				int l = list.size();
				for (i=0; i<=l; i++) {
					String get_nam = (String) Model.getValueAt(l, 0);
					String get_nu = (String) Model.getValueAt(l, 1);
					String get_majo = (String) Model.getValueAt(l, 2);
					String get_addres = (String) Model.getValueAt(l, 3);
					String get_cal = (String) Model.getValueAt(l, 4);
					String get_emai = (String) Model.getValueAt(l, 5);
					String get_grad = (String) Model.getValueAt(l, 6);
					String get_scholarshi = (String) Model.getValueAt(l, 7);
					System.out.println(get_nam);
					//if ((String) Model.getValueAt(i, col)!= find2.getText()) {
					//	Model.removeRow(i);
					//}
				}
				
				
			//	new FindStu();
			}
		}
		);
		
		setbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for (i=0; i<8; i++) {
						if (((String)setfind1.getSelectedItem()).equals(Contents[i])) {
							col = i;
						}
					}
					Model.setValueAt(setfind2.getText(), row, col);
					list.add(row);
					System.out.println(row);
					fout = new FileOutputStream("student.dat"); 
					oos = new ObjectOutputStream(fout);
					
					oos.writeObject(list);
				
					

					
					
					
				}
				catch(Exception ex){
				}
				finally{
					try{
						oos.close();
						fout.close();
					}
					catch(IOException ioe){}
				} // finally
			}
		}
		);
		
		delbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Model.removeRow(row);
					list.remove(row);
					fout = new FileOutputStream("student.dat"); 
					oos = new ObjectOutputStream(fout);
						
					oos.writeObject(list);
				}
				catch(Exception ex){
				}
				finally{
					try{
						oos.close();
						fout.close();
					}
					catch(IOException ioe){}
				} // finally
			}
		}
		);
		
				
		
		StuMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dellb.setVisible(false);
				delfind.setVisible(false);
				delbt.setVisible(false);
				
				findlb.setVisible(false);
				find1.setVisible(false);
				find2.setVisible(false);
				findbt.setVisible(false);
				
				setlb.setVisible(true);
				setfind1.setVisible(true);
				setfind2.setVisible(true);
				setbt.setVisible(true);
			}
		}
		);
		
		StuDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dellb.setVisible(true);
				delfind.setVisible(true);
				delbt.setVisible(true);
				
				findlb.setVisible(false);
				find1.setVisible(false);
				find2.setVisible(false);
				findbt.setVisible(false);
				
				setlb.setVisible(false);
				setfind1.setVisible(false);
				setfind2.setVisible(false);
				setbt.setVisible(false);
			}
		}
		);
		
		StuFin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dellb.setVisible(false);
				delfind.setVisible(false);
				delbt.setVisible(false);
				
				findlb.setVisible(true);
				find1.setVisible(true);
				find2.setVisible(true);
				findbt.setVisible(true);
				
				setlb.setVisible(false);
				setfind1.setVisible(false);
				setfind2.setVisible(false);
				setbt.setVisible(false);
			}
		}
		);
		
		StuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AddStu();
			}
		}
		);

		Open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File f;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if (answer == JFileChooser.APPROVE_OPTION) { 
					f = fc.getSelectedFile();
					Model.setRowCount(0);
					try{
						file = f;
						fin = new FileInputStream(f);
						// FileInputStream(File file) : file 객체에 해당하는 파일로부터 입력을 받는 파일입력스트림 생성
						// FileInputStream(String s) : s에 저장된 이름을 갖는 파일로부터 파일입력스트림 생성
						ois = new ObjectInputStream(fin);
						list = (ArrayList)ois.readObject();

						for (int i=0; i<list.size(); i++) {
							stdt = (Student)list.get(i);
							StudentName = stdt.getStudentName();
							StudentNum = stdt.getStudentNum(); 
							Major = stdt.getMajor();
							Address = stdt.getAddress();
							Call = stdt.getCall(); 
							Email = stdt.getEmail();
							Grade = stdt.getGrade();
							Scholarship = stdt.getScholarship();
							String data[] = {StudentName, Integer.toString(StudentNum), Major, Address, Call, Email, Grade, Scholarship};
							Model.addRow(data);
						}
					}
					catch(Exception ex){
					}
					finally{
						try{
							ois.close();
							fin.close();
						}
						catch(IOException ioe){}
					} // finally
				}
			}
		}
		);
		
		Save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Model.setRowCount(0);
				save();
			}
		}
		
		);
		
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		);
	}
	
	public void save() {
		try{
			fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			list = (ArrayList)ois.readObject();
			
			for (int i=0; i<list.size(); i++) {
				stdt = (Student)list.get(i);
				StudentName = stdt.getStudentName();
				StudentNum = stdt.getStudentNum(); 
				Major = stdt.getMajor();
				Address = stdt.getAddress();
				Call = stdt.getCall(); 
				Email = stdt.getEmail();
				Grade = stdt.getGrade();
				Scholarship = stdt.getScholarship();
				String data[] = {StudentName, Integer.toString(StudentNum), Major, Address, Call, Email, Grade, Scholarship};
				Model.addRow(data);
			}
			fout = new FileOutputStream("student.dat"); 
			oos = new ObjectOutputStream(fout);
				
			oos.writeObject(list);
			
				
			JOptionPane.showMessageDialog(null, "저장 되었습니다.");
		}
		catch(Exception ex){
		}
		finally{
			try{
				oos.close();
				fout.close();
				ois.close();
				fin.close();
			}
			catch(IOException ioe){}
		} // finally

	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("student.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			fis.close();

		} catch (Exception ex) {

		}

	}
	
}

