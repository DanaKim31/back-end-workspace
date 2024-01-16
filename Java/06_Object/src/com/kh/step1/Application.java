package com.kh.step1;

import com.kh.step1.model.Tv;

public class Application {
	
	/*
	 * 객체 : 실제로 존재하는 것
	 * 
	 * 객체 지향 프로그래밍(OOP, Object-Oriented Programming)
	 * - 프로그램을 개발하는 기법으로 객체들을 만들고 이러한 객체들을 연결해서 프로그램을 완성하는 기법
	 * - 객체 지향 프로그래밍 특성을 지원하는 언어를 객체 지향 프로그래밍 언어라고 한다.(Java가 대표적)
	 * - 코드의 재사용성이 높고, 유지보수가 용이하다.
	 * 
	 * 객체 지향 프로그래밍의 특징 (중요!)
	 * 1. 추상화 : 객체들이 가진 공통의 특성들을 파악하고 불필요한 특성들을 제거하는 과정
	 * 			 (객체 생성에 필요한 요소들로 객체를 생성하는 것)
	 * 2. 캡슐화 : 객체의 속성(필드)과 기능(메서드)을 하나로 묶고 실제 구현 내용을 감추는 것
	 * 			 (중요한 특성들을 묶고 노출범위 지정, 예: 알약)
	 * 3. 상속 : 하나의 객체가 가지고 있는 속성(필드)과 기능(메서드)을 다른 객체가 물려받는 것
	 * 			 (부모요소에 있는 특성을 가져오는 것)
	 * 4. 다형성 : 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질
	 * 			 (완전히 다른 클래스를 가져다 쓰는 것)
	 * 
	 * 클래스
	 * - 객체의 특성(속성, 기능)을 정의해 놓은 설계도
	 * - 객체의 속성은 필드(변수)를 통해서 정의
	 * - 객체의 기능은 메서드를 통해서 정의
	 * 
	 * [접근제한자] [예약어] class 클래스명 {...}
	 * 
	 * - 클래스 이름은 작성 규칙에 따라 대문자로 시작
	 * - 파일 이름은 반드시 선언된 클래스 이름과 같도록!
	 * - 접근제한자는 public, default, private, protected 등 설정 가능
	 * - 클래스는 필드(Field), 메서드(Method), 생성자(Constructor)가 정의
	 * - 클래스 작성 시 객체 지향 언어 특징 중 추상화(Abstraction), 캡슐화(Encapsulation)이 적용되어야 함
	 * 
	 * */

	public static void main(String[] args) {

		/*
		 * 객체 생성
		 * 
		 * 클래스명 변수명 = new 클래스명();
		 * 
		 * - new 연산자를 사용해서 생성
		 * - new 연산자는 Heap 영역에 객체를 생성하고 객체의 주소값을 반환
		 * - 객체의 주소값을 참조 타입의 변수에 저장해서 객체 사용
		 * */
		// 객체 생성 = 메모리에 올린다 = 객체의 구성요소(Field, Method)가 다 올라간다
		Tv tv = new Tv(); // 다른 패키지에 있는 클래스 불러옴(Scanner 처럼)
		/*
		 * JVM > Heap > Field, Method가 올라간다
		 * JVM > Stack에 있는 변수에 주소값 할당
		 * */
		System.out.println("TV 상태 : " + tv.power); // false -> TV가 꺼진 상태
		tv.power(); // TV를 킴!
		System.out.println("TV 상태 : " + tv.power); // true -> TV가 켜진 상태
		
		System.out.println("TV 채널 : " + tv.channel); // 0(기본값)
		tv.channelUp(); // 1
		tv.channelUp(); // 2
		tv.channelUp(); // 3
		tv.channelDown(); // 2
		tv.channelDown(); // 1
		tv.channelUp(); // 2
		System.out.println("TV 채널 : " + tv.channel); // 2
	}

}


/* 비추천!!
class TV {
	boolean power; // 전원상태(on/off)
	
	void power() {
		power = !power; // TV를 켜거나 끄는 기능
	}
}
*/













