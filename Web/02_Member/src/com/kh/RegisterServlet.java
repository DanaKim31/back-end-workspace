package com.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	private String age;
	private String addr;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.html에서 /register로 요청을 하여
		// 요청받은 이름, 나이, 주소를 받아서
		// result.jsp 파일로 해당 정보 출력
		// <a href='result.jsp'>결과 확인</a>  <-- 이 링크 눌렀을 때
		// 해당 result.jsp 페이지에서
		// '주소'에 사는 '나이'세인 '이름' 가입 완료!  <-- h1 태그 사용
		
//		// 인코딩! >> EncodingFilter, xml에 정리
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		// 요청받은 이름, 나이, 주소를 받아서
		name = request.getParameter("name");
		age = request.getParameter("age");
		addr = request.getParameter("addr");
		
		PrintWriter pw = response.getWriter();
//		pw.println("<h1>이름 : " + name + "</h1>");
//		pw.println("<h1>나이 : " + age + "</h1>");
//		pw.println("<h1>주소 : " + addr + "</h1>");
		pw.println("<a href='result.jsp?addr=" + addr + "&age=" + age + "&name=" + name + "'>결과 확인</a>");
	}

}
