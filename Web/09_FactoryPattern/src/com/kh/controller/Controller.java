package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공장 기계 역할(틀)
// interface : 다른 클래스를 상속하면 반드시 상속받은 클래스 역할을 함 
//	- 변수는 상수만, 메서드는 추상메서드만
public interface Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
