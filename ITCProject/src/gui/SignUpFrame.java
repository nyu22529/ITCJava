package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame {

	private JFrame frmSignUpFrame;
	private JTextField tfId;
	private JPasswordField pwF;
	private JTextField tfName;
	private JTextField tfGrades;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUpFrame = new JFrame();
		frmSignUpFrame.setTitle("회원가입");
		frmSignUpFrame.setBounds(100, 100, 430, 330);
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

		JLabel lblGrade = new JLabel("학년");
		lblGrade.setFont(new Font("굴림", Font.PLAIN, 14));
		lblGrade.setBounds(50, 180, 80, 28);
		frmSignUpFrame.getContentPane().add(lblGrade);

		JComboBox grades = new JComboBox();
		grades.setFont(new Font("굴림", Font.PLAIN, 13));
		grades.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		grades.setBounds(140, 180, 60, 28);
		frmSignUpFrame.getContentPane().add(grades);

		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoin.setFont(new Font("굴림", Font.PLAIN, 13));
		btnJoin.setBounds(90, 240, 100, 35);
		frmSignUpFrame.getContentPane().add(btnJoin);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 13));
		btnCancel.setBounds(210, 240, 100, 35);
		frmSignUpFrame.getContentPane().add(btnCancel);

	}
}
