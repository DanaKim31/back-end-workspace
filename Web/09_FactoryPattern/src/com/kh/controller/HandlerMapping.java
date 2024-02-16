package com.kh.controller;

import com.kh.controller.component.AllMemberController;
import com.kh.controller.component.FindMemberController;
import com.kh.controller.component.LoginController;
import com.kh.controller.component.LogoutController;
import com.kh.controller.component.RegisterController;

//Controller의 공장 역할
public class HandlerMapping {
	// 싱글톤 패턴 (생성자 생성 방지를 위해 private 사용)
	//	- 특정 클래스의 객체가 오직 한 개만 존재하도록 하기 위해서
	// 객체 생성은 본인 자신만 가능하므로 private static으로 객체 생성
	// 바깥에서는 getInstance 메서드로 호출
	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping() {
		
	}
	
	// 바깥에서는 getInstance 메서드로 호출
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	// controller 생성!
	public Controller createController(String command) { // command(주문서) 보냄
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("search.do")) {
			controller = new FindMemberController();
		} else if(command.equals("allShow.do")) {
			controller = new AllMemberController();
		} else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}
		
		
		
		return controller;
	}
	
}
