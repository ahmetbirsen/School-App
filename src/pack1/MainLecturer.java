package pack1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class MainLecturer extends JFrame {
	
	
	
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] colons = {"ID","Name","Surname","Department","Course"};
	Object[] lines = new Object[5];
	private JButton btn_showStu;
	private JButton btnNewButton;
	
	private JButton deleteButton;
	dbConnector connect = new dbConnector();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JRadioButton enginBotton;
	private JRadioButton progBotton;
	private JLabel lblNewLabel_4;
	private JTextField text_name;
	private JTextField text_surname;
	private JTextField text_id;
	private JComboBox courseBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLecturer frame = new MainLecturer();
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
	public MainLecturer() {
		setTitle("Lecturer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 852, 312);
		contentPane.add(scrollPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		model.setColumnIdentifiers(colons);
		table.setModel(model);
		table.setBounds(84, 127, 283, 167);
		scrollPane.setViewportView(table);
		btn_showStu = new JButton("Show Student");
		btn_showStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				ResultSet rs = dbConnector.connection();
				
				try {
					while(rs.next()) {
						lines[0] = rs.getString("ID");
						lines[1] = rs.getString("Name");
						lines[2] = rs.getString("Surname");
						lines[3] = rs.getString("Department");
						lines[4] = rs.getString("Course");
						model.addRow(lines);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(model);
				
			}
		});
		
		
		
		
		
		btn_showStu.setBounds(543, 354, 155, 23);
		contentPane.add(btn_showStu);
		
		btnNewButton = new JButton("Add New Student");
		
		btnNewButton.setBounds(543, 418, 155, 23);
		contentPane.add(btnNewButton);
		
		deleteButton = new JButton("Delete Student");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dbConnector db = new dbConnector();
				db.deleteStudent((String) table.getValueAt(table.getSelectedRow(), 0));
				model.removeRow(table.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Successfuly deleted");
				
			}
		});
		deleteButton.setBounds(543, 502, 148, 23);
		contentPane.add(deleteButton);
		
		lblNewLabel = new JLabel("Name ");
		lblNewLabel.setBounds(37, 358, 72, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setBounds(37, 402, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(37, 450, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setBounds(37, 506, 58, 14);
		contentPane.add(lblNewLabel_3);
		courseBox = new JComboBox();
		courseBox.setBounds(129, 613, 155, 22);
		contentPane.add(courseBox);
		progBotton = new JRadioButton("Computer Programming");
		progBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Computer Network","Database System","Calculus"}));
			}
		});
		buttonGroup.add(progBotton);
		progBotton.setBounds(129, 544, 189, 23);
		contentPane.add(progBotton);
		
		enginBotton = new JRadioButton("Computer Engineering");
		enginBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Digital System Design","Visual Programming","Operating System"}));
			}
		});
		buttonGroup.add(enginBotton);
		enginBotton.setBounds(129, 502, 189, 23);
		contentPane.add(enginBotton);
		
		
		
		lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setBounds(37, 617, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		text_name = new JTextField();
		text_name.setBounds(129, 357, 155, 20);
		contentPane.add(text_name);
		text_name.setColumns(10);
		
		text_surname = new JTextField();
		text_surname.setBounds(129, 399, 155, 20);
		contentPane.add(text_surname);
		text_surname.setColumns(10);
		
		text_id = new JTextField();
		text_id.setBounds(129, 447, 155, 20);
		contentPane.add(text_id);
		text_id.setColumns(10);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main mn = new Main();
				mn.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(543, 660, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(667, 660, 89, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
					String sql = "insert into students values (?,?,?,?,?)";
					PreparedStatement prst = conn.prepareStatement(sql);
					prst.setString(1,String.valueOf(text_id.getText()));
					prst.setString(2, text_name.getText());
					prst.setString(3, text_surname.getText());
					String department = null;
					if(enginBotton.isSelected()) {
						department = enginBotton.getText();
					}
					if(progBotton.isSelected()) {
						department = progBotton.getText();
					}
					prst.setString(4, department);
					prst.setString(5, String.valueOf(courseBox.getSelectedItem()));
					prst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfuly add");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		
		
		
		//contentPane.add(table);
		
		
	}
}
