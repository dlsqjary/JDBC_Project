package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.PUBLIC_MEMBER;

public class project1 {
	public static void main(String[] args) {

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			
			//1번 테이블 만들기
			/*
			Statement st = con.createStatement();
			String sql = "create table addressbook11(id int(10) Primary key, name varchar(45), tel varchar(45), email varchar(60), address varchar(60))";
			st.executeUpdate(sql);
			st.execute(sql);
			sql = "select * from addressbook";
			ResultSet rs = st.executeQuery(sql);
			rs.next();

			rs.close();
			st.close();
			con.close();	
			*/	
			
			//2번 
			/*
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
			*/
			
			//3번
			/*
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
			*/
			
			//4번 (테이블에 있는 데이터 갯수에 상관없이 하위 2개 행을 제거하고 싶었으나  Statement를 사용해서 무슨 방법으로 해야할지 방법이 떠오르지 않아서 패스)
			/*
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
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결/ 입력 안됨");
		} 
	}
}
