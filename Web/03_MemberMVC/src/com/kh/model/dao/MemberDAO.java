package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	// 1. 드라이버 로딩
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading...!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. DB 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}
	
	// 자원 반납
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps, conn);
	}

	
	// 기능 메서드
	// 회원가입
	public int registerMember(Member vo) throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		
		int result = ps.executeUpdate();
		close(ps, conn);
		
		return result;
	}

}
