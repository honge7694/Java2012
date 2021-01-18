package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ButtonGroup;

public class DeliveryInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtAllPrice;
	private JTextField txtOrderFood;
	private JTable tblOrder;
	private JTable tblOrderList;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		rdoChicken.setActionCommand("");
		buttonGroup.add(rdoChicken);
		rdoChicken.setBounds(9, 48, 66, 23);
		panel.add(rdoChicken);
		
		JRadioButton rdoPizza = new JRadioButton("피자집");
		buttonGroup.add(rdoPizza);
		rdoPizza.setBounds(79, 48, 66, 23);
		panel.add(rdoPizza);
		
		JRadioButton rdoChina = new JRadioButton("중국집");
		buttonGroup.add(rdoChina);
		rdoChina.setBounds(149, 48, 70, 23);
		panel.add(rdoChina);
		
		JLabel lblNewLabel = new JLabel("메뉴");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 10, 198, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("동네");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(9, 90, 198, 23);
		panel.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("추가하기");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문 추가하기.
			}
		});
		btnAdd.setBounds(9, 201, 97, 23);
		panel.add(btnAdd);
		
		JComboBox cmbAddr = new JComboBox();
		cmbAddr.setModel(new DefaultComboBoxModel(new String[] {"우암동", "사직동", "서원동"}));
		cmbAddr.setBounds(9, 124, 198, 23);
		panel.add(cmbAddr);
		
		JButton btnReset = new JButton("초기화");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//rdo7
			
			}
		});
		btnReset.setBounds(113, 201, 97, 23);
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 684, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("주문");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_3.setBounds(12, 0, 113, 32);
		panel_1.add(lblNewLabel_3);
		
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
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문할 음식 제거하기
				
			}
		});
		btnDel.setBounds(6, 203, 97, 23);
		panel_2.add(btnDel);
		
		JButton btnOk = new JButton("저장하기");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문할 음식 저장.
			}
		});
		btnOk.setBounds(111, 203, 97, 23);
		panel_2.add(btnOk);
		
		txtAllPrice = new JTextField();
		txtAllPrice.setEditable(false);
		txtAllPrice.setBackground(SystemColor.controlHighlight);
		txtAllPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllPrice.setBounds(10, 42, 198, 21);
		panel_2.add(txtAllPrice);
		txtAllPrice.setColumns(10);
		
		txtOrderFood = new JTextField();
		txtOrderFood.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrderFood.setEditable(false);
		txtOrderFood.setColumns(10);
		txtOrderFood.setBackground(SystemColor.controlHighlight);
		txtOrderFood.setBounds(10, 123, 198, 21);
		panel_2.add(txtOrderFood);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 58, 453, 211);
		contentPane.add(scrollPane);
		
		tblOrder = new JTable();
		scrollPane.setViewportView(tblOrder);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(243, 321, 453, 217);
		contentPane.add(scrollPane_1);
		
		tblOrderList = new JTable();
		scrollPane_1.setViewportView(tblOrderList);
	}
}
