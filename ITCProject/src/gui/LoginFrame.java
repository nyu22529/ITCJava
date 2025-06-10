package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.DBConn;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame {

	private JFrame frmLoginFrame;
	private JTextField tfId;
	private JPasswordField pwF;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frmLoginFrame.setLocationRelativeTo(null);
					window.frmLoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
		conn = DBConn.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginFrame = new JFrame();
		frmLoginFrame.setTitle("로그인");
		frmLoginFrame.setBounds(100, 100, 330, 220);
		frmLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginFrame.getContentPane().setLayout(null);

		JLabel lnlId = new JLabel("학번(ID)");
		lnlId.setFont(new Font("굴림", Font.PLAIN, 14));
		lnlId.setBounds(40, 30, 60, 28);
		frmLoginFrame.getContentPane().add(lnlId);

		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 13));
		tfId.setBounds(110, 30, 150, 28);
		frmLoginFrame.getContentPane().add(tfId);
		tfId.setColumns(10);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("굴림", Font.PLAIN, 14));
		lblPw.setBounds(40, 70, 60, 28);
		frmLoginFrame.getContentPane().add(lblPw);

		pwF = new JPasswordField();
		pwF.setFont(new Font("굴림", Font.PLAIN, 13));
		pwF.setBounds(110, 70, 150, 28);
		frmLoginFrame.getContentPane().add(pwF);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT * FROM student_info WHERE id=? AND password=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfId.getText());
					pstmt.setString(2, pwF.getText());

					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString("name");

						System.out.println(id + " - " + name);
						JOptionPane.showMessageDialog(frmLoginFrame, "아이디와 패스워드가 일치합니다.");

						frmLoginFrame.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(frmLoginFrame, "아이디와 패스워드가 일치하지 않습니다.");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 13));
		btnLogin.setBounds(40, 120, 100, 35);
		frmLoginFrame.getContentPane().add(btnLogin);

		JButton btnSugnUp = new JButton("회원가입");
		btnSugnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame window = new SignUpFrame();
				window.getFrame().setLocationRelativeTo(null);
				window.getFrame().setVisible(true);
			}
		});
		btnSugnUp.setFont(new Font("굴림", Font.PLAIN, 13));
		btnSugnUp.setBounds(160, 120, 100, 35);
		frmLoginFrame.getContentPane().add(btnSugnUp);
	}
}
