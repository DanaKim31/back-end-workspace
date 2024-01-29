package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.model.Student;

/*
 * 필터링
 * 	- 중간 처리 기능으로 요소를 걸러내는 역할
 * */

public class A_Filtering {

	public static void main(String[] args) {
		A_Filtering a = new A_Filtering();
//		a.method1();
		a.method2();
	}

	// distinct : 중복 제거
	public void method1() {
		
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미", "정대윤", "이상호", "권예빈");
		Stream<String> stream = names.stream();
		stream.forEach(name -> System.out.print(name + " ")); 
		
		System.out.println("\n=== 중복제거 ===");
		
//		stream.forEach(name -> System.out.print(name + " ")); // 에러 발생! (위에서 stream을 사용함, stream은 일회용)
		stream = names.stream(); // stream을 다시 불러오면 stream 사용 가능
		stream.distinct().forEach(name -> System.out.print(name + " "));
		
		System.out.println("\n=== 객체 추가 ===");
		
		List<Student> students = Arrays.asList(
					new Student("이상현", 20, "남자", 80, 50),
					new Student("정대윤", 19, "남자", 75, 65),
					new Student("이상호", 21, "남자", 50, 100),
					new Student("권예빈", 18, "여자", 60, 45),
					new Student("손민정", 22, "여자", 70, 90),
					new Student("이상현", 20, "남자", 80, 50),
					new Student("정대윤", 19, "남자", 75, 65));
		
		students.stream().distinct().forEach(student -> System.out.println(student));
	}
	
	// filter (반복문 안에서 조건문 쓴 것과 같음)
	public void method2() {
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미");
		
		names.stream().filter(name -> name.startsWith("이")).forEach(name -> System.out.print(name + " ")); // 이상현 이상호 
		
		
		System.out.println("\n=== 객체 추가 ===");
		
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 65),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90),
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 65));
		
		// 성별이 여자인 요소만 출력
		System.out.println("\nQ1. 성별이 여자인 요소만 출력"); // 화살포 앞뒤 : 변수명(변수명이기 때문에 임의로 지정 가능하지만 화살표 전 후로 동일하게 작성해야 함)
		students.stream().filter(student -> student.getGender().startsWith("여")).forEach(student -> System.out.println(student));
		
		System.out.println("\nQ2. 수학/영어 60점 이상인 요소만 출력");
		// 수학 점수, 영어 점수 둘 다 60점 이상인 요소만 출력
		students.stream().filter(student -> student.getMath() >= 60 && student.getEnglish() >= 60)
//						 .filter((Student student) -> {return student.getMath() >= 60 && student.getEnglish() >= 60;})
						 .distinct()
						 .forEach(student -> System.out.println(student));
	}
}











