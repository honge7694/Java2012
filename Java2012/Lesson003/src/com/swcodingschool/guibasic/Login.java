package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 데이터베이스 연결
					if(DBUtil.dbconn == null) {
						DBUtil.DBConnect();
					}
					
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Login Demo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(67, 10, 299, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setBounds(67, 102, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(67, 137, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(169, 99, 151, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(169, 134, 151, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 데이터베이스 연결.
				if(DBUtil.dbconn == null) {
					DBUtil.DBConnect();
				}
				
				// TEXT에 입력된 유저아이디와 비밀번호를 가져온다. 
				String userID = txtUserID.getText();
				String userPWD = txtUserPWD.getText();
				
				System.out.println(userID);
				System.out.println(userPWD);
				
			}
		});
		btnLogin.setBounds(226, 180, 94, 29);
		contentPane.add(btnLogin);
	}
}
