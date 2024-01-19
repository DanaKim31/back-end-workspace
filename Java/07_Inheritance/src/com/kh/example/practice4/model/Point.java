package com.kh.example.practice4.model;

public class Point {

	private int x;
	private int y;
	
	// 기본 생성자
	public Point() {}

	
	// 매개변수 있는 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}


	// getter, setter
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	// toString
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	
}
