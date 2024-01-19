package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
//		double a = 3.14 * radius * radius; 
		
		return c.toString() + "둘레 : " + (Math.PI * radius * 2);
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
//		double c = 3.14 * radius * 2;
		
		return c.toString() + "넓이 : " + (Math.PI * radius * 2);
	}
	
}
