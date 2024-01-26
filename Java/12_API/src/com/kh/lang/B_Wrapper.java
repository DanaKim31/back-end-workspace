package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
		B_Wrapper b = new B_Wrapper();
//		b.method1();
		b.method2();
	}

	public void method1() {
		double dNum1 = 3.14; // double : 기본자료형
		// Deprecated : 기능은 있지만 비권장
		Double double1 = new Double(dNum1); // Double에 취소선 : Deprecated, double이 기본자료형 이기 때문에 new 연산자 방법 비권장
		double1 = 3.14; // Boxing : 기본 자료형을 Wrapper 클래스로 변경
		
		int iNum2 = 3;
		Integer int1 = new Integer(iNum2);
		int1 = 3;
		
		char ch3 = 'a';
		Character ch4 = new Character(ch3);
		ch4 = 'a';
	}
	
	// String과 Wrapper 클래스간 변경
	public void method2() {
		// UnBoxing : Wrapper를 기본 자료형으로 변경
		// 1. 문자열을 기본자료형으로 변경 : parseXXX()
		int iNum = Integer.parseInt("20"); 
		double dNum = Double.parseDouble("34.78");
		
		// 2. 기본 자료형을 문자열로 변경
		//	2-1. String 클래스에서 제공하는 valueOf() 메서드
		System.out.println(iNum + dNum); // 54.78
		
		String str1 = String.valueOf(iNum);
		String str2 = String.valueOf(dNum);
		
		System.out.println(str1 + str2); // 2034.78 ("20"에 "34.78"을 이어붙인 결과)
		
		//	2-2. Wrapper 클래스에서 제공하는 valueOf().toString() 메서드
		String str3 = Integer.valueOf(iNum).toString(); // toString의 리턴타입은 무조건 String
		String str4 = Double.valueOf(dNum).toString();
		
		System.out.println(str3 + str4); // 2034.78 ("20"에 "34.78"을 이어붙인 결과)
	}

}
