package pack1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginLecturer extends JFrame {
	

	private JPanel contentPane;
	private JTextField txt_user;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginLecturer frame = new LoginLecturer();
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
	public LoginLecturer() {
		setTitle("Login Lecturer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setBounds(65, 68, 87, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(65, 142, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_user = new JTextField();
		txt_user.setBounds(162, 69, 102, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 139, 102, 20);
		contentPane.add(passwordField);
		
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainLecturer ml = new MainLecturer();
				String sql = "select * from labproject.login_lecturer where User = ? and Password = ? ";
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, txt_user.getText());
					psmt.setString(2, new String(passwordField.getPassword()));
					
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Welcome  " + txt_user.getText(), "Successful Login",JOptionPane.PLAIN_MESSAGE);
						ml.setVisible(true);
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid Username/Password","UnSuccessful Login",JOptionPane.PLAIN_MESSAGE);
					}
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn_login.setBounds(162, 233, 102, 23);
		contentPane.add(btn_login);
	}

}





