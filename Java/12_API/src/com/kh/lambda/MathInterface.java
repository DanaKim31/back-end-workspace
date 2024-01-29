package com.kh.lambda;

/*
 * 함수적 인터페이스(Function Interface)
 * 	- 단 하나의 추상 메서드만 선언된 인터페이스 (인터페이스 : 함수나 추상메서드만 들어갈 수 있음)
 * 	- @FunctionalInterface 어노테이션을 붙여서 두 개 이상의 추상 메서드가 선언되지 않도록 컴파일 체크
 * 			여러개 쓴다고 해서 오류가 나지는 않지만 어노테이션을 붙이면 하나만 선언하도록 컴페일 체크를 해 줌
 * 	
 * 표준 함수적 인터페이스
 * 	- java.util.function 표준 API 패키지로 제공
 * 	- 용도에 따라 Consumer, Supplier, Function, Operator, Predicate로 구분 (사용할 일 없음) 
 * */

@FunctionalInterface
public interface MathInterface {

	public int calc(int a, int b);
	
}
