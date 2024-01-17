// DB랑 연결되는 부분
package com.kh.example.practice1.model;

public class Member {

	// 변수
	public String memberId;
	public String memberPwd;
	public String memberName;
	public int age;
	public char gender;
	public String phone;
	public String email;
	
	// 메서드 (void 리턴타입)
	public void changeName(String name) {
		memberName = name;
	}
	
	public void printName() {
		System.out.println(memberName);
	}

}
