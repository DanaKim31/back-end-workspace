package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {
		/*
		 * 변수 호출 방법
		 * - 참조변수.변수;
		 * 
		 * 메서드 호출 방법
		 * - 참조변수.메서드명(); // 매개변수가 없는 경우
		 * - 참조변수.메서드명(값1, 값2, ...); // 매개변수가 있는 경우
		 * */
		// 1. 객체 생성
		Calculator c = new Calculator();
		
		// 2. a와 b 값 지정
		c.a = 3;
		c.b = 98;
		
		// 3. calculator에서 만들어 둔 메서드 활용
		System.out.println("더하기 : " + c.add()); // 101
		System.out.println("빼기 : " + c.substract()); // -95
		// 곱하기는 메서드에서 매개변수(int a, int b)를 지정해 뒀기 때문에 메서드 사용 시 매개변수 값을 지정해 줘야 함)
		System.out.println("곱하기 : " + c.multiply()); // 294 (3 * 98) 
		System.out.println("곱하기 : " + c.multiply(100, 200)); // 20000 (100 * 200)
		System.out.println("나누기 : " + Calculator.divide(c.a, c.b));
		
		System.out.println("팩토리얼 : " + c.factorial(5));
		System.out.println("팩토리얼2 : " + c.factorial2(5));
	}

}
