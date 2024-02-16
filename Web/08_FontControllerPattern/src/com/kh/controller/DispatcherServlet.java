package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// service에서 모든 작업
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// register, login, allmember servlet 전부 여기서 만남!

		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp"; // if문 내 path가 제대로 실행되지 않더라도 main으로 넘어갈 수 있도록 index.jsp 지정

		try {
			if (command.equals("register")) { // RegisterServlet
				path = register(request, response); // index.jsp (register 메서드의 return 값)
			} else if (command.equals("login")) { // LoginServlet
				path = login(request, response);
			} else if (command.equals("search")) { // FindMemberServlet
				path = search(request, response);
			} else if (command.equals("allShow")) { // AllMemberServlet
				path = allShow(request, response);
			} else if (command.equals("logout")) { // LogoutServlet
				path = logout(request, response);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);

	}

	
	// Register
	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.registerMember(member);

		return "index.jsp";
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
