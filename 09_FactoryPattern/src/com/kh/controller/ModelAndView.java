package com.kh.controller;

public class ModelAndView {
	// FrontController 사용 시에는 path만(forward 방식)
	// ModelAndView에서는 path와 isRedirect 함께(sendRedirect 방식)
	private String path;
	private boolean isRedirect;
	
	
	// 기본 생성자
	public ModelAndView() {
	}


	// path만 있는 생성자 : forward 방식!
	public ModelAndView(String path) {
		this.path = path;
	}


	// path, isRedirect 모두 있는 생성자 : sendRedirect 방식!
	// true 값 같이 넘겨서
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}


	// getter, setter
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isRedirect() {
		return isRedirect;
	}


	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}


	
}


