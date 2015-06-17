import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;



public class login extends JFrame implements ActionListener{
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwdLabel = new JLabel("비밀번호");
	private JTextField idInput = new JTextField();
	private JPasswordField pwdInput = new JPasswordField();
	private JButton loginButton = new JButton("로그인");
	
	private String id ,password; 
	private HashMap<String, String> manager = new HashMap<String, String>();
	
	public login() {
		manager.put("super","123");
		setTitle("LOGIN");
		setLayout(null);
		idLabel.setBounds(20,10,60,30);
		pwdLabel.setBounds(20,50,60,30);
		idInput.setBounds(100,10,80,30);
		pwdInput.setBounds(100,50,80,30);
		loginButton.setBounds(200,25,80,35);
		loginButton.addActionListener(this);
		
		add(idLabel); 
		add(pwdLabel);
		add(idInput); 
		add(pwdInput);
		add(loginButton);
		
		setSize(320,130);
		setLocation(700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton){

			 try{
				 Iterator <String> iterator = manager.keySet().iterator();
		         if(manager.containsKey(idInput.getText()) == false) 
		        	 JOptionPane.showMessageDialog(null, "아이디를 잘못 입력하셨습니다.");  // 아이디입력한게 키에 없을 경우
		         else if(manager.containsKey(idInput.getText()) && (pwdInput.getText().equals(manager.get(idInput.getText())))){
		        	 JOptionPane.showMessageDialog(null, "login 되었습니다.");
		        	 setVisible(false);
		        	 new SwingStudent();
		         }
		         else if(pwdInput.getText() != manager.get(idInput.getText()))  // 비밀번호가 value 값과 불일치 할 경우
		        	 JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.");
		     }catch(Exception ex) {
		     }	
		}	
	}
	
	public static void main(String []args){
		new login();
	}
}
