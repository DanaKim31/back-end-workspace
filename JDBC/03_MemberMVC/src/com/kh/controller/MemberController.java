package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {

	// 1. 드라이버 로딩 - 생성자에 구현 
	public MemberController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// 2. 디비 연결
	public Connection getConnect( ) throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}
	
	
	// 자원 반납 메서드
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps, conn);
	}
	
	// 기능 메서드
	
	// 회원가입 기능 구현! -> member 테이블에 데이터 추가(INSERT)
	// 로그인 기능 구현이 먼저 되어야 함! -> 로그인 결과값이 null이 아닌 경우만 구현! 아닐 때는 false만 리턴@!
	public boolean signUp(Member m) throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문 (PreparedStatement)
		if(!idCheck(m.getId())) {
			String query = "INSERT INTO member VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 쿼리문 실행
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			
			ps.executeUpdate();
			close(ps,conn);
			
			return true;
		}
		return false;
	}
	
	
	// 아이디가 기존에 있는지 여부 체크!
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문
		String query = "SELECT id FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 쿼리문 실행
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery(); // SELECT만 executeQuery, executeQuery의 리턴 값 ResultSet
		String checkId = null;
		
		if(rs.next()) {checkId = rs.getString("id");}
		close(rs, ps, conn);
		
		if(checkId != null) return true;
		return false;
	}
	
	
	// 로그인 기능 구현! -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기(SELECT)
	public String login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT name FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		String name = null;
		if(rs.next()) name = rs.getString("name");
		close(rs, ps, conn);
		
		return name;
	}
	
	
	// 비밀번호 바꾸기 기능 구현!(login메서드 활용) -> member 테이블에서 id와 password로 새로운 패스워드 변경(UPDATE)
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		Connection conn = getConnect();
		
		PreparedStatement ps = null;
		boolean result = false;
		// 사용자 이름이 null이 아닐 때 UPDATE문 구현
		if(login(id, oldPw) != null) {
			String query = "UPDATE member SET password=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPw);
			ps.setString(2, id);
			ps.executeUpdate();
			result = true;
		}
		close(ps, conn);
		return result;
	}
	
	
	// 이름 바꾸기 기능 구현! -> member 테이블에서 id로 새로운 이름 변경(UPDATE)
	public void changeName(String id, String changeName) throws SQLException {
		Connection conn = getConnect();
		
		String query = "UPDATE member SET name=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, changeName);
		ps.setString(2, id);
		ps.executeUpdate();
		
		close(ps, conn);
	}

}
