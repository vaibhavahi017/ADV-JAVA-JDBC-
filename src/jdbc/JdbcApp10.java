package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class JdbcApp10 {
	
	 private String driver = "oracle.jdbc.OracleDriver";
	    private String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	    private String dbuname = "VAIBHAV09";
	    private String dbpwd = "VAIBHAV09";
	    Scanner sc = new Scanner(System.in);
	    
	    public Connection connect() {
	    	Connection con=null;
	    	
	    	try {
				Class.forName(driver);
				con= DriverManager.getConnection(dburl,dbuname,dbpwd);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		    return con;
 }
	   public  void insertData() {
	    	System.out.println("Implementing the Callable Statement");
	    	
	    	
	    	
	    	
	    	try {
	    		Connection con = connect();
				CallableStatement cstmt = con.prepareCall("{call INSERTEMPDATA01(?,?,?,?,?)}");
				
				System.out.println("enter Eid");
				String eid = sc.nextLine();
				
				System.out.println("enter EName");
				String ename  = sc.nextLine();
				
				System.out.println("enter Edesg");
				String edesg = sc.nextLine();
				
				System.out.println("enter Ebsal");
		         int bsal = Integer.parseInt(sc.nextLine());
				
				System.out.println("enter Eid");
				float  tsal = bsal+(0.35f*bsal)+(0.10f*bsal);
				
				
				cstmt.setString(1, eid);
				cstmt.setString(2, ename);
				cstmt.setString(3, edesg);
				cstmt.setInt(4, bsal);
				cstmt.setFloat(5, tsal);
				
				cstmt.execute();
				
				System.out.println("Data Inserted");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }
	   
	   void retrieData() {
		   System.out.println("Implementing Callable Statements too retrife data");
		   
		   try {
			Connection con = connect();
			   CallableStatement cstmt=  con.prepareCall("{call RETRIVEEMPDETAILS (?,?,?,?,?)}");
			   System.out.println("coonnnection created");
			   
			   System.out.println("enter empid:");
			   String eid = sc.nextLine();
			   
			   cstmt.setString(1, eid);
			   cstmt.registerOutParameter(2, Types.VARCHAR);
			   cstmt.registerOutParameter(3, Types.VARCHAR);
			   cstmt.registerOutParameter(4, Types.INTEGER);
			   cstmt.registerOutParameter(5, Types.FLOAT);
			   
			   cstmt.execute();
			  
			  
				  System.out.println("***********Employee Details************");
				  System.out.println("employee id :"+eid);
				  System.out.println("employee name :"+cstmt.getString(2));
				  System.out.println("employee desg : "+cstmt.getString(3));
				  System.out.println("emp bsal :"+cstmt.getInt(4));
				  System.out.println("emp tsal :"+cstmt.getFloat(5));
				  
			  
			   
			   System.out.println("Data Retrive");
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Employee id is not Available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   
	   void retriveTsal() {
		   try {
			Connection con = connect();
			   CallableStatement cstmt = con.prepareCall("{call ?:=RETRIVETSAL(?)}");//first  ? for etsal se
			   System.out.println("Enter employee id :");
			   String eid = sc.nextLine();
			   cstmt.setString(2, eid);//2 is for second ? mark for eid
			   cstmt.registerOutParameter(1, Types.FLOAT);
			   cstmt.execute();
			   
			   System.out.println("employee id : " +eid +" Total sal :"+cstmt.getFloat(1));
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	   }
	    public static void main(String[] args) {
			JdbcApp10 obj = new JdbcApp10();
			
			//obj.insertData();
			//obj.retrieData();
			obj.retriveTsal();
		}
	  


}
