package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, password);

		// 3.바인딩(현재 페이지를 벗어나서 다른 페이지에 접근하기 위해) - session
		// request - forward 방식. 요청을 보낸 값(정보)을 다른 페이지에 전송 할 때만 보관(다음 페이지에서만 해당 정보 사용 가능)
		// sesseion - 요청 보낸 정보를 세션이 끝날 때까지 보관(서버가 죽을 때까지 보관)
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		// Redirect 방식 : true
		return new ModelAndView("views/login_result.jsp", true);
	}

}
