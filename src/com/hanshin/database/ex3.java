package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ex3 {
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			
			String sql;
			sql = "update addressbook set email=? where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "asdasd@naver.com");
			st.setInt(2, 1);
			st.executeUpdate();
			
			st.setString(1, "popiywy@naver.com");
			st.setInt(2, 1);
			st.executeUpdate();
			
			st.setString(1, "hdfjasfas@naver.com");
			st.setInt(2, 1);
			st.executeUpdate();
			
			st.setString(1, "lkjjgd@naver.com");
			st.setInt(2, 1);
			st.executeUpdate();
			
			st.setString(1, "qwefcasdw@naver.com");
			st.setInt(2, 1);
			st.executeUpdate();
			
			sql = "select * from databasetest.addressbook";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				System.out.printf("id:  %d, userName: %s, birth: %s, dept: %s, email: %s"
						+ "\n", id, name, tel, email, address);
			}


			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

//3) 2)번 코드 이후 PreparedStatement 이용하여 5개의 열의 email의 도메인을 @naver.com으로
//UPDATE 수행- addressbook의 모든 데이터를 Statement를 이용해서 
//조회하여 eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현