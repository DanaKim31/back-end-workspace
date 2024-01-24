package com.kh.list.model;

public class Person {

	private String name;
	private String addr;
	private int age;

	
	// 생성자 생성(A_ArrayList 클래스에서 name, addr, age 변수에 접근하기 위해 생성)
	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	}

	
	// A_ArrayList 클래스에서 결과값 출력 시 한글로 출력하기 위해 Person 클래스에 toString 추가
	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
	
	
}
