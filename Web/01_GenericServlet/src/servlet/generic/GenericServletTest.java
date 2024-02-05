package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class GenericServletTest extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		// 요청을 받았다 치고
		// 바로 응답! 클라이언트 브라우저로 응답
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>"); // html 코드로 한 줄씩 읽을 수 있도록 보냄
		out.println("Hello, GenericTest~!!!!!!");
		out.println("</h1></body></html>");
	
		out.close(); // 자원 반납
	}
	

}
