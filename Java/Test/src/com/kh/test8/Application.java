package com.kh.test8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Application {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			System.out.println("DB연결");
			
			String query = "SELECT emp_id, emp_name FROM employee WHERE dept_code=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			ResultSet rs = ps.executeQuery();
			
			rs.getString("emp_id");
			rs.getString("emp_name");
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
