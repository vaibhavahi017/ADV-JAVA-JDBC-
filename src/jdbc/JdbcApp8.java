package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcApp8 {
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private String dbuname = "VAIBHAV09";
	private String dbpwd = "VAIBHAV09";
	
	Scanner sc  = new Scanner(System.in);
	
	void meth1() {
		System.out.println("Implementing jdbcRowset");
		
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs =rsf.createJdbcRowSet();
			jrs.setUrl(dburl);
			jrs.setUsername(dbuname);
			jrs.setPassword(dbpwd);
			jrs.setCommand("select * from employee01");
			jrs.execute();
			jrs.last();
			
	System.out.println(jrs.getInt(1) +" " +jrs.getString(2)+" " + jrs.getString(3)+" " +jrs.getInt(4)+" "+jrs.getString(5));
	
		System.out.println("=======for last =========");
		
		jrs.first();
		System.out.println(jrs.getInt(1) +" " +jrs.getString(2)+" " + jrs.getString(3)+" " +jrs.getInt(4)+" "+jrs.getString(5));
		System.out.println("========for first=========");
		
		jrs.beforeFirst();
		while(jrs.next())
		System.out.println(jrs.getInt(1) +" " +jrs.getString(2)+" " + jrs.getString(3)+" " +jrs.getInt(4)+" "+jrs.getString(5));
		System.out.println("====for before first=====");
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void m2() {
		System.out.println("Implementing CachedRowset");
		Scanner sc = new Scanner(System.in);
		
		
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dburl);
			crs.setUsername(dbuname);
			crs.setPassword(dbpwd);
			crs.setCommand("select eid,efname,esal from employee01");
			crs.execute();
			
			System.out.println("emter empId :");
			String eid = sc.nextLine();
			
			System.out.println("Enter Emp sal");
			int sal = Integer.parseInt(sc.nextLine());
			
			while(crs.next()) {
				if(crs.getString(1).equals(eid)) {
					System.out.println("Update the salary of Employee :");
					
					crs.updateInt("esal", sal);
					crs.updateRow();
					System.out.println(crs.getInt(1) +" " +crs.getString(2)+" " +crs.getInt(3));

				}
			}
	//crs.acceptChanges();

			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public static void main(String[] args) {
		JdbcApp8 obj = new JdbcApp8();
		//obj.meth1();
		obj.m2();
		
	}

}
