package com.kh.inheritance.child;

import com.kh.inheritance.parent.Product;

public class Tv extends Product {

	private int inch; // 인치

	
	// 생성자 추가
	public Tv() {}

	public Tv(String brand, String pCode, String name, int price, int inch) {
		super(brand, pCode, name, price);
		this.inch = inch;
	}

	
	// setter, getter 추가
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	
	// toString 추가
	@Override
	public String toString() {
		return super.toString() + ", Tv [inch=" + inch + "]";
	}

	
	
	
	

	
}
