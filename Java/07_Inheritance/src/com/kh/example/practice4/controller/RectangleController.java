package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();
	

	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
//		int a = width * height;
		
		return r.toString() + "넓이 : " + (width * height);
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
//		int p = 2 * (width + height);
		
		return r.toString() + "둘레 : " + (2 * (width + height));
	}
}
