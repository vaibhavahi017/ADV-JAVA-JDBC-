package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDemo {
	public static void main(String[] args) {
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","VAIBHAV09", "VAIBHAV09");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into student values(5,'Aditya',80 )");
		System.out.println("one record insert successfully");
		
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
