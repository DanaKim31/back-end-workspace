package servlet.life;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LifecycleServlet() {
       System.out.println("LifecycleServlet 생성자 호출..");
    }

	
    // 클라이언트에서 호출 했을 때만 호출(생성자와 함께)
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출..");
	}
	

	// 서버가 꺼지면 호출
	public void destroy() {
		System.out.println("destroy 호출..");
	}

	
	// service : doGet + doPost
	// 1. service에 구현
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출..");
	}

	
	// get 방식
	// 2. doGet에 구현 (service 없어야 함)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출..");
	}

	
	// post 방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출..");
		doGet(request, response);
	}

}
