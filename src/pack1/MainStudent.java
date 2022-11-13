package pack1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MainStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
 DefaultTableModel model = new DefaultTableModel();
	
	Object[] colons = {"ID","Name","Surname","Department","Course","Lecturer"};
	Object[] lines = new Object[6];
	
	private JButton showLectures;
	private JTextField txt_name;
	private JTextField txt_id;
	private JTextField txt_surname;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStudent frame = new MainStudent();
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
	public MainStudent() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 945, 163);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(colons);
		table.setModel(model);
		table.setBounds(74, 81, 356, 146);
		scrollPane.setViewportView(table);
		
		showLectures = new JButton("Show Lecture Plan");
		showLectures.setFont(new Font("Tahoma", Font.BOLD, 11));
		showLectures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				
				try {
					ResultSet rs = null;
					String sql ="select * from student_lecture";
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
					Statement st = conn.createStatement();
					rs = st.executeQuery(sql); 
					while(rs.next()) {
						lines[0] = rs.getString("ID");
						lines[1] = rs.getString("Name");
						lines[2] = rs.getString("Surname");
						lines[3] = rs.getString("Department");
						lines[4] = rs.getString("Course");
						lines[5] = rs.getString("Lecturer");
						model.addRow(lines);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				table.setModel(model);
				
			}
			
		});
		showLectures.setBounds(26, 211, 149, 30);
		contentPane.add(showLectures);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(238, 201, 717, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(31, 35, 79, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 95, 79, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 148, 46, 14);
		panel.add(lblNewLabel_2);
		
		txt_name = new JTextField();
		txt_name.setBounds(115, 36, 143, 20);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setBounds(115, 145, 143, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(31, 243, 79, 14);
		panel.add(lblNewLabel_3);
		JComboBox lecBox = new JComboBox();
		JComboBox courseBox = new JComboBox();
		JRadioButton enginButton = new JRadioButton("Computer Engineering");
		buttonGroup.add(enginButton);
		enginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Digital System Design","Visual Programming","Operating System"}));
				lecBox.setModel(new DefaultComboBoxModel(new String[] {"Peri Gunes","Adem Ozyavas","Naim Mahmood"}));
			}
		});
		enginButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		enginButton.setBounds(125, 213, 154, 23);
		panel.add(enginButton);
		
		JRadioButton progButton = new JRadioButton("Computer Programming");
		buttonGroup.add(progButton);
		progButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Computer Network","Database System","Calculus"}));
				lecBox.setModel(new DefaultComboBoxModel(new String[] {"Selcuk Sener","Hakan Emekli","Aysegul Kývýlcým"}));
			}
		});
		progButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		progButton.setBounds(125, 260, 177, 23);
		panel.add(progButton);
		
		JLabel lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(374, 39, 79, 14);
		panel.add(lblNewLabel_4);
		
		
		courseBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		courseBox.setBounds(447, 35, 238, 22);
		panel.add(courseBox);
		
		JLabel lblNewLabel_5 = new JLabel("Lecturer");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(374, 148, 65, 14);
		panel.add(lblNewLabel_5);
		
		
		lecBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		lecBox.setBounds(447, 144, 238, 22);
		panel.add(lecBox);
		
		txt_surname = new JTextField();
		txt_surname.setBounds(115, 92, 143, 20);
		panel.add(txt_surname);
		txt_surname.setColumns(10);
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(257, 344, 149, 30);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_1 = new JButton("Take Lecture");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(26, 288, 149, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main mn = new Main();
				mn.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(26, 370, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(26, 450, 89, 23);
		contentPane.add(btnNewButton_3);

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
					String sql = "insert into student_lecture values (?,?,?,?,?,?)";
					PreparedStatement prst = conn.prepareStatement(sql);
					
					prst.setString(1, txt_name.getText());
					prst.setString(2, txt_surname.getText());
					prst.setString(3,String.valueOf(txt_id.getText()));
					String department = null;
					if(enginButton.isSelected()) {
						department = enginButton.getText();
					}
					if(progButton.isSelected()) {
						department = progButton.getText();
					}
					prst.setString(4, department);
					prst.setString(5, String.valueOf(courseBox.getSelectedItem()));
					prst.setString(6, String.valueOf(lecBox.getSelectedItem()));
					prst.executeUpdate();
					JOptionPane.showMessageDialog(null, "You Successfuly Take Lecture");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
			}
		
	}
