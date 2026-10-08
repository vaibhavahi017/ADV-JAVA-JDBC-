package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcApp14 {
	private String driver ="oracle.jdbc.OracleDriver";
	private String dburl ="jdbc:oracle:thin:@localhost:1521:ORCL";
	private String dbuname = "VAIBHAV09";
    private String dbpwd = "VAIBHAV09";
    
    String sqlQuery ="select EFNAME , ELNAME from EMPLOYEE01 where EID = ?";
    
    void meth1() {
    	
    			System.out.println("Getting Metadata About your Database");
    		try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
				PreparedStatement pstmt=	con.prepareStatement(sqlQuery);
				pstmt.setString(1, "101");
				ResultSet rs =	pstmt.executeQuery();
				
				DatabaseMetaData dmtdt = con.getMetaData();
				System.out.println("\n--------DataBase MetaData------------");
				System.out.println("Database name :"+dmtdt.getDatabaseProductName());
				System.out.println("Databasse Version :"+dmtdt.getDatabaseProductVersion());
				System.out.println("Databasse Driver is :"+dmtdt.getDriverName());
				System.out.println("SupportStoreprocedure :"+dmtdt.supportsStoredProcedures());
				
				System.out.println();
				
				System.out.println("-----------ParameterMetadata-----------");
				ParameterMetaData pmtdt =pstmt.getParameterMetaData();
				System.out.println("No of Parameter :"+pmtdt.getParameterCount());
				System.out.println("Parameter type :"+pmtdt.getParameterType(1));
				System.out.println("Parameter Mode :"+pmtdt.getParameterMode(1));
				System.out.println("is it nullable :"+pmtdt.isNullable(1));
				
				
				System.out.println();
				System.out.println("---------ResultSet MetaData------------");
				
				ResultSetMetaData rstmt = rs.getMetaData();
				System.out.println("no of Column :"+rstmt.getColumnCount());
				System.out.println("Name of Column :"+rstmt.getColumnName(2));
				System.out.println("Size of thee column :"+rstmt.getColumnDisplaySize(2));
				System.out.println("is is AutoIncrement :"+rstmt.isAutoIncrement(2));
				
				System.out.println("-----RowSetMetadata------");

				RowSetMetaData rm = (RowSetMetaData) rs.getMetaData();
				System.out.println("No of Column :"+rm.getColumnCount());
				System.out.println("Column Name :"+rm.getColumnName(2) );
				System.out.println("Column type :"+rm.getColumnType(2));
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public static void main(String[] args) {
		JdbcApp14 obj = new JdbcApp14();
		obj.meth1();
	}
	
}
