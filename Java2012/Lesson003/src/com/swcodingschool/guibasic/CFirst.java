package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class CFirst extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CFirst frame = new CFirst();
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
    public CFirst() {
        setTitle("First Frame");
        setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close(X) 버튼
        setBounds(100, 100, 650, 500); // 창크기
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("처음 만드는 프레임");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("a고속도로", Font.BOLD, 15));
        lblNewLabel.setBounds(217, 24, 241, 38);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(244, 101, 116, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(234, 132, 212, 21);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(263, 201, 97, 23);
        contentPane.add(btnNewButton);

        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        chckbxNewCheckBox.setBounds(189, 238, 105, 23);
        contentPane.add(chckbxNewCheckBox);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
        rdbtnNewRadioButton.setBounds(325, 238, 121, 23);
        contentPane.add(rdbtnNewRadioButton);

        JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
        tglbtnNewToggleButton.setBounds(174, 278, 135, 23);
        contentPane.add(tglbtnNewToggleButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(364, 277, 178, 116);
        contentPane.add(textArea);

        passwordField = new JPasswordField();
        passwordField.setBounds(372, 101, 135, 21);
        contentPane.add(passwordField);
    }

}
