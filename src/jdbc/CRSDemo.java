package jdbc;


import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;


public class CRSDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		
		CachedRowSet crs = new OracleCachedRowSet();//only driver loaded
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		crs.setUsername("VAIBHAV09");
		crs.setPassword("VAIBHAV09");
		crs.setCommand("select * from student");
		crs.execute();
		while(crs.next()) {
			System.out.print(crs.getInt("id")+"\t");
			System.out.print(crs.getString("name")+"\t");
			System.out.println(crs.getInt("marks"));
			
		}
		
		} catch (Exception e) {
			// TODO: haneedle exception
			e.printStackTrace();
		}

	}

}
