import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DelStu extends JFrame {

	HashMap<String, User> user_set = new HashMap<String, User>();

	JLabel label_name = new JLabel("�̸�");
	JLabel label_age = new JLabel("����");
	JLabel label_email = new JLabel("E-mail");
	JLabel label_grade = new JLabel("���");

	JTextField input_name = new JTextField();
	JTextField input_age = new JTextField();
	JTextField input_email = new JTextField();
	JLabel real_grade = new JLabel();

	JPanel pan_main = new JPanel(new GridLayout(5, 2));
	JPanel pan_btn = new JPanel(new GridLayout(1, 2));

	JButton btn_ok = new JButton("Ȯ��");
	JButton btn_change_pw = new JButton("��й�ȣ ����");

	User user;
	EditProfile(final User u) {
		this.user = u;
		load();

		setTitle("������ ����");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		label_name.setHorizontalAlignment(getWidth());
		label_age.setHorizontalAlignment(getWidth());
		label_email.setHorizontalAlignment(getWidth());
		label_grade.setHorizontalAlignment(getWidth());
		real_grade.setHorizontalAlignment(getWidth());

		input_name.setText(user.getName());
		input_age.setText(String.valueOf(user.getAge()));
		input_email.setText(user.getEmail());
		real_grade.setText(user.getGrade());

		pan_main.add(label_name);
		pan_main.add(input_name);
		pan_main.add(label_age);
		pan_main.add(input_age);
		pan_main.add(label_email);
		pan_main.add(input_email);
		pan_main.add(label_grade);
		pan_main.add(real_grade);

		add(pan_main, "Center");

		pan_btn.add(btn_ok);
		pan_btn.add(btn_change_pw);

		add(pan_btn, "South");

		btn_change_pw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePW changepw = new ChangePW(user);

			}
		});

		setSize(300, 200);
		setVisible(true);
	}

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("UserSet.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			user_set.put(user.getId(), user);
			oos.writeObject(user_set);
			oos.flush();

			oos.close();
			fos.close();

			load();

		} catch (Exception ex) {
		}

	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("UserSet.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			user_set = (HashMap<String, User>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception ex) {

		}

	}

}
/����