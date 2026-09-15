package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


//connection pooling example
public class JdbcApp13 {
//	private String driver ="oracle.jdbc.OracleDriver";
//	private String dburl="jdbc:oracle:thin:@localhost:1521:ORCL";
//	private String dbuname = "VAIBHAV09";
//    private String dbpwd = "VAIBHAV09";
	
	private String dburl,dbuname,dbpwd;
	
	Vector<Connection> v = new Vector<Connection>(); // allow only connection object

   public JdbcApp13( String dburl, String dbuname, String dbpwd) {
	super();
	
	this.dburl = dburl;
	this.dbuname = dbuname;
	this.dbpwd = dbpwd;
}
   
   void con_initialization() {
	   System.out.println("Creating '5' Connection Object");
	   while(v.size()<5) {
		   try {
			Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
			   v.addElement(con);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	   }
	   
	   for (Object data :v) {
		   System.out.println(data);
	   }
	   System.out.println(v.size()+"Connection Object present in the Connection Pool");
   }
   
   Connection con_Acquisition() {
	   System.out.println("Assinging a Connection Object");
	   Connection con = v.elementAt(0);
	   v.remove(con);
	   return con;
   }
   
   void con_Return(Connection obj) {
	   
	   System.out.println("Adding the Connection Object back into the Connection Poool");
	   v.addElement(obj);
	   System.out.println("----------------");
	   for(Object data : v) {
		   System.out.println(data);
	   }
	   
   }
	
	
}
