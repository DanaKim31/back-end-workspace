package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 매핑
 * 	- 중간처리 기능으로 스트림의 요소를 다른 요소로 대체하는 역할
 * */

public class C_Mapping {

	public static void main(String[] args) {
		C_Mapping c = new C_Mapping();
//		c.method1();
//		c.method2();
		c.method3();
	}

	// mapXXX : 요소를 대체하는 요소로 구성된 새로운 스트림 생성
	public void method1() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 65),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90));
		
		students.stream().map(student -> student.getName())
						 .forEach(student -> System.out.println(student));
		
		// 수학 점수의 평균(average)
		System.out.println("=== 수학점수 평균 ===");
		double avg = students.stream().mapToInt(mathScore -> mathScore.getMath())
						 			  .average()
									  .getAsDouble(); // average : Optional 객체 -> 기본 자료형으로 한번 더 변환 시켜줘야 함 ==> Optional을 기본자료형 Double로 변환 
		System.out.println(avg);
	}
	
	// flatMapXXX : 하나의 요소를 복수의 요소들로 구성된 새로운 스트림을 생성
	public void method2() {
		List<String> list = Arrays.asList("Java11 Lambda", "StreamAPI Filtering Sorted Mapping");
		list.stream().forEach(System.out::println); // = forEach(str -> System.out.println(str));
		
		System.out.println();
		
		list.stream().flatMap((String str) -> {String[] array = str.split(" ");
											   return Arrays.stream(array);})	
//					 .flatMap(str -> Arrays.stream(str.split(" ")))  => 윗 줄 flatMap과 동일한 코드
					 .forEach(System.out::println);
	}
	
	// asDoubleStream(), asLongStream(), boxed()
	//	- asDoubleStream() : IntStream, LongStream을 DoubleStream으로 변환
	//	- asLongStream() : IntStream을 LongStream으로 변환
	//	- boxed : int, long, double(기본자료형) 요소를 Integer, Long, Double(클래스) 요소로 박싱
	public void method3() {
		int[] array1 = {1, 2, 3, 4, 5};
		double[] array2 = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		Arrays.stream(array1).asDoubleStream().forEach(System.out::println); // int인 array1 배열을 double로 변환
		
		System.out.println();
		
		Arrays.stream(array2).boxed()
							 .sorted(Comparator.reverseOrder()) // double은 기본자료형 이므로 sorted 안됨. Comparator : 객체에만 사용 가능
							 .forEach(System.out::println);
	}
}
