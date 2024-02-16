package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// Extends : 클래스끼리 상속할 때
public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 비즈니스 로직

		// 1. 폼값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.registerMember(member);

		return new ModelAndView("index.jsp", true);
	}

}
