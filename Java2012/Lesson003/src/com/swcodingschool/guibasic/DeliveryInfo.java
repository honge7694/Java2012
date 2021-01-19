package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class DeliveryInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtAllPrice;
	private JTable tblOrder;
	private JTable tblOrderList;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private int userid4Update;
	private int orderid4Update;

	DefaultTableModel orderModel;
	DefaultTableModel orderListModel;
	JComboBox cmbKind = new JComboBox();
	private JTextArea textArea;
	
	private int kindCriteria = 99;
	private String srchKind = null;

	private String orMenu;
	private String orPrice;
	private String orExplanation;

	private int orderNumb = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(DeliveryLogin.ID);
					DeliveryInfo frame = new DeliveryInfo();
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
	public DeliveryInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadTbl();
				LoadOrderTbl();
			}
		});
		setTitle("Delivery Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 598);
		contentPane = new JPanel();
		contentPane.setLocation(-12, -76);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 46, 219, 234);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdoChicken = new JRadioButton("치킨집");
		rdoChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbKind.setModel(new DefaultComboBoxModel(new String[] { "전체", "푸라닭", "BBQ", "BHC" }));
				srchKind = "치킨";
			}
		});
		rdoChicken.setSelected(true);
		rdoChicken.setActionCommand("");
		buttonGroup.add(rdoChicken);
		rdoChicken.setBounds(9, 48, 66, 23);
		panel.add(rdoChicken);

		JRadioButton rdoPizza = new JRadioButton("피자집");
		rdoPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbKind.setModel(new DefaultComboBoxModel(new String[] { "전체", "시카고피자", "찹쌀피자", "피자마루" }));
				srchKind = "피자";
			}
		});
		buttonGroup.add(rdoPizza);
		rdoPizza.setBounds(79, 48, 66, 23);
		panel.add(rdoPizza);

		JRadioButton rdoChina = new JRadioButton("중국집");
		rdoChina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbKind.setModel(new DefaultComboBoxModel(new String[] { "전체", "짜장면", "짬뽕", "탕수육" }));
				srchKind = "중국";
			}
		});
		buttonGroup.add(rdoChina);
		rdoChina.setBounds(149, 48, 70, 23);
		panel.add(rdoChina);

		JLabel lblNewLabel = new JLabel("메뉴");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 10, 198, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("종류");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(9, 90, 198, 23);
		panel.add(lblNewLabel_1);

		JButton btnAdd = new JButton("추가하기");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문 추가하기.
				System.out.println(orMenu + orPrice + orExplanation + DeliveryLogin.ID);

				// orMenu; orPrice; orExplanation;
				String sql = "INSERT INTO orderList(menu, price, explanation, userid) VALUES (?, ?, ?, ?)";
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

					pstmt.setString(1, orMenu);
					pstmt.setString(2, orPrice);
					pstmt.setString(3, orExplanation);
					pstmt.setString(4, DeliveryLogin.ID);

					int rs = pstmt.executeUpdate();
					if (rs == 1) {
						JOptionPane.showMessageDialog(null, "메뉴가 추가되었습니다.");
						LoadOrderTbl();
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				btnAdd.setEnabled(false);
			}
		});
		btnAdd.setBounds(9, 201, 97, 23);
		panel.add(btnAdd);

		cmbKind = new JComboBox();
		cmbKind.setModel(new DefaultComboBoxModel(new String[] { "전체", "푸라닭", "BBQ", "BHC" }));
		cmbKind.setBounds(9, 124, 198, 23);
		panel.add(cmbKind);

		JButton btnSearch = new JButton("조회하기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setEnabled(false);

				String sql = "";

				orderModel = new DefaultTableModel();
				orderModel.addColumn("");
				orderModel.addColumn("메  뉴");
				orderModel.addColumn("가  격");
				orderModel.addColumn("설  명");

				kindCriteria = cmbKind.getSelectedIndex();

				if (rdoChicken.isSelected()) {
					switch (kindCriteria) {
					case 0: // 전체 치킨
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE kind like ?";
						break;

					case 1: // 푸라닭 치킨
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;

					case 2: // BBQ 치킨
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;

					case 3: // BHC 치킨
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;
					}
				} // rdoChicken

				if (rdoPizza.isSelected()) {
					switch (kindCriteria) {
					case 0: // 전체 피자
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE kind like ?";
						break;

					case 1: // 시카고 피자
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;

					case 2: // 찹쌀 피자
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;

					case 3: // 피자명 피자
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE company like ?";
						break;
					}
				} // rdoPizza

				if (rdoChina.isSelected()) {
					switch (kindCriteria) {
					case 0: // 전체
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE kind like ?";
						break;

					case 1: // 짜장
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE menu like ?";
						break;

					case 2: // 짬뽕
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE menu like ?";
						break;

					case 3: // 탕수육
						sql = "SELECT idx, menu, price, explanation FROM delivery WHERE menu like ?";
						break;
					}
				} // rdoChina

				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					if (kindCriteria != 0) {
						pstmt.setString(1, "%" + cmbKind.getSelectedItem().toString() + "%");
					} else if (kindCriteria == 0) {
						pstmt.setString(1, "%" + srchKind + "%");
					}
					System.out.println(cmbKind.getSelectedItem().toString());
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						orderModel.addRow(new Object[] { rs.getInt(1), // idx
//							rs.getString(2), // kind
//							rs.getString(3), // company
								rs.getString(2), // menu
								rs.getString(3), // price
//							rs.getString(6), // num
//							rs.getString(7), // addr
								rs.getString(4) // explanation
						});
					} // end of while()

					rs.close();
					pstmt.close();

					tblOrder.setModel(orderModel);
					// tblOrder.setAutoResizeMode(0); // 테이블의 크기를 자동 조정해준다.
					tblOrder.getColumnModel().getColumn(0).setPreferredWidth(30); // idx
					tblOrder.getColumnModel().getColumn(1).setPreferredWidth(70); // menu
					tblOrder.getColumnModel().getColumn(2).setPreferredWidth(70); // price
					tblOrder.getColumnModel().getColumn(3).setPreferredWidth(150); // explanation

				} catch (SQLException esearch) {
					JOptionPane.showMessageDialog(null, "테이블 로딩 중 오류가 발생하였습니다.");
					esearch.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(113, 201, 97, 23);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 684, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("주문");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_3.setBounds(12, 0, 113, 32);
		panel_1.add(lblNewLabel_3);

		JLabel lblID = new JLabel("주문");
		lblID.setFont(new Font("굴림", Font.BOLD, 16));
		lblID.setBounds(522, 0, 113, 32);
		lblID.setText(DeliveryLogin.ID);
		panel_1.add(lblID);

		JLabel lblID_1 = new JLabel("님 환영합니다.");
		lblID_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblID_1.setBounds(571, 0, 113, 32);
		panel_1.add(lblID_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(12, 279, 684, 32);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("주문확인");
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(12, 0, 113, 32);
		panel_1_1.add(lblNewLabel_3_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(12, 311, 219, 238);
		contentPane.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("총 가격");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(9, 10, 198, 23);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("주문한 음식");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(9, 90, 198, 23);
		panel_2.add(lblNewLabel_1_1);

		JButton btnDel = new JButton("제거하기");
		btnDel.setEnabled(false);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문할 음식 제거하기
				String sql = "DELETE FROM orderList WHERE idx = ?";
				System.out.println(orderid4Update);
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

					pstmt.setInt(1, orderid4Update);
					pstmt.execute();
					LoadOrderTbl();

					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDel.setBounds(6, 203, 97, 23);
		panel_2.add(btnDel);

		JButton btnOk = new JButton("계산하기");
		btnOk.setActionCommand("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문할 음식 계산.
				String sql = "SELECT sum(price), menu FROM orderList WHERE userid = ?";
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, DeliveryLogin.ID);
					
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						txtAllPrice.setText(rs.getString(1)); 
						textArea.append(rs.getString(2) + "\n");
						
					}
					
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnOk.setBounds(111, 203, 97, 23);
		panel_2.add(btnOk);

		txtAllPrice = new JTextField();
		txtAllPrice.setBorder(null);
		txtAllPrice.setEditable(false);
		txtAllPrice.setBackground(SystemColor.controlHighlight);
		txtAllPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllPrice.setBounds(10, 42, 198, 21);
		panel_2.add(txtAllPrice);
		txtAllPrice.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setBounds(9, 119, 198, 74);
		panel_2.add(textArea);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 58, 453, 211);
		contentPane.add(scrollPane);

		tblOrder = new JTable();
		tblOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블의 임의 행을 클릭했을 때
				// 현재 행의 번호를 취하여, 행의 첫 컬럼에서 아이디값을 얻어
				// setTextField 메서드를 호출한다.
				// 호출된 메서드에서는 아이디값을 이용하여 데이터를 검색하여
				// 데이터아이템 텍스트필드에 뿌려준다.
				int row = tblOrder.getSelectedRow();
				btnAdd.setEnabled(true);
				btnDel.setEnabled(false);
				userid4Update = Integer.parseInt(tblOrder.getModel().getValueAt(row, 0).toString());
				setTxtField(userid4Update);
			}
		});
		scrollPane.setViewportView(tblOrder);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(243, 321, 453, 217);
		contentPane.add(scrollPane_1);

		tblOrderList = new JTable();
		tblOrderList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblOrderList.getSelectedRow();
				btnDel.setEnabled(true);
				btnAdd.setEnabled(false);
				
				orderid4Update = Integer.parseInt(tblOrderList.getModel().getValueAt(row, 0).toString());
				setTxtOrderField(orderid4Update);
			}
		});
		scrollPane_1.setViewportView(tblOrderList);
	} // end of DeliveryInfo

	private void LoadTbl() {
		orderModel = new DefaultTableModel();
		orderModel.addColumn("");
		orderModel.addColumn("메  뉴");
		orderModel.addColumn("가  격");
		orderModel.addColumn("설  명");

		if (DBUtil.dbconn == null) {
			DBUtil.DBConnect();
		}

		String sql = "SELECT idx, menu, price, explanation FROM delivery";

		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				orderModel.addRow(new Object[] { rs.getInt(1), // idx
//					rs.getString(2), // kind
//					rs.getString(3), // company
						rs.getString(2), // menu
						rs.getString(3), // price
//					rs.getString(6), // num
//					rs.getString(7), // addr
						rs.getString(4) // explanation
				});
			} // end of while()
			rs.close();
			pstmt.close();

			tblOrder.setModel(orderModel);
			// tblOrder.setAutoResizeMode(0); // 테이블의 크기를 자동 조정해준다.
			tblOrder.getColumnModel().getColumn(0).setPreferredWidth(0); // idx
			tblOrder.getColumnModel().getColumn(1).setPreferredWidth(70); // menu
			tblOrder.getColumnModel().getColumn(2).setPreferredWidth(70); // price
			tblOrder.getColumnModel().getColumn(3).setPreferredWidth(150); // explanation

			JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");

		} catch (SQLException eload) {
			JOptionPane.showMessageDialog(null, "[MyMSG] 테이블 로딩 오류");
			eload.printStackTrace();
		}
	}// end of LoadTbl()

	private void setTxtField(int idx) {
		String sql = "SELECT idx, menu, price, explanation FROM delivery where idx = ?";

		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orMenu = rs.getString(2);
				orPrice = rs.getString(3);
				orExplanation = rs.getString(4);
			}
		} catch (SQLException eset) {
			eset.printStackTrace();
		}

	} // end of setTxtField

	private void LoadOrderTbl() {
		orderListModel = new DefaultTableModel();
		orderListModel.addColumn("");
		orderListModel.addColumn("메  뉴");
		orderListModel.addColumn("가  격");
		orderListModel.addColumn("설  명");

		if (DBUtil.dbconn == null) {
			DBUtil.DBConnect();
		}

		String sql = "SELECT idx, menu, price, explanation FROM orderList WHERE userid = ?";

		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			pstmt.setString(1, DeliveryLogin.ID);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orderListModel.addRow(new Object[] { rs.getInt(1), // idx
						rs.getString(2), // menu
						rs.getString(3), // price
						rs.getString(4) // explanation
				});
			} // end of while()

			rs.close();
			pstmt.close();

			tblOrderList.setModel(orderListModel);
			// tblOrder.setAutoResizeMode(0); // 테이블의 크기를 자동 조정해준다.
			tblOrderList.getColumnModel().getColumn(0).setPreferredWidth(0); // idx
			tblOrderList.getColumnModel().getColumn(1).setPreferredWidth(70); // menu
			tblOrderList.getColumnModel().getColumn(2).setPreferredWidth(70); // price
			tblOrderList.getColumnModel().getColumn(3).setPreferredWidth(150); // explanation

		} catch (SQLException eload) {
			JOptionPane.showMessageDialog(null, "[MyMSG] 테이블 로딩 오류");
			eload.printStackTrace();
		}
	}// end of LoadOrderTbl()

	private void setTxtOrderField(int idx) {
		String sql = "SELECT idx, menu, price, explanation FROM orderList where idx = ?";

		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			pstmt.setInt(1, idx);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				orMenu = rs.getString(2);
//				orPrice = rs.getString(3);
//				orExplanation = rs.getString(4);
//			}
		} catch (SQLException eset) {
			eset.printStackTrace();
		}

	} // end of setTxtField

}// end of class
