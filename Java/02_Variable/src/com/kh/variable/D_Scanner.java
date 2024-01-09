package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner (Java에서 대문자로 시작하는 것 : 클래스)
	 * - 화면(Console)으로부터 데이터를 "입력"받는 클래스
	 * 
	 * 1. import java.util.Scanne; 추가
	 * 
	 * 2. Scanner 객체 생성
	 * 	  Scanner sc = new Scanner(System.in);
	 * 
	 * 3. Scanner 매서드 사용
	 * 	  - 입력값이 문자열 일 때 : sc.next() 또는 sc.nextLine()  -->  sc.nextLine()만 사용하는 것 권장 
	 * 						   sc.next() : 공백이 있을 경우 공백 이 전까지
	 * 						   sc.nextLine() : 공백 포함 엔터 전까지
	 * 	  - 입력값이 정수 일 때 : sc.nextInt()
	 *    - 입력값이 실수 일 때 : sc.nextFloat() 또는 sc.nextDouble()
	 * */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next(); // enter 처리하지 않음
		sc.nextLine(); // enter 처리
		
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine(); // sc.nextLine이 enter 처리 함
		
		System.out.print("당신의 나이는 몇살입니까? > ");
		int age = sc.nextInt(); // enter 처리하지 않음, but 다음 내용(height)에서도 enter 처리 하지 않기 때문에 넘어감. 
//								   (enter는 nextLine을 만날 때 까지 처리하지 않음)
		
		System.out.print("당신의 키는 몇입니까? (소수점 첫째 자리까지 입력하세요.) > ");
		double height = sc.nextDouble(); // enter 처리하지 않음
		sc.nextLine(); // enter 처리
//		변수의 데이터 타입 : 'sc.nextd'만 입력 시 도움말 팝업으로 출력되는 데이터타입 나옴
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
		String input = sc.nextLine();
		char gender = input.charAt(0); // 한 글자만 받기
		
//		System.out.println("당신의 이름은 " + name + "이고 사는 곳은 " + addr + ", 나이는 " 
//							+ age + "살, 키는 " + height + "cm, 성별은 " + gender + " 입니다.");
		// --> printf 변경
		System.out.printf("당신의 이름은 %s이고 사는 곳은 %s, 나이는 %d살, 키는 %.1fcm, 성별은 %c입니다.", name, addr, age, height, gender);
	}

}




















