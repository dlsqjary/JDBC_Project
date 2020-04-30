package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hanshin.database.AddressbookTable;
import com.mysql.cj.xdevapi.Result;


public class HomeWork_1 {

	public static int num;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";


		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			
			//테이블 생성
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

			show(st);	// 현재 테이블에 있는 데이터 출력
			System.out.println("-----------------------\n");
			System.out.println("입력할 갯수 입력");
			num = sc.nextInt();
			List<AddressbookTable>input = inputdata();

			for(int i = 0; i<num; i++) {
				insert_table(con, input.get(i));
			}
			List<AddressbookTable> row = show(st);	// 새로운 데이터 삽입 후 출력

			//			for(int i=0; i<row.size(); i++) {
			//				update(con, row.get(i));
			//			}
			//			List<AddressbookTable> row2 = show(st);	// 메일 주소 수정 후 출력

			
			System.out.println("삭제할 행의 갯수: ");
			int del_cnt = sc.nextInt();
			delete(con, del_cnt, row);
			try {
				List<AddressbookTable> row3 = show(st);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("출력 에러");
			}
		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}
	}

	public static List<AddressbookTable> show(Statement st) throws SQLException {
		String sql = "select * from addressbook";
		ResultSet rs = st.executeQuery(sql);
		List<AddressbookTable>data = new ArrayList<AddressbookTable>();
		int cnt = 0;
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			String email = rs.getString("email");
			String address = rs.getString("address");
			AddressbookTable adt  =new AddressbookTable(id, name, tel, email, address);

			System.out.printf("id:  %d, userName: %s, tel: %s, email: %s, address: %s "
					+ "\n", id, name, tel, email, address);
			data.add(adt);
			cnt++;
		}
		rs.close();
		return data;

	}

	public static List<AddressbookTable> inputdata() {
		List<AddressbookTable> data = new ArrayList<>();

		//System.out.println("입력할 데이터의 갯수 : ");
		//num = sc.nextInt();
		System.out.println("데이터를 입력하세요. id, name, tel, email, address 순");

		for(int i = 0; i<num; i++) {
			int id = sc.nextInt();
			String name = sc.next();
			String tel = sc.next();
			String email = sc.next();
			String address = sc.next();
			AddressbookTable adt = new AddressbookTable(id, name, tel, email, address);
			data.add(adt);
		}
		return data;
	}

	public static void insert_table(Connection con, AddressbookTable abt) throws SQLException{
		try {
			String sql = "insert into addressbook values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, abt.getId());
			ps.setString(2, abt.getName());
			ps.setString(3, abt.getTel());
			ps.setString(4, abt.getEmail());
			ps.setString(5, abt.getAddress());

			int cnt = ps.executeUpdate();

			if(cnt == 1) {
				System.out.println("insert OK");
			}else {
				System.out.println("insert ERROR");
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("테이블 입력 실패");
		}
//		String sql = "insert into addressbook values(?,?,?,?,?)";
//		PreparedStatement ps = con.prepareStatement(sql);
//
//		ps.setInt(1, abt.getId());
//		ps.setString(2, abt.getName());
//		ps.setString(3, abt.getTel());
//		ps.setString(4, abt.getEmail());
//		ps.setString(5, abt.getAddress());
//
//		int cnt = ps.executeUpdate();
//
//		if(cnt == 1) {
//			System.out.println("insert OK");
//		}else {
//			System.out.println("insert ERROR");
//		}
//		ps.close();
	}

	public static void update(Connection con, AddressbookTable abt) throws SQLException{
	
		try {
			String sql = "update addressbook set email=? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			String email = abt.getEmail();
			String[] tempemail = email.split("@");

			ps.setString(1, tempemail[0] + "@naver.com");
			ps.setInt(2, abt.getId());

			int cnt = ps.executeUpdate();
			if(cnt == 1 ) {
				System.out.println("Data Update OK");
			}else{
				System.out.println("Data Update Error");
			}
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Update Error");
		}
	}

	public static void delete(Connection con, int cnt, List<AddressbookTable> row) throws SQLException{
		int count = 0; int n;
		String sql = "select * from addressbook";

		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery(sql);
		try {
		

			while(true) {
				++count;
				if(count > cnt) {
					break;
				}
				rs.last();
				//rs.previous();
				rs.deleteRow();
				sql = "select * from addressbook";
				rs = st.executeQuery(sql);
			}

			//rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("삭제X");
		}
		rs.close();
	}
}














