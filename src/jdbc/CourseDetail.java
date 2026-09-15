package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CourseDetail {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","VAIBHAV09", "VAIBHAV09");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into Course values('ui',2000)");
			System.out.println("one record insert successfully");
			
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	

}
