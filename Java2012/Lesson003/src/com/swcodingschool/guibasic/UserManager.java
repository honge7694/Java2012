package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UserManager extends JFrame {

	private JPanel contentPane;
	private JTable tblUserinfo;
	private JTextField txtUserName;
	private JTextField txtAddress;
	private final ButtonGroup groupGender = new ButtonGroup();
	private JTextField txtSrchString;
	private final ButtonGroup groupSrchMethod = new ButtonGroup();
	private int srchCriteria = 99;
	private int srchMethod = 99;
	DefaultTableModel model;
	private int userid4update;
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;
	private String newgender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManager frame = new UserManager();
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
	public UserManager() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// 프레임창이 오픈될 때
				// 테이블을 로드하는 메서드를 호출한다.
				LoadTbl();
			}
		});
		setTitle("User Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(12, 0, 763, 63);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);

		JLabel lblNewLabel = new JLabel("시스템 사용자 관리화면");
		lblNewLabel.setBorder(new LineBorder(Color.GRAY, 2, true));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 13, 477, 36);
		panelTitle.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 73, 247, 307);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_Dataitem = new JPanel();
		panel_Dataitem.setBounds(12, 173, 223, 124);
		panel_1.add(panel_Dataitem);
		panel_Dataitem.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("유저명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 19, 42, 15);
		panel_Dataitem.add(lblNewLabel_1);

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(50, 16, 173, 21);
		panel_Dataitem.add(txtUserName);

		JLabel lblNewLabel_1_1 = new JLabel("성  별");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 53, 42, 15);
		panel_Dataitem.add(lblNewLabel_1_1);

		rdoMale = new JRadioButton("남자");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newgender = "M";
			}
		});
		groupGender.add(rdoMale);
		rdoMale.setBounds(73, 49, 53, 23);
		panel_Dataitem.add(rdoMale);

		rdoFemale = new JRadioButton("여자");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newgender = "F";
			}
		});
		groupGender.add(rdoFemale);
		rdoFemale.setBounds(151, 49, 72, 23);
		panel_Dataitem.add(rdoFemale);

		JLabel lblNewLabel_1_1_1 = new JLabel("주   소");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(0, 87, 42, 15);
		panel_Dataitem.add(lblNewLabel_1_1_1);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(50, 84, 173, 21);
		panel_Dataitem.add(txtAddress);

		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(12, 10, 223, 153);
		panel_1.add(panel_Search);
		panel_Search.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("검색기준");
		lblNewLabel_2.setBounds(12, 14, 57, 15);
		panel_Search.add(lblNewLabel_2);

		JComboBox cmbSrchCriteria = new JComboBox();
		cmbSrchCriteria.setModel(new DefaultComboBoxModel(new String[] { "유저명", "주소" }));
		cmbSrchCriteria.setBounds(64, 12, 147, 19);
		panel_Search.add(cmbSrchCriteria);

		txtSrchString = new JTextField();
		txtSrchString.setBounds(12, 72, 199, 28);
		panel_Search.add(txtSrchString);
		txtSrchString.setColumns(10);

		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 사용자 검색 버튼을 클릭했을 때
				// 검색기준과 검색방법을 가져온다.
				// sql구문을 다르게 구성한다.
				String sql = "";
				String srchString = "";

				model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("유저명");
				model.addColumn("패스워드");
				model.addColumn("성  별");
				model.addColumn("주  소");

				srchCriteria = cmbSrchCriteria.getSelectedIndex();
				srchString = txtSrchString.getText();
				System.out.println(srchCriteria + ",  " + srchMethod);
				if (srchCriteria == 99 || srchMethod == 99 || srchString == "") {
					System.out.println("검색기준과 방법을 선택해 주세요.");
				} else {
					switch (srchCriteria) {
					case 0:// 검색기준이 유저명
						switch (srchMethod) {
						case 0:// 유사
							sql = "SELECT * FROM tbluser WHERE username like ?";
							break;
						case 1:// 일치
							sql = "SELECT * FROM tbluser WHERE username = ?";
							break;
						}
						break;
					case 1:// 검색기준 주소
						switch (srchMethod) {
						case 0:// 유사
							sql = "SELECT * FROM tbluser WHERE addr like ?";
							break;
						case 1:// 일치
							sql = "SELECT * FROM tbluser WHERE addr = ?";
							break;
						}
						break;
					}// end of double switch case

					try {
						PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
						if (srchMethod == 0)
							pstmt.setString(1, "%" + srchString + "%");
						else
							pstmt.setString(1, srchString);

						ResultSet rs = pstmt.executeQuery();

						while (rs.next()) {
							model.addRow(new Object[] { rs.getInt(1), // userid
									rs.getString(2), // username
									rs.getString(3), // userpwd
									rs.getString(4), // gender
									rs.getString(5) // addr
							});
						} // end of while
						rs.close();
						pstmt.close();

						tblUserinfo.setModel(model);
						tblUserinfo.setAutoResizeMode(0);
						tblUserinfo.getColumnModel().getColumn(0).setPreferredWidth(50);// userid
						tblUserinfo.getColumnModel().getColumn(1).setPreferredWidth(80);// username
						tblUserinfo.getColumnModel().getColumn(2).setPreferredWidth(80);// userpwd
						tblUserinfo.getColumnModel().getColumn(3).setPreferredWidth(80);// gender
						tblUserinfo.getColumnModel().getColumn(4).setPreferredWidth(200);// addr

						// JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");

					} catch (SQLException srce) {
						JOptionPane.showMessageDialog(null, "테이블 로딩 중 오류가 발생하였습니다.");
						srce.printStackTrace();
					}

				} // end of 검색기준과 방법에 따른 sql구문 구성
			}
		});
		btnNewButton.setBounds(114, 114, 97, 23);
		panel_Search.add(btnNewButton);

		JLabel lblNewLabel_2_1 = new JLabel("검색방법");
		lblNewLabel_2_1.setBounds(12, 43, 57, 15);
		panel_Search.add(lblNewLabel_2_1);

		JRadioButton rdoLike = new JRadioButton("유사");
		rdoLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srchMethod = 0;
			}
		});
		groupSrchMethod.add(rdoLike);
		rdoLike.setBounds(72, 39, 57, 23);
		panel_Search.add(rdoLike);

		JRadioButton rdoMatch = new JRadioButton("일치");
		rdoMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srchMethod = 1;
			}
		});
		groupSrchMethod.add(rdoMatch);
		rdoMatch.setBounds(154, 39, 57, 23);
		panel_Search.add(rdoMatch);
		
		JButton btnSrchInitiate = new JButton("초기화");
		btnSrchInitiate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbSrchCriteria.setSelectedIndex(0);
				rdoLike.setSelected(true);
				rdoMatch.setSelected(false);
				txtSrchString.setText("");
			}
		});
		btnSrchInitiate.setBounds(12, 114, 79, 23);
		panel_Search.add(btnSrchInitiate);

		JScrollPane scrollPane_DataTbl = new JScrollPane();
		scrollPane_DataTbl.setBounds(271, 73, 504, 461);
		contentPane.add(scrollPane_DataTbl);

		tblUserinfo = new JTable();
		tblUserinfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블의 임의 행을 클릭했을 때
				// 현재 행의 번호를 취하여, 행의 첫 컬럼에서 아이디값을 얻어
				// setTextField 메서드를 호출한다.
				// 호출된 메서드에서는 아이디값을 이용하여 데이터를 검색하여
				// 데이터아이템 텍스트필드에 뿌려준다.
				int row = tblUserinfo.getSelectedRow();
				userid4update = Integer.parseInt(tblUserinfo.getModel().getValueAt(row, 0).toString());
				// 해당 레코드의 id를 이용하여 필드값을 채우는 메서드를 호출
				setTxtField(userid4update);
				
				
			}
		});
		scrollPane_DataTbl.setViewportView(tblUserinfo);

		JPanel panel_Buttons = new JPanel();
		panel_Buttons.setBounds(12, 390, 247, 144);
		contentPane.add(panel_Buttons);
		panel_Buttons.setLayout(null);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(629, 10, 97, 23);
		panel_Buttons.add(btnExit);

		JButton btnReset = new JButton("신규 / 취소");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 신규 or 취소 버튼을 클릭했을 때
				// 입력 항목을 클리어 한다.
				txtUserName.setText("");
				rdoMale.setSelected(false);
				rdoFemale.setSelected(false);
				txtAddress.setText("");
			}
		});
		btnReset.setBounds(12, 10, 123, 23);
		panel_Buttons.add(btnReset);

		JButton btnUpdate = new JButton("업데이트");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 업데이트 버튼을 클릭했을 때
				// 텍스트 필드의 값을 임시변수로 취하고
				// sql구문구성 후 prepared statement로 완성, 질의처리를 진행한다.
				String sql = "UPDATE tbluser SET username = ?, gender = ?, addr = ? WHERE userid = ?";
				
				String username = txtUserName.getText();
				String useraddr = txtAddress.getText();
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, newgender);
					pstmt.setString(3, useraddr);
					pstmt.setInt(4, userid4update);
					
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "업데이트 완료 하였습니다.");
					
					txtUserName.setText("");
					rdoMale.setSelected(false);
					rdoFemale.setSelected(false);
					txtAddress.setText("");
					
					LoadTbl();
					
				} catch (SQLException eupdate) {
					JOptionPane.showMessageDialog(null, "업데이트 오류가 발생하였습니다.");
					eupdate.printStackTrace();
				} 
				

			}
		});
		btnUpdate.setBounds(12, 43, 123, 23);
		panel_Buttons.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 삭제 버튼을 클릭했을 때
				// 임시값으로 보관된 사용자아이디값을 이용하여
				// sql구문을 구성하고 prepared statement 완성, 질의처리를 진행한다.
				String sql = "DELETE FROM tbluser WHERE userid = ?";
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					
					pstmt.setInt(1, userid4update);
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "삭제 완료하였습니다.");
					txtUserName.setText("");
					rdoMale.setSelected(false);
					rdoFemale.setSelected(false);
					txtAddress.setText("");
					
					LoadTbl();
					
				} catch (SQLException edelete) {
					JOptionPane.showMessageDialog(null, "삭제 오류가 발생하였습니다.");
					edelete.printStackTrace();
				}

			}
		});
		btnDelete.setBounds(12, 76, 123, 23);
		panel_Buttons.add(btnDelete);

		JButton btnSave = new JButton("저  장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 저장 버튼을 클릭했을 때 입력된 데이터의 값들을 임시변수로 옮겨주고
				// sql 구문을 작성하여 prepared statement로 완성 실행한다.
				
				//저장버튼을 클릭했을 때
				String sql = "INSERT INTO tblUser(username, userpwd, gender, addr) VALUES(?,?,?,?)";
				String username = txtUserName.getText();
				String userpwd = "1234";
				//String gender = txtPublisherID.getText();
				String addr = txtAddress.getText();
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, userpwd);
					//String newGender = groupGender.getSelection().getActionCommand().toString();
					// String gender = newGender.equals("남자") ? "M" : "F";
					pstmt.setString(3, newgender);					
					pstmt.setString(4, addr);
					
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException einsert) {
					JOptionPane.showMessageDialog(null, "Insertion 오류가 발생하였습니다.");
					//einsert.printStackTrace();
				}// end of try catch

			}
		});
		btnSave.setBounds(138, 10, 97, 89);
		panel_Buttons.add(btnSave);

		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그아웃 버튼을 클릭했을 때 자원을 반납하고 로그인 화면으로 이동
				if (DBUtil.dbconn != null) {
					DBUtil.DBClose();
				}
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(12, 109, 223, 23);
		panel_Buttons.add(btnLogout);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
	}// end of constructor

	private void LoadTbl() {
		// 데이터베이스 연결이 안되어 있으면 연결
		if (DBUtil.dbconn == null)
			DBUtil.DBConnect();

		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("유저명");
		model.addColumn("패스워드");
		model.addColumn("성  별");
		model.addColumn("주  소");

		String sql = "SELECT * FROM tbluser";

		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getInt(1), // userid
						rs.getString(2), // username
						rs.getString(3), // userpwd
						rs.getString(4), // gender
						rs.getString(5) // addr
				});
			} // end of while
			rs.close();
			pstmt.close();

			tblUserinfo.setModel(model);
			tblUserinfo.setAutoResizeMode(0);
			tblUserinfo.getColumnModel().getColumn(0).setPreferredWidth(50);// userid
			tblUserinfo.getColumnModel().getColumn(1).setPreferredWidth(80);// username
			tblUserinfo.getColumnModel().getColumn(2).setPreferredWidth(80);// userpwd
			tblUserinfo.getColumnModel().getColumn(3).setPreferredWidth(80);// gender
			tblUserinfo.getColumnModel().getColumn(4).setPreferredWidth(200);// addr

			// JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");

		} catch (SQLException srce) {
			JOptionPane.showMessageDialog(null, "테이블 로딩 중 오류가 발생하였습니다.");
			srce.printStackTrace();
		}
	}// end of LoadTbl
	
	private void setTxtField(int id) {
		String sql = "SELECT * FROM tblUser WHERE userid = ?";
		
		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				txtUserName.setText(rs.getString(2)); // username
				//txtUserPwd.setText(rs.getString(3));   // userpwd
				String tmpGender = rs.getString(4);// gender
				if(tmpGender.equals("M")) {
					rdoMale.setSelected(true);
					rdoFemale.setSelected(false);
					newgender = "M";
				}
				else { 
					rdoMale.setSelected(false);
					rdoFemale.setSelected(true);
					newgender = "F";
				}
				txtAddress.setText(rs.getString(5));// address
			}// end of while
		}catch(SQLException eset) {
			JOptionPane.showMessageDialog(null, "해당 레코드 조회 중 오류가 발생하였습니다.");
			//eset.printStackTrace();
		}
	}//end of setTxtField	
}
