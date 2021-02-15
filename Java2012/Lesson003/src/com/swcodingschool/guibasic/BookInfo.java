package com.swcodingschool.guibasic;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class BookInfo extends JFrame {
    // 클래수(전역) 변수
    private JPanel contentPane;
    private JTable tblTitle;
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtPublisherID;
    private JTextField txtPrice;
    private JButton btnExit;
    private JButton btnReset;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnReload;
    private JScrollPane scrollPane;

    DefaultTableModel model;
    private int bookid4update;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookInfo frame = new BookInfo();
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
    public BookInfo() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                // 프레임이 뜰 때 테이블을 로드한다.
                LoadTbl();
            }
        });
        setTitle("Book Infomation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 662, 455);
        contentPane = new JPanel();
        contentPane.setLocation(-14, -113);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
        setContentPane(contentPane);

        btnExit = new JButton("Exit");
        btnExit.setBounds(540, 368, 96, 32);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (DBUtil.dbconn != null) { // DB가 연결되어진 상태라면
                    DBUtil.DBClose();// DB연동을 끊음.
                }
                dispose(); // windows 창을 닫는 메서드
                System.exit(0); // 전체 프로그램을 정상적으로 종료
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnExit);

        JLabel lblNewLabel = new JLabel("도서정보관리시스템");
        lblNewLabel.setBounds(142, 10, 362, 45);
        lblNewLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        contentPane.add(lblNewLabel);

        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtTitle.setText("");
                txtAuthor.setText("");
                txtPublisherID.setText("");
                txtPrice.setText("");

                // reset과 save를 disalbe하게 한다.
                btnSave.setEnabled(true);
                btnReset.setEnabled(true);
                btnReload.setEnabled(true);
            }
        });
        btnReset.setBounds(10, 368, 96, 32);
        contentPane.add(btnReset);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String sql = "INSERT INTO tblBook(title, author, publisherid, price) VALUES (?, ?, ?, ?)";

                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String publisherid = txtPublisherID.getText();
                String price = txtPrice.getText();


                try {
                    PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

                    pstmt.setString(1, title);
                    pstmt.setString(2, author);
                    pstmt.setString(3, publisherid);
                    pstmt.setString(4, price);

                    pstmt.execute();
                    LoadTbl();

                    txtTitle.setText("");
                    txtAuthor.setText("");
                    txtPublisherID.setText("");
                    txtPrice.setText("");

                } catch (SQLException esave) {
                    JOptionPane.showMessageDialog(null, "등록에 오류가 발생했습니다.");
                    esave.printStackTrace();
                }
            }
        });
        btnSave.setBounds(116, 368, 96, 32);
        contentPane.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //update 버튼을 클릭했을 때
                String sql = "UPDATE tblBook SET title = ?, author = ?, publisherid = ?, price = ? WHERE bookid = ?";

                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String publisherid = txtPublisherID.getText();
                String price = txtPrice.getText();

                try {
                    PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
                    pstmt.setString(1, txtTitle.getText());
                    pstmt.setString(2, author);
                    pstmt.setInt(3, Integer.parseInt(publisherid));
                    pstmt.setInt(4, Integer.parseInt(price));
                    pstmt.setInt(5, bookid4update);

                    pstmt.execute();
                    LoadTbl();

                    // reset과 save를 되돌린다.
                    btnSave.setEnabled(true);
                    btnReset.setEnabled(true);
                    btnReload.setEnabled(true);

                    txtTitle.setText("");
                    txtAuthor.setText("");
                    txtPublisherID.setText("");
                    txtPrice.setText("");

                } catch (SQLException eupdate) {
                    JOptionPane.showMessageDialog(null, "업데이트에 오류가 발생했습니다.");
                    eupdate.printStackTrace();
                }
            }
        });

        btnUpdate.setBounds(222, 368, 96, 32);
        contentPane.add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "DELETE FROM tblBook WHERE bookid = ? ";

                try {
                    PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);

                    pstmt.setInt(1, bookid4update);
                    pstmt.execute();

                    txtTitle.setText("");
                    txtAuthor.setText("");
                    txtPublisherID.setText("");
                    txtPrice.setText("");

                    LoadTbl();
                } catch (SQLException edelete) {
                    JOptionPane.showMessageDialog(null, "제거 오류가 발생했습니다.");
                    edelete.printStackTrace();
                }


            }
        });
        btnDelete.setBounds(328, 368, 96, 32);
        contentPane.add(btnDelete);

        btnReload = new JButton("Reload");
        btnReload.setBounds(434, 368, 96, 32);
        contentPane.add(btnReload);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(309, 75, 329, 259);
        contentPane.add(scrollPane);

        tblTitle = new JTable();
        tblTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 테이블의 특정 행을 마우스로 클릭했을 때
                int row = tblTitle.getSelectedRow();
                // tblTitle에서 모델을 받은 후 값을 받고 그 값을 String 바꾼후 정수형으로 변환.
                bookid4update = Integer.parseInt(tblTitle.getModel().getValueAt(row, 0).toString());

                // reset과 save를 disalbe하게 한다.
                btnSave.setEnabled(false);
                btnReload.setEnabled(false);

                // 해당 레코드의 id를 이용하여 필드값을 채우는 메서드를 호출
                setTxtField(bookid4update);
            }
        });
        tblTitle.setModel(new DefaultTableModel(
        ));
        scrollPane.setViewportView(tblTitle);

        JPanel panel = new JPanel();
        panel.setBounds(12, 75, 280, 259);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1_3 = new JLabel("정   가");
        lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_3.setBounds(12, 202, 50, 18);
        panel.add(lblNewLabel_1_3);

        txtTitle = new JTextField();
        txtTitle.setBounds(82, 36, 160, 21);
        txtTitle.setColumns(10);
        panel.add(txtTitle);

        JLabel lblNewLabel_1_2 = new JLabel("출판사");
        lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(12, 147, 54, 18);
        panel.add(lblNewLabel_1_2);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(82, 91, 160, 21);
        txtAuthor.setColumns(10);
        panel.add(txtAuthor);

        JLabel lblNewLabel_1_1 = new JLabel("지은이");
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(12, 92, 54, 18);
        panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1 = new JLabel("도서명");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1.setBounds(12, 37, 54, 18);
        panel.add(lblNewLabel_1);

        txtPublisherID = new JTextField();
        txtPublisherID.setBounds(82, 146, 160, 21);
        txtPublisherID.setColumns(10);
        panel.add(txtPublisherID);

        txtPrice = new JTextField();
        txtPrice.setBounds(82, 201, 160, 21);
        txtPrice.setColumns(10);
        panel.add(txtPrice);
    } // end of Book Info()

    private void LoadTbl() {
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("도서명");
        model.addColumn("저  자");
        model.addColumn("출판사");
        model.addColumn("정  가");

        if (DBUtil.dbconn == null) {
            DBUtil.DBConnect();
        }

        String sql = "SELECT * FROM tblBook";

        try {
            PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt(1),    // bookid
                        rs.getString(2), // title
                        rs.getString(3), // author
                        rs.getInt(4), // publisherid
                        rs.getInt(5)     // price
                });
            }// end of while()
            rs.close();
            pstmt.close();

            tblTitle.setModel(model);
            tblTitle.setAutoResizeMode(0); // 테이블의 크기를 자동 조정해준다.
            tblTitle.getColumnModel().getColumn(0).setPreferredWidth(30); // bookid
            tblTitle.getColumnModel().getColumn(1).setPreferredWidth(150); // title
            tblTitle.getColumnModel().getColumn(2).setPreferredWidth(50); // author
            tblTitle.getColumnModel().getColumn(3).setPreferredWidth(50); // publisher
            tblTitle.getColumnModel().getColumn(4).setPreferredWidth(50); // price

            JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");

        } catch (SQLException eload) {
            JOptionPane.showMessageDialog(null, "[MyMSG] 테이블 로딩 오류");
            eload.printStackTrace();
        }


    }// end of LoadTbl()

    private void setTxtField(int id) {
        String sql = "SELECT * FROM tblBook WHERE bookid = ?";

        try {
            PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                txtTitle.setText(rs.getString(2));    // title
                txtAuthor.setText(rs.getString(3)); // author
                txtPublisherID.setText(String.valueOf(rs.getInt(4))); // publisher
                txtPrice.setText(String.valueOf(rs.getInt(5)));     // price
            }// end of while()
        } catch (SQLException eset) {
            JOptionPane.showMessageDialog(null, "해당 레코드 조회 오류");
            System.out.println("[MyMSG] 해당 레코드 조회 오류");
            eset.printStackTrace();
        }
    } // end of setTxtField
} // end of class
