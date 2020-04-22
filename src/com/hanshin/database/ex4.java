package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ex4 {
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			String sql;
			sql = "select * from databasetest.addressbook";
			Statement st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				System.out.printf("id:  %d, userName: %s, birth: %s, dept: %s, email: %s"
						+ "\n", id, name, tel, email, address);
			}
			System.out.println("---------------------------------\n\n");
			
//			sql = "delete from addressbook where id = 4";
//			st.execute(sql);
//			
//			sql = "delete from addressbook where id = 5";
//			st.execute(sql);
//			
//			sql = "select * from databasetest.addressbook";
//			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				System.out.printf("id:  %d, userName: %s, birth: %s, dept: %s, email: %s"
					 	+ "\n", id, name, tel, email, address);
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
