package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcApp12 {
	
	private String driver="oracle.jdbc.OracleDriver";
	
	private String dburl="jdbc:oracle:thin:@localhost:1521:ORCL";
	
	private String dbuname ="VAIBHAV09";
	
	private String dbpwd ="VAIBHAV09";
	
	Scanner sc = new Scanner(System.in);
	
	String sqlQuery1 ="select  AVAILABLE_SEATS from MOVIESEATAVAILABILITY where MOVIE_ID =?";
	
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
	
	void bookTicket(String MOVIE_ID , String CUSTOMER_ID,int SEAT_NUMBER) {
		System.out.println("check the seats are avilable are not");
		
		try {
			Connection con = connect();
			System.out.println("getAutoCommit(): "+con.getAutoCommit());

            con.setAutoCommit(false);

            System.out.println("getAutoCommit(): "+con.getAutoCommit());

            PreparedStatement pstmt1 = con.prepareStatement(sqlQuery1);
            System.out.println("Enter movie_id :");
            String  mid =( sc.nextLine());
            
            pstmt1.setString(1, mid);
           int rowCount1 =  pstmt1.executeUpdate();
           if(rowCount1 ==0 ) {
        	   throw new RuntimeException("Seat are not available");
           }else {
        	   System.out.println("Seats Are available");
           }

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		JdbcApp12 j12 = new JdbcApp12();
		j12.bookTicket("M001", "C123", 14);
	}
		
	
	
	

}
