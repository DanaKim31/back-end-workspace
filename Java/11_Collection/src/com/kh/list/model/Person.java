package com.kh.list.model;

public class Person implements Comparable<Person> { // interface 상속할 때 : emplements. emplements는 추상메서드만 들어가 있기 때문에 오버라이딩(아래 참고)해서 해당 메서드를 구현해야 함

	private String name;
	private String addr;
	private int age;

	
	// 생성자 생성(A_ArrayList 클래스에서 name, addr, age 변수에 접근하기 위해 생성)
	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
		

	// getter, setter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}





	// A_ArrayList 클래스에서 결과값 출력 시 한글로 출력하기 위해 Person 클래스에 toString 추가
	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}


	// Comparable<Person> 를 implements 하기 위해 추가
	/* compareTo : 반환되는 값을 가지고 정렬 기준을 잡는다.
		- 자기자신과 매개값으로 전달된 객체가 같은 타입의 객체인지 비교
		- 비교해서 같으면 0을 반환, 자기자신이 크다면 양의 정수(1), 작다면 음의 정수(-1) 반환
	*/
	@Override
	public int compareTo(Person o) {
		// return this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
			// => this.age와 o.age 값이 같으면 0 반환, this.age 값이 더 크면 1 반환, 작으면 -1 반환
		
		// String(class) 비교 : this.변수명.compareTo()   <- 이 코드를 public int comepareTo(Person o) {}의 중괄호 안에 입력
		return this.name.compareTo(o.name);
	}
	
	
	
	
}
