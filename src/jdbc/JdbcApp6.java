package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcApp6 {
	
	
	void m1() {
		System.out.println("=======TYPES========");
		System.out.println(ResultSet.TYPE_FORWARD_ONLY);
		System.out.println(ResultSet.TYPE_SCROLL_INSENSITIVE);
		System.out.println(ResultSet.TYPE_SCROLL_SENSITIVE);
		
		System.out.println("=====Modes=======");
		System.out.println(ResultSet.CONCUR_READ_ONLY);
		System.out.println(ResultSet.CONCUR_UPDATABLE);
		
	}
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","VAIBHAV09", "VAIBHAV09");
			JdbcApp6 j1 = new JdbcApp6();
			j1.m1();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
