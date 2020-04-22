package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ex2 {
	public static void main(String[] args) {
		
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			
			String sql;
			sql = "insert into databasetest.addressbook values(?,?,?,?,?)";
			//sql = "select * from addressbook";
			PreparedStatement st = con.prepareStatement(sql);
			

			st.setInt(1, 1);
			st.setString(2, "Hong");
			st.setString(3, "123456841");
			st.setString(4, "asdasd@naver.com");
			st.setString(5, "Seoul");
			st.executeUpdate();
			
			st.setInt(1, 2);
			st.setString(2, "In");
			st.setString(3, "4266485");
			st.setString(4, "hkisjsj@naver.com");
			st.setString(5, "Seoul");
			st.executeUpdate();
			
			st.setInt(1, 3);
			st.setString(2, "Lee");
			st.setString(3, "258499");
			st.setString(4, "oploiui@naver.com");
			st.setString(5, "Seoul");
			st.executeUpdate();
			
			st.setInt(1, 4);
			st.setString(2, "Park");
			st.setString(3, "5757843");
			st.setString(4, "mbmv@naver.com");
			st.setString(5, "Seoul");
			st.executeUpdate();
			
			st.setInt(1, 5);
			st.setString(2, "Kim");
			st.setString(3, "515188");
			st.setString(4, "jmgkergwe@naver.com");
			st.setString(5, "Seoul");
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
