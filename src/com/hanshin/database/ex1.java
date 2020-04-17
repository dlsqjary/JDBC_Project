package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ex1 {
	public static void main(String[] args) {

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql = "create table addressbook11(id int(10) Primary key, name varchar(45), tel varchar(45), email varchar(60), address varchar(60))";
			//st.executeUpdate(sql);
			st.execute(sql);
			sql = "select * from addressbook";
			ResultSet rs = st.executeQuery(sql);

			rs.next();

			rs.close();
			st.close();
			con.close();		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결/ 입력 안됨");
		} 
	}
}

