package jdbc;
//java bean Rowset example
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JRSDemo {

	public static void main(String[] args) throws SQLException {
		JdbcRowSet jrs  = new OracleJDBCRowSet();//only driver loaded
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		jrs.setUsername("VAIBHAV09");
		jrs.setPassword("VAIBHAV09");
		jrs.setCommand("select * from student");
		jrs.execute();
		while(jrs.next()) {
			System.out.print(jrs.getInt("id")+"\t");
			System.out.print(jrs.getString("name")+"\t");
			System.out.println(jrs.getInt("marks"));
			
		}
	}

}
