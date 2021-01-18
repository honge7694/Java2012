package com.swcodingschool.guibasic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class DeliveryJoin extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtAddr;
	private JTextField txtPhone;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String userid;
	private String userpwd;
	private String userconfirm;
	private String gender;
	private String phone;
	private String addr;
	private JPasswordField txtPWD;
	private JPasswordField txtConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DBUtil.dbconn == null) {
					}

					DeliveryJoin frame = new DeliveryJoin();
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
	public DeliveryJoin() {
		setTitle("Delivery Join");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("JOIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 10, 269, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(50, 80, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(50, 132, 79, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CONFIRM");
		lblNewLabel_3.setBounds(50, 184, 79, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("GENDER");
		lblNewLabel_4.setBounds(50, 236, 57, 15);
		contentPane.add(lblNewLabel_4);

		txtID = new JTextField();
		txtID.setBounds(155, 77, 161, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("ADDRESS");
		lblNewLabel_5.setBounds(50, 288, 79, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("PHONE");
		lblNewLabel_6.setBounds(50, 340, 57, 15);
		contentPane.add(lblNewLabel_6);

		JRadioButton rdoMale = new JRadioButton("남자");
		buttonGroup.add(rdoMale);
		buttonGroup.add(rdoMale);
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		rdoMale.setBounds(155, 232, 79, 23);
		contentPane.add(rdoMale);

		JRadioButton rdoFemale = new JRadioButton("여자");
		buttonGroup.add(rdoFemale);
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		rdoFemale.setBounds(238, 232, 78, 23);
		contentPane.add(rdoFemale);

		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(155, 285, 161, 21);
		contentPane.add(txtAddr);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(155, 337, 161, 21);
		contentPane.add(txtPhone);

		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DBUtil.dbconn == null) {
					DBUtil.DBConnect();
				}

				userpwd = new String(txtPWD.getPassword());
				userconfirm = new String(txtConfirm.getPassword());

				if (!userpwd.equals(userconfirm) || userpwd.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
					
					txtPWD.setText("");
					txtConfirm.setText("");
					
					
				} else {
					String sql = "INSERT INTO deuser(userid, userpwd, gender, phone, addr) VALUES (?, ?, ?, ?, ?)";
					try {
						PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

						pstmt.setString(1, txtID.getText());
						pstmt.setString(2, txtPWD.getText());
						pstmt.setString(3, gender);
						pstmt.setString(4, txtPhone.getText());
						pstmt.setString(5, txtAddr.getText());

						int rs = pstmt.executeUpdate();
						if (rs == 1) {
							JOptionPane.showMessageDialog(null, "정상적으로 저장하였습니다.");
							dispose();
							DeliveryLogin login = new DeliveryLogin();
							login.setVisible(true);
						}
					} catch (SQLException eJoin) {
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
						eJoin.printStackTrace();
					}
				}
			}
		});
		btnJoin.setBounds(63, 412, 97, 23);
		contentPane.add(btnJoin);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeliveryLogin login = new DeliveryLogin();
				login.setVisible(true);
			}
		});
		btnExit.setBounds(223, 412, 97, 23);
		contentPane.add(btnExit);

		txtPWD = new JPasswordField();
		txtPWD.setBounds(155, 129, 161, 21);
		contentPane.add(txtPWD);

		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(155, 181, 161, 21);
		contentPane.add(txtConfirm);
	}
}
