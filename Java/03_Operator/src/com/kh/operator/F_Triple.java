package com.kh.operator;

import java.util.Scanner;

public class F_Triple {

	Scanner sc = new Scanner(System.in);

	/*
	 * 삼항 연산자 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다. - 조건식의 결과가 true 이면 값 1을 수행한다. - 조건식의 결과가 false
	 * 이면 값 2를 수행한다.
	 */
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.practice1();
//		f.practice2();
		f.practice3();
	}

	// 리턴 값이 없는 함수 : void
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		// 양수이다. 음수이다.
		System.out.print("정수값 입력 > ");
		int number = sc.nextInt();

		// System.out.println 출력하는 역할만 하고 출력하는 값(return type)이 없음
		String result = (number > 0) ? "양수이다." : "음수이다.";
		// System.out.println(result);

		// 0이다. 포함
//		result = (number > 0) ? "양수이다." : number == 0 ? "0이다." : "음수이다.";
		result = (number > 0) ? "양수이다." : number < 0 ? "음수이다." : "0이다.";
		System.out.println(result);
	}

	/*
	 * 실습문제 1 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈결과 100보다 크거나 같은 경우 "결과가 100 이상입니다." 아닌
	 * 경우 "결과가 100보다 작습니다." 출력
	 */
	public void practice1() {
		System.out.print("첫 번째 정수값 입력 > ");
		int number1 = sc.nextInt();

		System.out.print("두 번째 정수값 입력 > ");
		int number2 = sc.nextInt();

		String result = number1 * number2 >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		System.out.println(result);
	}

	/*
	 * 실습문제 2 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면 "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다." 출력
	 */
	public void practice2() {
		System.out.print("문자 입력 > ");
		char ch = sc.nextLine().charAt(0);

		String result = ch >= 'A' && ch <= 'Z' ? "알파벳 대문자이다." : "알파벳 대문자가 아니다.";
		System.out.println(result);
	}

	/*
	 * 실습문제 3 두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출격 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다."
	 * 출력
	 * 
	 * 예시) 첫 번째 수 > 3 두 번째 수 > 4 연산자 입력(+ 또는 -) > + 3 + 4 = 7
	 * 
	 * 연산자 입력(+ 또는 -) > - 3 - 4 = -1
	 * 
	 * 연산자 입력(+ 또는 -) > * 잘못 입력했습니다. 출력
	 */
	public void practice3() {
		// num1, num2에서 'sc.nextInt' 사용 시 enter 처리하지 않고 ch에서 'sc.nextLine' 사용으로 ch가 뜨지 않고 에러 발생!
		// ->> num1, num2도 'sc.nextLine(enter 처리)'로 지정. but sc.nextLine은 String 이기 때문에 parseInt 사용
		// parseInt : parseInt로 String을 담으면 Int로 결과 값을 받을 수 있음
		
		System.out.print("첫 번째 정수 입력 > ");
//		String num1 = sc.nextLine();
//		int num1_2 = Integer.parseInt(num1);
//		위 두줄을 한 줄로 줄이기 :
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 정수 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자 입력(+ 또는 -) > ");
		char ch = sc.next().charAt(0); 
		
		
		int plus = num1 + num2;
		int minus = num1 - num2;
		
		// String.format 사용 풀이 
//		String result = ch == '+' ? String.format("%d + %d = %d", num1, num2, plus): ch == '-' ? String.format("%d - %d = %d", num1, num2, minus) : "잘못 입력했습니다.";
		
		// System.out.printf 사용 풀이 -> system.out.println(result) : 필요없음
//		if(ch == '+' || ch == '-') {
//			System.out.printf("%d %c %d = %d", num1, ch, num2, ch == '+' ? plus : minus);
//		} else {
//			System.out.println("잘못 입력했습니다.");
//		}
		
		String result = ch == '+' ? num1 + " + " + num2 + " = " + plus : ch == '-' ? num1 + " - " + num2 + " = " + minus : "잘못 입력했습니다.";
		System.out.println(result);
	}

}
