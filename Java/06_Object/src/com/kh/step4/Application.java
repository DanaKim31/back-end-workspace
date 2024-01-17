package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {
		Car c = new Car();
		
		/* Car 클래스에서 color, gearType, door를 private으로 지정해 뒀기 때문에 에러 발생!
		c.color = "red";
		c.gearType = "auto";
		c.door = 4;
		*/
		
		Car c1 = new Car("white", "auto", 4); // Car 클래스의 첫 번째 생성자를 호출 함
		Car c2 = new Car("black", "manual"); 
		
		System.out.println(c1); // Car 클래스에서 toString(62행) 작성 전 조회 시 주소값 호출, toSting 작성 후 : 양식에 맞춰서 조회됨
		System.out.println(c2); // (= toString을 명시하지 않으면 주소값 호출, toString 작성 시 내가 원하는 양식에 맞춰서 호출)
	}

	// 오버로딩 : 한 클래스 내에 동일한 이름의 메서드를 매개변수의 자료형과 개수, 순서가 다르게 작성되어야 함 (같은 메서드, 다른 매개)
	void test() {}
	void test(int a) {} // 매개변수를 지정했기 때문에 다른 메서드로 인식
	void test(int a, String s) {} // 매개변수가 다르기 때문에 다른 메서드로 인식
	void test(String s, int a) {} // 매개변수가 다르기 때문에 다른 메서드로 인식
	void test(int a, int b) {} // 매개변수가 다르기 때문에 다른 메서드로 인식 
//	void test(int c, int d) {} // 변수명은 상관 없음, 같은 매개변수를 받기 때문에 같은 메서드로 인식
}
