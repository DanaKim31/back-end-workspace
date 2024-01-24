package com.kh.practice.model;

import java.util.Arrays;

// model class : 캡슐화! 
//	- 변수 : 접근제어자를 private으로 지정 (원칙)  ->  public으로 지정하면 다른 클래스에서도 접근 가능하기 때문에 private으로 캡술화
//  - private : 사용한 클래스 내(Member)에서만 사용 가능
public class Member {

	// 한 사람에 대한 정보를 담고 있는 변수들
	// 모든 method에서 공통으로 사용하기 위해 전역변수로 재지정
	private String name = "";
	private int age = 0; 
	private int coupon = 0; // 쿠폰 누적 카운트를 위해 while문 밖에 변수 선언
	private Book[] bookList = new Book[3]; // 대여한 책 모두 출력하기 위해 배열 생성  =>  포함관계
	
	
	// getter, setter 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	

	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
	
}
