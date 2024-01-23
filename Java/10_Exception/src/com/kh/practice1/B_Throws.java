package com.kh.practice1;

import java.io.IOException;

public class B_Throws {

	/*
	 * 예외클래스 여러 개 올 수 있음 
	 * 리턴타입 메서드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
	 * 
	 * }
	 * 
	 * - main method에서도 throws 키워드로 예외를 떠넘길 수 있지만 결국 JVM이 예외 처리를 하게 된다. --> 비추천
	 * 	 => 프로그램 사용자는 프로그램이 알 수 없는 예외 내용을 출력하고 좋료되는 것을 좋아하지 않는다.
	 * - 따라서 main method에서 try ~ catch 블록으로 예외를 최종 처리하는 것이 바람직
	 * 
	 * */
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		B_Throws b = new B_Throws();
		// main에서는 throw X
		try {
			b.method1();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("예외가 발생했습니다!");
		}
	}

	public static void findClass() throws ClassNotFoundException { //throws + 에러명, 호출한 곳(main)으로 에러를 넘김
		Class cla = Class.forName("java.lang.String2"); 
		// Class.forName() : 클래스 찾기 
		// try-catch 할 경우 : String2라는 클래스가 없기 때문에 에러 발생 -> 에러는 main method로 넘겼음 -> main method에서 에러는 "클래스가~"로 출력 처리
		// throw declaration 할 경우 findClass() 뒤에 throw 발생 -> 이 경우엔 윗줄 findClass();에서 에러가 발생
	}
	
	public void method1() throws ClassNotFoundException, IOException {
		System.out.println("method1() 호출");
		
		method2();
		
		System.out.println("method1() 종료");
	}
	
	public void method2() throws ClassNotFoundException, IOException {
		System.out.println("method2() 호출");	
		
		method3();
		
		System.out.println("method2() 종료");	
		}
	
	public void method3() throws ClassNotFoundException, IOException {
		System.out.println("method3() 호출");
		
		int random = (int) (Math.random() * 2 + 1);
		
		if(random == 1) {
			throw new ClassNotFoundException();
		} else if(random == 2) {
			throw new IOException();
		}
		
		System.out.println("method3() 종료");
	}
}
