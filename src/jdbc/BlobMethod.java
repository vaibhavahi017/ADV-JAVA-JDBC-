package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","VAIBHAV09","VAIBHAV09");
			PreparedStatement psmt = con.prepareStatement("insert into images values(?,?)");
			psmt.setString(1, args[0]);
			FileInputStream fis = new FileInputStream(args[1]);
			psmt.setBinaryStream(2,fis,fis.available() );
			
			psmt.executeUpdate();
			System.out.println("one image insert succesfully");
			

			
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}


	}

}
