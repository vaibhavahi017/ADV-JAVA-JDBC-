package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp7 {

		private String driver = "oracle.jdbc.OracleDriver";
		private String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";
		private String dbuname = "VAIBHAV09";
		private String dbpwd = "VAIBHAV09";
		
		String sqlQuery2 ="select eid,efname,esal from employee01"; 
		  String sqlQuery = "select * from employee01";
		  Scanner sc = new Scanner(System.in);
				
		public Connection connect(){
			Connection con = null;
			try {
				
				Class.forName(driver);
				con = DriverManager.getConnection(dburl,dbuname,dbpwd);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
		void meth1() {
			System.out.println("Implementing scrollable Resultset\n");
			
			try {
				Connection con = connect();
				Statement stmt = con.createStatement(1004,1007);

				ResultSet rs = stmt.executeQuery(sqlQuery);
				
				rs.afterLast();
				while (rs.previous()) {
					System.out.println(rs.getInt(1) +" " +rs.getString(2)+" " + rs.getString(3)+" " +rs.getInt(4)+" "+rs.getString(5));
					
				}
				System.out.println("=============");
				
				rs.absolute(3);
				System.out.println(rs.getInt(1) +" " +rs.getString(2)+" " + rs.getString(3)+" " +rs.getInt(4)+" "+rs.getString(5));

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		void m2() {
			System.out.println("Implementing the scrollable result update...");
			System.out.print("Enter Employee ID: ");
			int searchEid = sc.nextInt();
			try {
				Connection con = connect();
				Statement stmt  =  con.createStatement(1004,1008);
				ResultSet rs = stmt.executeQuery(sqlQuery2);
				
				while(rs.next()) {
					
					
		            int empId = rs.getInt("EID");

					if(empId == searchEid) {
						System.out.println("upadate the salary employee : "+rs.getString(2));
						rs.updateInt("esal", 60000);
						rs.updateRow();
					}
					
				}
				System.out.println("Data updated !!! do you want to view (Y/n");
				char choice = sc.nextLine().charAt(0);
				switch (choice) {
				case 'Y','y' :
					rs.absolute(6);
				System.out.println(rs.getInt(1) +" " +rs.getString(2)+" " +rs.getInt(3));
				break;
				
				case 'N','n' :
				System.out.println("see you soon");
				System.exit(0);
				break;
				
				default :
					System.out.println("invalid data");

				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void main(String[] args) {
			JdbcApp7 obj = new JdbcApp7();
			obj.connect();
		//	obj.meth1();
			obj.m2();
		}
				
	}

