package jdbc;

import java.sql.Connection;

//connection pool
public class ConnectionPool {
	 String dburl="jdbc:oracle:thin:@localhost:1521:ORCL";
     String dbuname = "VAIBHAV09";
     String dbpwd = "VAIBHAV09";
     
     JdbcApp13 obj = new JdbcApp13(dburl, dbuname, dbpwd);
     
     void meth1() {
    	 System.out.println("Implementing Connection Pooling");
    	 
    	 obj.con_initialization();
    	 System.out.println("Size of Vector :"+obj.v.size());
    	 
    	 System.out.println("\n-----------User1-------------");
    	 Connection con1 = obj.con_Acquisition();
    	 System.out.println("Size of vector :"+obj.v.size());
    	 
    	 System.out.println("\n-----------User2-------------");
    	 Connection con2 = obj.con_Acquisition();
    	 System.out.println("Size of vector :"+obj.v.size());
    	 
    	 
    	 System.out.println("\n-----------User3-------------");
    	 Connection con3 = obj.con_Acquisition();
    	 System.out.println("Size of vector :"+obj.v.size());
    	 
    	 
    	 obj.con_Return(con1);

//    	 obj.con_Return(con2);

//    	 obj.con_Return(con3);

    	 
     }
     public static void main(String[] args) {
		new ConnectionPool().meth1();
	}

}
