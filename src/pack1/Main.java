package pack1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	
	LoginStudent log_stu = new LoginStudent();
	LoginLecturer log_lec = new LoginLecturer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Welcome School Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome School Application");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(122, 32, 287, 77);
		contentPane.add(lblNewLabel);
		
		JButton enter_lecturer = new JButton("LECTURER");
		enter_lecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log_lec.setVisible(true);
				dispose();
			}
		});
		enter_lecturer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		enter_lecturer.setBounds(43, 155, 161, 113);
		contentPane.add(enter_lecturer);
		
		JButton btnNewButton_1 = new JButton("STUDENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log_stu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(264, 155, 161, 113);
		contentPane.add(btnNewButton_1);
	}
}
