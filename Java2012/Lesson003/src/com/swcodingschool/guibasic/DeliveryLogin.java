package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DeliveryLogin extends JFrame {

    private JPanel contentPane;
    private JTextField txtUserID;
    private JPasswordField txtUserPWD;
    static String ID = null;

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

                    DeliveryLogin frame = new DeliveryLogin();
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
    public DeliveryLogin() {
        setTitle("DeliveryLogin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인을 하면 음식점목록이 나타남.
                if (DBUtil.dbconn == null) {
                    DBUtil.DBConnect();
                }

                String userid = txtUserID.getText();
                String userpwd = new String(txtUserPWD.getPassword());

                String sql = "SELECT * FROM deuser WHERE userid=? AND userpwd=?";

                try {
                    PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

                    pstmt.setString(1, userid);
                    pstmt.setString(2, userpwd);

                    ResultSet rs = pstmt.executeQuery();


                    if (rs.next()) {
                        rs.close();
                        pstmt.close();

                        if (userid.equals("admin")) {
                            // 관리자 목록으로 가기.

                        } else {
                            // 음식점 목록으로 가기.
                            ID = txtUserID.getText();
                            DeliveryInfo info = new DeliveryInfo();
                            info.setVisible(true);

                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하여주세요.");
                    }
                } catch (SQLException eLogin) {
                    System.out.println("[MyMSG]SQL Exception Error : " + eLogin.getMessage());
                    eLogin.printStackTrace();
                }

            }
        });
        btnLogin.setFont(new Font("굴림", Font.BOLD, 11));
        btnLogin.setBounds(306, 95, 70, 57);
        contentPane.add(btnLogin);

        JButton btnJoin = new JButton("JOIN");
        btnJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원 가입
                dispose(); // 현재 창(프레임)을 닫고
                DeliveryJoin join = new DeliveryJoin();
                join.setVisible(true);
            }
        });
        btnJoin.setBounds(168, 194, 97, 23);
        contentPane.add(btnJoin);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(67, 95, 57, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setBounds(67, 137, 70, 15);
        contentPane.add(lblNewLabel_1);

        txtUserID = new JTextField();
        txtUserID.setBounds(144, 92, 145, 21);
        contentPane.add(txtUserID);
        txtUserID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Delivery System");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_2.setBounds(67, 10, 309, 34);
        contentPane.add(lblNewLabel_2);

        txtUserPWD = new JPasswordField();
        txtUserPWD.setBounds(144, 131, 145, 21);
        contentPane.add(txtUserPWD);
    }
}
