package com.training.amdocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_connection {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl.iiht.tech";
		
		String userName = "scott";
		
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from acc_details1");
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+":"+rs.getString(2));
	}
		}
catch (Exception e) {
			
			e.printStackTrace();

}
	}
}
