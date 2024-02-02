package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {

	// 1. 드라이버 로딩
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
	public void closeAll() {
		
	}
	
	
	// 기능 메서드
	
	// 회원가입 기능 구현! -> member 테이블에 데이터 추가(INSERT)
	// 로그인 기능 구현이 먼저 되어야 함! -> 로그인 결과값이 null이 아닌 경우만 구현! 아닐 때는 false만 리턴@!
	public boolean signUp(Member m) throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문 (PreparedStatement)
		String query = "INSERT INTO member VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 쿼리문 실행
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());
		
		int result = ps.executeUpdate();
		
		return false;
	}
	
	
	// 로그인 기능 구현! -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기(SELECT)
	public String login(String id, String password) {
		return null;
	}
	
	
	// 비밀번호 바꾸기 기능 구현!(login메서드 활용) -> member 테이블에서 id와 password로 새로운 패스워드 변경(UPDATE)
	public boolean changePassword(String id, String oldPw, String newPw) {
		return false;
	}
	
	
	// 이름 바꾸기 기능 구현! -> member 테이블에서 id로 새로운 이름 변경(UPDATE)
	public void changeName(String id, String changeName) {
		
	}
	
	
	
}
