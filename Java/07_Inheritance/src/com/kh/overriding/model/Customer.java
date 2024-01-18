package com.kh.overriding.model;

public class Customer {

	protected String name; // 고객이름
	protected String grade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 포인트 적립 비율
	
	
	// 기본 생성자
	public Customer() {
		System.out.println("기본생성자로 만듦!");
	}


	// 매개변수 생성자
	public Customer(String name) {
		super(); 
		this.name = name;
		this.grade = "SILVER";
		// bonusPint는 0에서 시작하므로 따로 지정하지 않음
		this.bonusRatio = 0.01;
	}


	// getter, setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getBonusPoint() {
		return bonusPoint;
	}


	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}


	public double getBonusRatio() {
		return bonusRatio;
	}


	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}
	
	
	// Object는 모두 재정의(toString) 가능함
	@Override // <-- 어노테이션! '이 메서드는 재정의도니 메서드이다.' 라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		// obj를 Customer로 형변환 정의
		Customer c = (Customer) obj; // 다형성!
		return this.name == c.name;
	}
	
	public int calcPrice(int price) {
		this.bonusPoint += price * bonusRatio; // 보너스 포인트 계산!
		return price;
	}
	
	
}
