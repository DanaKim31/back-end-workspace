package com.kh.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 스트림(stream)
 * 	- 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
 * 
 * 	- Stream의 특징
 * 		1. 데이터를 읽기만 할 뿐 변경하지 않는다.
 * 		2. Iterator처럼 일회용 (필요할 경우 다시 스트림 생성해야 함)
 * 		3. 내부 반복 처리
 * 		4. 병렬로 처리 (빠른 처리)
 * 
 * 	- Stream의 종류
 * 		* java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 갖고, 자식 인터페이스들이 상속 관계를 이루고 있다. 
 * 		  (js에서 화살표함수 다음에 배운 콜백함수와 비슷함)
 *
 * 	- Stream API
 * 		1. 스트림은 자바 8부터 추가된 기능으로 컬렉션(배열)의 저장 요소들을 하나씩 찹조해서 람다식으로 처리할 수 있도록 해주는 반복자(sum이나 forEach와 같은 것들)
 * 		2. 중간처리(intermediate), 최종처리(terminal) 작업을 수행
 * 			- 중간 처리 : 반복(peek), 매핑(타입 변환), 필터링, 정렬 등
 * 			- 최종 처리 : 반복(forEach), 카운팅, 평균, 종합 등의 집계 처리
 * 			- 작성순서 : 중간처리 후 최종처리!! (중간처리끼리, 최종처리끼리는 순서 상관 없음)
 * 		3. 중간처리와 최종처리를 구분하는 방법은 리턴 타입으로 알 수 있음!
 * 			- 리턴 타입이 Stream 이라면 중간 처리 메서드
 * 			- 리탄타입이 기본 타입이거나, Optional 객체라면 최종처리 메서드
 * 		4. 지연된 연산 : 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
 * 
 * */

public class Create {

	public static void main(String[] args) {
		Create c = new Create();
//		c.method1();
		c.method2();
	}

	// 숫자 범위로 스트림을 생성 - IntStream, LongStream, DoubleStream
	public void method1() {
		// range의 범위 : 첫 번째 매개 값 부터 두 번째 매개 값 이전까지의 값을 요소로 가지는 스트림 객체 생성
		IntStream stream = IntStream.range(1, 10); // => 요소 : 1 ~ 9
		int sum = stream.sum(); // 합계값 바깥에서 변수로 지정하고 for문으로 돌린 것과 같은 개념
		System.out.println("range의 sum : " + sum); // 45 (1부터 10 이전인 9까지를 더한 값)
		
		// rangeClosed의 범위 : 첫 번째 매개 값 부터 두 번째 매개 값까지의 값을 요소로 가지는 스트림 객체 생성
		stream = IntStream.rangeClosed(1, 10); // => 요소 : 1 ~ 10
		sum = stream.sum();
		System.out.println("rangeClosed의 sum : " + sum); // 55 (1부터 10까지를 더한 값)
	}
	
	
	/*
	 * 배열(컬렉션)로부터 스트림을 생성하는 방법
	 * */
	public void method2() {
		String[] names = {"이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미"};
		// 배열을 컬렉션으로 변경
		List<String> nameList = Arrays.asList(names);
		
		
		// 향상된 for문으로 출력
		for(String name : names) {
			System.out.print(name + " ");
		}
		
		System.out.println("\n\n=== 스트림으로 출력 ===");
		
		// 스트림으로 출력
		Stream<String> stream = Arrays./*<String>*/stream(names); // 오른쪽 stream에 제네릭스 지정 -> 생략 가능
		stream = Stream./*<String>*/of(names);
		stream.forEach(name -> System.out.print(name + " ")); // 변수 name 지정, 화살표, 리턴값(출력) 입력
		
		System.out.println("\n\n=== 컬렉션으로 출력 ===");
		
		// Collection으로 출력
		stream = nameList.stream();
		stream.forEach(name -> System.out.print(name + " "));
		
	}
}
