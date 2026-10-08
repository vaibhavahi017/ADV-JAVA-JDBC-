package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class JdbcApp16 {
	private String driver = "oracle.jdbc.OracleDriver";
	private String dburl ="jdbc:oracle:thin:@localhost:1521:ORCL";
	private String dbuname ="VAIBHAV09";
	private String dbpwd ="VAIBHAV09";
	Scanner sc = new Scanner(System.in);
	
	public Connection connect() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl,dbuname,dbpwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	void meth1()  {
		System.out.println("Implementing Batch Proccessing ");
		
		try {
			Connection con = connect();
			Statement stmt = con.createStatement();
			System.out.println("How Many Queries to add to the batch");
			
			int no_of_Queries = Integer.parseInt(sc.nextLine());
			for (int i=1;i<=no_of_Queries;i++) {
				System.out.println("Enter your "+i+"query");
				stmt.addBatch(sc.nextLine());
			}
		int	arr[] =stmt.executeBatch();
		System.out.println("=====>"+Arrays.toString(arr));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JdbcApp16().meth1();
	}
	
	

}
