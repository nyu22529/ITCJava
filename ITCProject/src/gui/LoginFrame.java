package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {

	private JFrame frmLoginFrame;
	private JTextField tfId;
	private JPasswordField pwF;

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

			}
		});
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 13));
		btnLogin.setBounds(40, 120, 100, 35);
		frmLoginFrame.getContentPane().add(btnLogin);

		JButton btnSugnUp = new JButton("회원가입");
		btnSugnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSugnUp.setFont(new Font("굴림", Font.PLAIN, 13));
		btnSugnUp.setBounds(160, 120, 100, 35);
		frmLoginFrame.getContentPane().add(btnSugnUp);
	}
}
