package hcmus.maven.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hcmus.maven.home.StaffHome;
import hcmus.maven.pojo.Staff;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhapForm extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUserName;
	private JPasswordField jtfPassword;
	private JButton btnngNhp;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapForm frame = new DangNhapForm();
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
	public DangNhapForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUserName = new JLabel("Tên đăng nhập:");
		contentPane.add(lblUserName);
		
		jtfUserName = new JTextField();
		contentPane.add(jtfUserName);
		jtfUserName.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		contentPane.add(lblMtKhu);
		
		jtfPassword = new JPasswordField();
		contentPane.add(jtfPassword);
		
		btnngNhp = new JButton("Đăng Nhập");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDangnNhap = jtfUserName.getText().trim();
				String matKhau = jtfPassword.getText().trim();
				Staff s = new Staff();
				s.setAccName(tenDangnNhap);
				s.setPassword(matKhau);
				s = StaffHome.dangNhap(s);
				if(s == null){
					System.out.println("tai khoan khong dun");
				}else{
					MainForm.main(null);
				}
			}
		});
		contentPane.add(btnngNhp);
		
		btnReset = new JButton("Reset");
		contentPane.add(btnReset);
	}

}
