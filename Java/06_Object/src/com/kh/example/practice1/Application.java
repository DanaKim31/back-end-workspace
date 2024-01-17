// 화면 단
package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {

		Member m = new Member(); // -> 작성 후 호버 -> import
		
		m.changeName("김다은");
		m.printName();
	}
}
