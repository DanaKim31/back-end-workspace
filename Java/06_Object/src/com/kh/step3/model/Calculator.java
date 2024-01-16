package com.kh.step3.model;

public class Calculator {

	/*
	 * 메서드(method) - 작업을 수행하기 위한 명령문의 집합 - 어떤 값을 입력받아서 처리하고 그 결과를 돌려준다. - 단, 입력받는 값이
	 * 없을 수도 있고, 결과를 돌려주지 않을 수도 있음. - 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것을 권고
	 * 
	 * 리턴타입 메서드이름(타입 변수명, 타입 변수명, ...) { // 메서드 호출 시 수행될 코드 return 결과값; <-- 출력하는 곳!
	 * }
	 * 
	 * return 문 - 메서드에서 return문을 만나면 종료 - 반환값이 없는(void) 경우 return문만 사용! - 반환값이 있는 경우
	 * return 문 뒤에 반환값을 지정해야 함
	 * 
	 */
	// 'a와 b를 int문으로 선언'을 한 줄로
	public static int a, b;

	// a + b 값의 형을 public 'void' add() {} 에서 void 자리에 작성
	public int add() {
		return a + b;
	}

	// 두 수의 차를 구하는 기능 : substract
	public int substract() {
		return a - b;
	}

	// 두 수의 곱을 구하는 기능 : multiply
	// 오버로딩 (매개변수값 유무 또는 형(타입)이 다를 경우 다른 메서드 이기 때문에 메서드명을 동일하게 사용 가능)
	public int multiply() { 
		return a * b;
	}
	// 위에서 지정한 a, b가 아닌 multiply를 호출했을 때의 a, b 값 
	// (위에서 지정한 변수명 보다 매개변수에 지정한 변수명이 우선순위 높음)
	// 메서드 명칭이 동일하게 설정이 안되지만 매개변수값이 다르기 때문에 'multiply'로 동일하게 생성 가능
	public int multiply(int a, int b) { 
		return a * b;
	}

	/*
	 * 1. 인스턴스 메서드
	 * 		- 인스턴스 생성 후, '참조변수.메서드명()' 호출
	 * 		- 인스턴스 변수나 인스턴스 메서드와 관련된 작업을 하는 메서드
	 * 
	 * 2. 클래스 메서드 (static 메서드)
	 * 		- 인스턴스 생성 없이 '클래스명.메서드명()' 호출
	 * 		- 인스턴스 변수나 인스턴스 메서드와 관련없는 작업을 하는 메서드
	 * */
	// 두 수의 몫과 나머지를 구하는 기능 : divide (결과값 : "몫은 3, 나머지는 2")
	// public과 String 사이에 static 설정 시 오류 -> static을 붙인거는 static만 올 수 있음.
	// 
	// static은 먼저 올라가기 때문에 static을 안붙인 경우 객체 생성을 해야 올라감
	public static String divide(int a, int b) { // -> 1. static을 넣었기 때문에 quotient와 remainder에도 static 설정해야 함
		return "몫은 " + quotient(a, b) + ", 나머지는 " + remainder(a, b);
	}

	// 두 수의 몫을 구하는 기능 : quotient
	// -> 2. static 설정 시 a와 b 값에 에러 발생 -> 3. a와 b 값 자체(최상단)에 static 설정 또는 매개변수로 받기
	public static int quotient(int a, int b) {
		return a / b;
	}

	// 두 수의 나머지를 구하는 기능 : remainder
	public static int remainder(int a, int b) {
		return a % b;
	}

}
