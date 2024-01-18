package com.kh.inheritance.child;

import com.kh.inheritance.parent.Product;

/*
 * 상속
 * 
 * class 자식클래스 extends 부모클래스 {
 * }
 * 
 * * 상속의 장점
 * - 적은 양의 코드로 새로운 클래스 작성이 가능
 * - 코드를 공통적으로 관리하기 때문에 코드의 추가나 변경에 용이
 * - 코드의 중복을 제거하여 프로그램의 생산성과 유지 보수에 크게 기여
 * 
 * * 상속의 특징
 * - 클래스 간의 상속은 단일 상속만 가능
 * - 명시되지 않아도 모든 클래스는 Object 클래스 상속
 * 		-> Object 클래스의 매서드들을 오버라이딩하여 메서드 재정의 가능
 * - 부모 클래스의 생성자, 초기화 블록은 상속되지 않는다.
 * 		-> 자식 클래스 생성 시에 부모 클래스 생성자가 먼저 실행
 * - 부모의 private 변수는 상속은 되지만 직접 접근은 불가능
 * 		-> Getter / Setter 사용해서 간접 접근 가능
 * */


public class Notebook extends Product {
	
	private String cpu;

	public Notebook() {}

	public Notebook(String brand, String pCode, String name, int price, String cpu) {
		// super : 해당 객체의 부모(Product)의 객체 주소를 담고 있다.
		// 1. 부모 생성자 호출해서 초기화
		super(brand, pCode, name, price);
		this.cpu = cpu; // 부모 객체의 주소를 넘긴 후 남은 본인 것만 추가로 작성
		
		// 2. super.를 통해서 부모의 변수에 직접 접근
		//super.brand = brand; // 부모가 private - 직접 접근 불가능
		//super.pCode = pCode; // 부모가 default이나 다른 패키지(child - parent) - 접근 불가능, default : 같은 패키지에 있어야만 직접 접근 가능
		super.name = name; // 부모가 protected - 상속관계일 때 자식 객체에서 직접 접근 가능
		super.price = price; // 부모가 public - 어디서든 직접 접근 가능
		
		// 3. 부모의 setter 메서드를 호출해서 초기화
		// 		부모 클래스에서 setter 메서드를 제공하면, 자식클래스에서 부모의 setter 메서드를 통해 초기화 가능
		super.setBrand(brand);
		this.setpCode(pCode); // this : 부모 변수 호출 가능
		setName(name); // super 또는 this 생략해서도 호출 가능
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return super.toString() + ", Notebook [cpu=" + cpu + "]";
		// super.toString() : 부모의 toString 호출
	}
	
	
}
