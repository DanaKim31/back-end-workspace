// DB에 여러개의 값을 편하게 넣기 위해 model 역할을 하는 클래스 생성 후 사용
//  - model : 임시 저장공간
// private 변수에 직접 접근을 못하기 때문에 
//  - 기본생성자 또는 setter = 입력 값을 넣는 것
//  - 하나하나의 값을 가져오는 기능 : getter
//  - private 변수 : 클래스 내에서만 접근/사용 가능
//  1) 객체생성 할 때 생성하는 기본 생성자 생성
//  2) 매개변수 있는 생성자 생성
//  3) 변수 호출 시 주소값으로 호출되기 때문에 toString 생성


package com.kh.example.practice2.model;

public class Snack {

	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	
	// 기본 생성자
	public Snack() {} 

	
	// 매개변수 있는 생성자
	public Snack(String kind, String name, String flavor, int numOf, int price) {
		super();
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}

	
	// 저장된 데이터를 불러오는 메소드(get)
	// 데이터를 변수에 저장하는 메소드(set)
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	
	// 데이터를 변수에 저장하는 메소드
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	// 담긴 데이터 정보를 리턴하는 메소드
	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}
	
	
	
	
	
}
