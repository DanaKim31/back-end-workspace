package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("*.do") // .do로 끝나는 주소의 요청을 여기로 보냄
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// service에서 모든 작업
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// register, login, allmember servlet 전부 여기서 만남!

		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		String command = requestURIList[requestURIList.length - 1]; // command: 주문(요청)을 받음
		
	}

	
	// Login
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, password);

		// 3.session의 바인딩
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return "views/login_result.jsp";
	}

	
	// FindMember
	protected String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");

		// 2. DAO
		// 세션 받아오기
		MemberDAO dao = new MemberDAO();
		Member member = dao.findMember(id);

		if(member != null) {
			// 3. 바인딩
			request.setAttribute("member", member);
			
			return "views/find_ok.jsp";
		} else {
			return "views/find_fail.jsp";
		}
		
		// 위 if문을 삼항 연산자로 정리
//		if(member != null) request.setAttribute("member", member);
//		return member != null ? "views/find_ok.jsp" : "views/find_fail.jsp";
	}


	// AllMember
	protected String allShow(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = new ArrayList<>();

		list = dao.allShowMember();
		System.out.println(list.size());

		// 3. 바인딩(list 뿌리는 기능)
		request.setAttribute("list", list);

		return "views/allShow.jsp";
	}
	
	
	// Logout
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 3. session 죽이기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		if (member != null) {
			// 세션 죽이기
			session.invalidate();
			System.out.println("로그아웃!");
		}

		return "index.jsp";
	}
}
