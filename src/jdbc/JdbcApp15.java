package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Blob;

public class JdbcApp15 {
	private String driver = "oracle.jdbc.OracleDriver";
    private String DBurl = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private String DBuname = "VAIBHAV09";
    private String DBpwd = "VAIBHAV09";
    
    String sqlQuery1 = "insert into mydata values(?,?)";
    String sqlQuery2 = "select pic_data from mydata where id=?";
    String sqlQuery3 = "insert into mydata3 values(?,?)";
    
    public Connection connect() {
    	
    	Connection con = null;
    	
    		 try { 
    	            Class.forName(driver);

    	             con = DriverManager.getConnection(DBurl, DBuname, DBpwd);

    	           
    	        } catch (Exception e) {

    	            e.printStackTrace();

    	        }
    		 return con;
    }
	
    void meth1() {
    	 System.out.println("Passing  an Image into Database");
    	 try {
    		 Connection con = connect();
    		 PreparedStatement pstmt=con.prepareStatement(sqlQuery1);
    		 pstmt.setString(1, "101");
    		 
    		 FileInputStream fis=new FileInputStream("\"F:\\Vaibhav all photos\\whatsapp photo\\IMG-20230928-WA0019.jpg\"");
    		 pstmt.setBlob(2,fis,fis.available());
    		 
    		 int rowCount=pstmt.executeUpdate();
    		 if(rowCount==0)
    			 throw new RuntimeException("Image NOT inserted!!!");
    		 System.out.println("Image stored in the database");
    		 con.close();
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
    }
    
    void meth2()
    {
    	System.out.println("Reteriving the Image from the Databse");
    	try
    	{
    		Connection con=connect();
    		PreparedStatement pstmt=con.prepareStatement(sqlQuery2);
    		pstmt.setString(1,"101");
    		
    		ResultSet rs=pstmt.executeQuery();
    		if(rs.next())
    		{
    			Blob b=rs.getBlob(1);
    			byte arr[]=b.getBytes(1,(int)b.length());
    			FileOutputStream fos=new FileOutputStream("\"F:\\Vaibhav all photos\\whatsapp photo\\IMG-20230901-WA0004.jpg\"");
    			fos.write(arr);
    			System.out.println("Image Reterived!!!");
    			fos.close();
    		}
    	}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    }
    	
    	void meth3()
    	{
    		System.out.println("Reteriving the Image from the Databse");
        	try
        	{
        		Connection con=connect();
        		PreparedStatement pstmt=con.prepareStatement(sqlQuery3);
        		pstmt.setString(1, "101");
        		
        		FileReader fr=new FileReader("\"F:\\Mypdf\\admit cartMFS.pdf\"");
        		pstmt.setClob(2, fr);
        		int rowCount=pstmt.executeUpdate();
        		if (rowCount==0) {
        			throw new SQLException("File NOT inserted");
        		}
        		else
        		{
        			System.out.println("File Inserted");
    	}
        	}
        	catch(Exception e) 
        	{
        		e.printStackTrace();
        	}
    	}
    	
    public static void main(String[] args) {

        JdbcApp15 obj = new JdbcApp15();

         obj.meth1();  
       //obj.meth2();
         //  obj.meth3();
    }	    
}
