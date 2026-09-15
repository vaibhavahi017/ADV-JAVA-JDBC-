package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class JdbcApp11 {
	
	 private String driver = "oracle.jdbc.OracleDriver";
	    private String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	    private String dbuname = "VAIBHAV09";
	    private String dbpwd = "VAIBHAV09";

	    String sqlQuery = "update trainseatavailability set available_seats = available_seats-1 where "
	                + "train_id=? and JOURNEY_DATA=? and class=? and available_seats > 0";

	  String sqlQuery2 = "insert into bookingdetails values(?,?,?,?,?)";
	  
	  String sqlQuery3 = "select  PAYMENT_STATUS  from CUSTOMERPAYMENT where CUSTOMER_ID=?";
	  
	  String sqlQuery4 = "update BOOKINGDETAILS set STATUS='SUCCESS' where  CUSTOMER_ID=?";
	  
	  

	    public Connection connect(){
	        Connection con = null;
	        try{
	            Class.forName(driver);
	            con = DriverManager.getConnection(dburl,dbuname,dbpwd);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
	    void meth1(){
	        System.out.println("Implementing the Transaction Management");
	        try{
	            Connection con = connect();
	            System.out.println("getAutoCommit(): "+con.getAutoCommit());

	            con.setAutoCommit(false);

	            System.out.println("getAutoCommit(): "+con.getAutoCommit());

	            PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);
	            pstmt1.setString(1,"12345");
	            pstmt1.setString(2,"2024-10-10");
	            pstmt1.setString(3,"SLEEPER");

	            int rowCount1 = pstmt1.executeUpdate();
	            if (rowCount1 == 0){
	                throw new RuntimeException("Seats are not available");
	            }else{
	                System.out.println("Seat is Locked");
	                
	                
	                Savepoint sp = con.setSavepoint();

	                PreparedStatement pstmt2 = con.prepareStatement(sqlQuery2);
	                pstmt2.setString(1,"B101");
	                pstmt2.setString(2,"12345");
	                pstmt2.setString(3,"123");
	                pstmt2.setInt(4,10);
	                pstmt2.setString(5,"Payment Pending");

	                int rowCount2 = pstmt2.executeUpdate();
	                if(rowCount2 == 0){
	                    throw new RuntimeException("Illegal Argument!!!");
	                }else{
	                    System.out.println("Booking record created");
	                    System.out.println("Waiting for payment confirmation");
	                 // con.commit();
	                    
	                    
	                   PreparedStatement pstmt3= con.prepareStatement(sqlQuery3);
	                   pstmt3.setString(1, "C123");
	                   ResultSet rs =   pstmt3.executeQuery();
	                   
	                   if(rs.next()) {
	                	   
	                   
	                   if(rs.getString(1).equals("SUCCESS"))
	                   {
	                	   PreparedStatement pstmt4 = con.prepareStatement(sqlQuery4);
	                	   pstmt4.setString(1, "123");
	                	   
	                	   int rowCount3 =  pstmt4.executeUpdate();
	                	   
	                	   if(rowCount3 == 0) {
	                		   throw new RuntimeException("Transaction Failed ....");
	                	   }else {
	                		   System.out.println("Transaction Success..");
//	                		   con.releaseSavepoint(sp);
	                		   con.commit();
	                	   }
	                   }
 
	                 
	                }
	                }
	            }
 // con.commit();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    public static void main(String[] args) {
	        JdbcApp11 obj = new JdbcApp11();
	        obj.meth1();
	    }
}
