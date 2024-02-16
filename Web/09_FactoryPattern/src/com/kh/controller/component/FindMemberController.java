package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class FindMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼값 받는다.
		String id = request.getParameter("id");

		// 2. DAO
		// 세션 받아오기
		MemberDAO dao = new MemberDAO();
		Member member = dao.findMember(id);

		if (member != null) {
			// 3. 바인딩
			request.setAttribute("member", member);
			// forward 방식
			return new ModelAndView("views/find_ok.jsp");
		} else {
			// redirect 방식(true)
			return new ModelAndView("views/find_fail.jsp", true);
		}

	}

}
