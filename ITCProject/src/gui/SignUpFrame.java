package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.DBConn;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignUpFrame {

	private JFrame frmSignUpFrame;
	private JTextField tfId;
	private JPasswordField pwF;
	private JTextField tfName;
	private Connection conn;
	private JComboBox grades;
	private JTextField tfDept;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame window = new SignUpFrame();
					window.frmSignUpFrame.setLocationRelativeTo(null);
					window.frmSignUpFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpFrame() {
		conn = DBConn.init();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUpFrame = new JFrame();
		frmSignUpFrame.setTitle("회원가입");
		frmSignUpFrame.setBounds(100, 100, 430, 380);
		frmSignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUpFrame.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("학번(ID)");
		lblId.setFont(new Font("굴림", Font.PLAIN, 14));
		lblId.setBounds(50, 30, 80, 28);
		frmSignUpFrame.getContentPane().add(lblId);

		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 13));
		tfId.setBounds(140, 30, 130, 28);
		frmSignUpFrame.getContentPane().add(tfId);
		tfId.setColumns(10);

		JButton btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT * FROM student_info WHERE id=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfId.getText());

					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {
						JOptionPane.showMessageDialog(frmSignUpFrame, "이미 존재하는 아이디입니다.");
					} else {
						JOptionPane.showMessageDialog(frmSignUpFrame, "아이디 중복 확인");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCheck.setFont(new Font("굴림", Font.PLAIN, 13));
		btnCheck.setBounds(285, 30, 90, 28);
		frmSignUpFrame.getContentPane().add(btnCheck);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("굴림", Font.PLAIN, 14));
		lblPw.setBounds(50, 80, 80, 28);
		frmSignUpFrame.getContentPane().add(lblPw);

		pwF = new JPasswordField();
		pwF.setFont(new Font("굴림", Font.PLAIN, 13));
		pwF.setBounds(140, 80, 130, 28);
		frmSignUpFrame.getContentPane().add(pwF);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 14));
		lblName.setBounds(50, 130, 80, 28);
		frmSignUpFrame.getContentPane().add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("굴림", Font.PLAIN, 13));
		tfName.setBounds(140, 130, 130, 28);
		frmSignUpFrame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JLabel lblDept = new JLabel("학과");
		lblDept.setFont(new Font("굴림", Font.PLAIN, 14));
		lblDept.setBounds(50, 180, 80, 28);
		frmSignUpFrame.getContentPane().add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setFont(new Font("굴림", Font.PLAIN, 13));
		tfDept.setBounds(140, 180, 130, 28);
		frmSignUpFrame.getContentPane().add(tfDept);
		tfDept.setColumns(10);

		JLabel lblGrade = new JLabel("학년");
		lblGrade.setFont(new Font("굴림", Font.PLAIN, 14));
		lblGrade.setBounds(50, 230, 80, 28);
		frmSignUpFrame.getContentPane().add(lblGrade);

		grades = new JComboBox();
		grades.setFont(new Font("굴림", Font.PLAIN, 13));
		grades.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		grades.setBounds(140, 230, 60, 28);
		frmSignUpFrame.getContentPane().add(grades);

		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO student_info" + "(id, password, name, dept, grade) "
							+ "VALUES(?, ?, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfId.getText().trim());
					pstmt.setString(2, pwF.getText().trim());
					pstmt.setString(3, tfName.getText().trim());
					pstmt.setString(4, tfDept.getText().trim());
					pstmt.setInt(5, Integer.parseInt(grades.getSelectedItem().toString()));

					pstmt.execute();

					JOptionPane.showMessageDialog(frmSignUpFrame, "회원가입 성공");

					pstmt.close();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnJoin.setFont(new Font("굴림", Font.PLAIN, 13));
		btnJoin.setBounds(90, 280, 100, 35);
		frmSignUpFrame.getContentPane().add(btnJoin);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignUpFrame.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 13));
		btnCancel.setBounds(210, 280, 100, 35);
		frmSignUpFrame.getContentPane().add(btnCancel);
		
	}

	public JFrame getFrame() {
		return frmSignUpFrame;
	}
}
