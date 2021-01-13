package com.swcodingschool.guibasic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPWD;
	private JPasswordField txtConfirm;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtUserName;
	private JTextField txtAddr;

	// ui에서 입력된 값을 취하기 위한 임시 변수.
	private String username;
	private String userpwd;
	private String confirm;
	private String gender;
	private String addr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DBUtil.dbconn == null) {
						DBUtil.DBConnect();
					}

					Join frame = new Join();
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
	public Join() {
		setTitle("Join Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Join as New Member");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 30, 253, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name ");
		lblNewLabel_1.setBounds(12, 104, 83, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(12, 147, 83, 15);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm");
		lblNewLabel_1_1_1.setBounds(12, 190, 83, 15);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Gender");
		lblNewLabel_1_1_2.setBounds(12, 233, 83, 15);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Adderess");
		lblNewLabel_1_1_3.setBounds(12, 276, 83, 15);
		contentPane.add(lblNewLabel_1_1_3);

		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		buttonGroup.add(rdoMale);
		rdoMale.setBounds(107, 229, 53, 23);
		contentPane.add(rdoMale);

		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		buttonGroup.add(rdoFemale);
		rdoFemale.setBounds(196, 229, 76, 23);
		contentPane.add(rdoFemale);

		txtPWD = new JPasswordField();
		txtPWD.setBounds(107, 143, 196, 24);
		contentPane.add(txtPWD);

		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(107, 187, 196, 24);
		contentPane.add(txtConfirm);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// UI 입력 요소들을 reset
				txtUserName.setText("");
				txtPWD.setText("");
				txtConfirm.setText("");
				buttonGroup.clearSelection();
				txtAddr.setText("");

			}
		});
		btnReset.setBounds(46, 348, 97, 23);
		contentPane.add(btnReset);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력 된 값을 DB에 저장
				if (DBUtil.dbconn == null) {
					DBUtil.DBConnect();
				}

				username = txtUserName.getText();
				userpwd = new String(txtPWD.getPassword());
				confirm = new String(txtConfirm.getPassword());

				if (!userpwd.equals(confirm)) {
					txtPWD.setText("");
					txtConfirm.setText("");
					System.out.println("비밀번호가 일치하지 않습니다.");
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				} else {

					if (rdoMale.isSelected()) {
						gender = "M";
					}else if (rdoFemale.isSelected()) {
						gender = "F";
					}
					
					addr = txtAddr.getText();

					String sql = "INSERT INTO tbluser(username, userpwd, gender, addr) VALUES (?, ?, ?, ?)";

					try {
						PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

						pstmt.setString(1, username);
						pstmt.setString(2, userpwd);
						pstmt.setString(3, gender);
						pstmt.setString(4, addr);

						int rs = pstmt.executeUpdate();
						if (rs == 1)
							JOptionPane.showMessageDialog(null, "정상적으로 저장하였습니다.");
						
					} catch (SQLException esave) {
						// TODO Auto-generated catch block
						System.out.println("[MyMSG]SQL Exception Error : " + esave.getMessage());
						esave.printStackTrace();
					}
				}
			}
		});
		btnSave.setBounds(189, 348, 97, 23);
		contentPane.add(btnSave);

		txtUserName = new JTextField();
		txtUserName.setBounds(107, 99, 196, 24);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtAddr = new JTextField();
		txtAddr.setBounds(107, 271, 196, 24);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);
	}
}
