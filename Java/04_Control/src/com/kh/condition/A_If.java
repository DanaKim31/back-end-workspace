package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * if문
	 * 
	 * if(조건식){
	 *    조건식이 참(true) 일 때 실행
	 * }
	 * 
	 * - 보통 조건식에서는 비교연산자, 논리연산자를 주로 샤용
	 * */

	public void method1() {
		
		// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
		
		System.out.print("점수 입력 > ");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 60) { // 권장! 결과를 한 줄 이상으로 출력하고 싶을 때는 중괄호 포함해야만 가능
			System.out.println("합격입니다.");
			System.out.println("축하합니다.");
		}
		
		// 중괄호가 없는 다른 풀이방법 두가지
		// 비추천, 결과를 한 줄 이상 출력 시 첫 번째 결과만 if문에 포함 됨 -> 한 줄만 들어갔을 때는 유용!
		if(score >= 60) System.out.println("합격입니다."); 
		
		if(score >= 60)
			System.out.println("합격입니다."); 
			System.out.println("축하합니다.22");
	}
	
	/*
	 * if-else문
	 * 
	 * if(조건식) {
	 * 		조건식이 참(true)일 때 실행
	 * } else {
	 * 		조건식이 거짓(false)일 때 실행
	 * }
	 * */
	
	public void method2() {
		
		// 입력받은 성적이 60점 이상이면 "합격입니다", 아니면 "불합격입니다"를 출력
		
		System.out.print("점수 입력 > ");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 60) { 
			System.out.println("합격입니다.");
			System.out.println("축하합니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		
		// 삼항연산자로 풀이
		String result = score >= 60 ? "합격입니다!" : "불합격입니다!";
		System.out.println(result);
	}
	
	public void method3() {
		
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		
		System.out.print("이름을 입력해 주세요 > ");
		String name = sc.nextLine();
		
		System.out.println("name의 주소값 : " + System.identityHashCode(name));
		System.out.println("본인이름의 주소값 : " + System.identityHashCode("김다은"));
		System.out.println(name == "김다은"); // false
		// String -> 참조형 변수(클래스변수)는 주소값을 저장!
		// 그렇기 때문에 'name'에 주소값 설정 
		System.out.println(name.equals("김다은")); // true
		
		System.out.println("------------------");
		
		if(name.equals("김다은")) {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		}
	}
	
	
	public void method4() {
		
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력
		
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		
		// 삼항 연산자 풀이
		String result = num > 0 ? "양수" : num < 0 ? "음수" : "0이다";
		System.out.println(result);
		
		
		// if-else 풀이, if문은 중첩 가능!
		if(num > 0) {
			System.out.println("양수");
		} else {
			if(num < 0) {
				System.out.println("음수");
			} else {
				System.out.println("0이다");
			}
		}
		
	}
	
	/*
	 * if-else if-else문
	 * 
	 * if(조건식1) {
	 * 		조건식1이 참(true)일 때 실행
	 * } else if(조건식2) {
	 * 		조건식2가 참(true)일 때 실행
	 * } else {
	 * 		조건식1과 조건식2가 모두 거짓(false)일 때 실행
	 * } 
	 * 
	 * - else if 수는 제한이 없다
	 * */
	
	public void method5() {
		
		// if-else -> if-else if-else로 변경!
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		
		// 삼항 연산자 풀이
		String result = num > 0 ? "양수" : num < 0 ? "음수" : "0이다";
		
		
		// if-else 풀이, if문은 중첩 가능!
		if(num > 0) {
			System.out.println("양수");
		} else if(num < 0) {
				System.out.println("음수");
			} else {
				System.out.println("0이다");
			}
	}
	
	
	// 실습문제 -------------------------------------------------------------------------
	
	/*
	 * 사용자에게 점수(0~100)를 입력받아서 점수별로 등급을 출력
	 * - 90점 이상은 A 등급
	 * - 90점 미만 80점 이상은 B 등급
	 * - 80점 미만 70점 이상은 C 등급
	 * - 70점 미만 60점 이상은 D 등급
	 * - 60점 미만 F 등급
	 * */
	public void practice1() {
		System.out.print("점수 입력(0~100점) > ");
		int score = sc.nextInt();
		
		String grade = "";
		
		if(score >= 90) {
			grade = "A 등급";
		} else if(score >= 80) {
			grade = "B 등급";
		} else if(score >= 70) {
			grade = "C 등급";
		} else if(score >= 60) {
			grade = "D 등급";
		} else {
			grade = "F 등급";
		}
		
		System.out.println(grade);
	}
	
	
	
	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 > 3
	 * num2 입력 > 4
	 * num3 입력 > 6
	 * 4
	 * 6
	 * */
	public void practice2() {
		System.out.print("첫 번째 정수 입력 > ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 입력 > ");
		int num2 = sc.nextInt();
		
		System.out.print("세 번째 정수 입력 > ");
		int num3 = sc.nextInt();
		

		// if문 하나 사용, 중첩으로 풀이 -> 비추천
		// if ~ else if 사용, 중첩 없음 -> 비추천
		/* if(num1 % 2 == 0 && num2 %2 == 0 && num3 %2 == 0) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
		} else if(num1 % 2 == 0 && num2 %2 == 0 && num3 %2 != 0) {
			System.out.println(num1);
			System.out.println(num2);
		} else if(num1 % 2 == 0 && num2 %2 != 0 && num3 %2 == 0) {
			System.out.println(num1);
			System.out.println(num3);
		} else if(num1 % 2 == 0 && num2 %2 != 0 && num3 %2 != 0) {
			System.out.println(num1);
		} else if(num1 % 2 != 0 && num2 %2 == 0 && num3 %2 == 0) {
			System.out.println(num2);
			System.out.println(num3);
		} else if(num1 % 2 != 0 && num2 %2 == 0 && num3 %2 != 0) {
			System.out.println(num2);
		} else if(num1 % 2 != 0 && num2 %2 != 0 && num3 %2 == 0) {
			System.out.println(num3);
		} */
		
		if(num1 % 2 == 0) System.out.println(num1);
		if(num2 % 2 == 0) System.out.println(num2);
		if(num3 % 2 == 0) System.out.println(num3);
 	}
	
	
	
	/*
	 * 정수 1개를 입력했을 때 음(minus) / 양(plus) / 0(zero), 짝(even) / 홀(odd) 출력
	 * 
	 * 정수 입력 > -3
	 * minus
	 * odd
	 * */
	public void practice3() {
		System.out.print("정수 입력 > ");
		int num = sc.nextInt();
		String result1 = "";
		String result2 = "";
		
		if(num > 0) {
			result1 = "plus";
		} else if(num == 0) {
			result1 = "zero";
		} else {
			result1 = "minus";
		}
		
		if(num == 0) { // -> 0부터 처리해서 0 입력 시 result2 값 비노출
			result2 = "";
		}else if(num % 2 == 0) {
			result2 = "even";
		} else {
			result2 = "odd";
		}
		
		System.out.println(result1);
		System.out.println(result2);
	}
		
	public static void main(String[] args) {

		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.practice1();
//		a.practice2();
		a.practice3();
		
	}

}
