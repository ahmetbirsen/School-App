package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnector {
	
	static ResultSet connection() {
		ResultSet rst = null;
		try {
			String sql ="select * from students";
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
			Statement st = conn.createStatement();
			rst = st.executeQuery(sql); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return rst;
	}
	
	public static Connection connection;
	
	public static Connection openConnection() {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject\",\"root\",\"123456789");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}
	
	public static void closeConnection() {
		
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteStudent(String id) {
		
		String sql = "DELETE FROM students WHERE ID = ?";
		
		try {
			PreparedStatement prst;
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labproject","root","123456789");
			prst = conn.prepareStatement(sql);
			prst.setString(1, id);
			prst.executeUpdate();
			prst.close();
			closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
