package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDemo {
	public static void main(String[] args) {
		try {		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "VAIBHAV09", "VAIBHAV09");
		Statement stmt = con.createStatement();
		stmt.execute("create table Course(cname varchar2(10),cfee number(5))");
		System.out.println("Table Created Successfully");
		
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
