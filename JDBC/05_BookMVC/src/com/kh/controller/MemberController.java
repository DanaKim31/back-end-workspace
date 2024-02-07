// 코드를 찾기 쉽도록 컨트롤러도 기능별로 구분해서 관리
package com.kh.controller;

import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberController {

	private MemberDAO dao = new MemberDAO();
	
	// 기능 메서드

	// 4. 회원가입
	public boolean registerMember(String id, String password, String name) {
		try {
			if(dao.registerMember(id, password, name)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	// 5. 로그인
	public Member login(String id, String password) {
		Member member;
		try {
			member = dao.login(id, password);
			if (member.getStatus().equals("Y")) return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	// 5. 회원 탈퇴
	public boolean deleteMember(int no) {
		try {
			if(dao.deleteMember(no)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
