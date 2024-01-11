package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 * 
	 * switch(조건식) {
	 * 		case 값1 : 
	 * 			조건식의 결과가 값1과 같은 경우 실행
	 * 			break;
	 * 		case 값2 : 
	 * 			조건식의 결과가 값2와 같은 경우 실행
	 * 			break;
	 * 		default : 
	 * 			조건식의 결과가 일치하는 case문이 없는 경우 실행
	 * }
	 * 
	 * - case 문의 수는 제한이 없다
	 * - 조건식 결과는 정수, 문자, 문자열이어야 한다
	 * - 조건문을 빠져나가려면 break가 필요하다
	 * - default문은 생략 가능하다
	 * */
	
	public void method1() {
		/*
		 * 숫자를 입력받아
		 * 1일 경우 "빨간색입니다"
		 * 2일 경우 "파란색입니다"
		 * 3일 경우 "초록색입니다"
		 * 잘못입력했을 경우 "잘못입력했습니다"
		 * */
		System.out.print("숫자 입력(1 ~ 3) > ");
		int number = sc.nextInt();
		String result = "";
		
		/* if문
		if(number == 1) System.out.println("빨간색입니다");
		if(number == 2) System.out.println("파란색입니다");
		if(number == 3) System.out.println("초록색입니다");
		else System.out.println("잘못입력했습니다"); */
		
		
		switch(number) {
			case 1 : result = "빨간색입니다";
			break;
			case 2 : result = "파란색입니다";
			break;
			case 3 : result = "초록색입니다";
			break;
			default : result = "잘못입력했습니다";
		}
		
		System.out.println(result);
	}

	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력
	 * 주민번호 입력 > 100000-3000000 
	 * */
	public void practice1() {
		System.out.print("주민번호 입력 > ");
//		String input = sc.nextLine();
		char number = sc.nextLine().charAt(7);
		
		String result = "";
		
		// number라는 '문자'를 '문자열'로 바꾸고 : String.valueOf(); 
		// 바꾼 '문자열'을 '숫자열'로 변환 : Integer.parseInt();
		switch(Integer.parseInt(String.valueOf(number))) {
			case 1 : 
			case 3 : result = "남자";
			break;
			case 2 :
			case 4 : result = "여자";
			break;
			default : System.out.println("잘못입력"); 
		}
		System.out.println(result);
	}

	
	
	/*
	 * 등급별 권한
	 * 1 : 관리권한, 글쓰기권한, 읽기권한
	 * 2 : 글쓰기권한, 읽기권한
	 * 3 : 읽기권한
	 * 등급 입력 > 1
	 * 관리권한
	 * 글쓰기권한
	 * 읽기권한
	 * */
	public void practice2() {
		System.out.print("등급 입력 > ");
		int grade = sc.nextInt();
		
		switch(grade) {
			case 1 : System.out.println("관리권환");
			case 2 : System.out.println("글쓰기권환");
			case 3 : System.out.println("읽기권환");
		}
	}
	
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
//		b.practice1();
		b.practice2();
	}

}
