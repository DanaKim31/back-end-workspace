package com.kh.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member =  dao.login(id, password);
			// 3.session의  바인딩
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			// 4. 네비게이션
			response.sendRedirect("view/login_result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}