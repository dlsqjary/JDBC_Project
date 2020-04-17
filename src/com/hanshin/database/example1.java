package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			//Statement st = con.createStatement();
			String sql = "insert into databasetest.member values(?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			
			//String sql = "insert into databasetest.member values(?,?,?,?,?,?)";
			//ResultSet r = st.executeQuery(sql);

//			rs.next();
//			@SuppressWarnings("unused")
//			String title = rs.getString("username");
//			System.out.printf("title: %s\n", title);
			
			st.setInt(1, 10);
			st.setString(2, "Hong");
			st.setString(3, "Computer");
			st.setString(4, "1999-01-01");
			st.setString(5, "asfasaa@gmail.com");
			st.setString(6, "1111-9999-9888");
			
			st.executeUpdate();

			//rs.close();
			st.close();
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
