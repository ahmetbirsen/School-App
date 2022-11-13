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

public class LoginStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txt_userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
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
	public LoginStudent() {
		setTitle("Login Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name ");
		lblNewLabel.setBounds(66, 87, 71, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(66, 175, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_userName = new JTextField();
		txt_userName.setBounds(147, 90, 132, 20);
		contentPane.add(txt_userName);
		txt_userName.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainStudent ms = new MainStudent();
				String sql = "select * from labproject.login_student where User = ? and Password = ? ";
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, txt_userName.getText());
					psmt.setString(2, new String(passwordField.getPassword()));
					
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Welcome  " + txt_userName.getText(), "Successful Login",JOptionPane.PLAIN_MESSAGE);
						ms.setVisible(true);
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
		loginButton.setBounds(147, 256, 132, 23);
		contentPane.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 172, 132, 20);
		contentPane.add(passwordField);
	}
}
