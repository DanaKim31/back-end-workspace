// 중요!! 배열 대신 사용
package com.kh.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.model.Person;

/*
 * 컬렉션 : 자바에서 제공하는 자료구조를 담당하는 프레임워크
 * 자료구조 : 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고, 효율적으로 사용하기 위해서 데이터를 저장하거나 조작하는 방법
 * java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함
 * 컬렉션을 사용하면 데이터의 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자료구조적 알고리즘을 구현할 필요가 없음
 * 
 * 컬렉션의 장점
 *  - 저장하는 크기의 제약이 없다
 *  - 데이터의 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결
 *  - 여러 타입의 데이터가 저장 가능(가급적 같은 타입의 데이터 사용 권장)
 *  
 *  컬렉션의 종류 : List, Set, Map
 *   1. List
 *   	- 자료들을 순차적으로 늘어놓은 구조
 *   	- 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 검색, 삭제할 수 있는 기능
 *   	- 중복되는 객체도 저장 가능하고, null 값도 저장 가능 (장점 3. 여러 타입의 데이터 저장 가능)
 *   	- implements로 상속받기 때문에 class가 아닌 interface 
 *   	  (참고 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
 *   
 *    * List의 특징
 *    	- 중복 허용
 *     	- 순서 있음
 *   
 *    * ArrayList
 *    	- 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다.
 *      	- 배열에서 배열크기를 지정하고 시작하는 것 처럼, 저장용량을 지정하고 시작하는데 용량을 초과하더라도 자동 용량 추가 가능
 *      	  (배열은 처음 지정한 이후 배열 크기 추가 불가능)
 *      - 동기화(Synchronized)를 제공하지 않는다. (ArrayList 외 동기화를 제공하는 list가 존재함. 이 후 수업 예정)
 *      - 동기화 : 하나의 자원(데이터)에 대해 여러 개의 스레드가 접근하려 할 때 한 시점에서 하나의 스레드만 사용할 수 있도록 하는 것을 말한다.
 *      		 즉, 동기화를 제공하지 않는 것은 한 데이터에 대해 한 시점에서 하나의
 *
 *   2. Set  >>  set 패키지 참고
 *   3. Map  >>  map 패키지 참고   
 * */

public class A_ArrayList {
	
	public static void main(String[] args) {
		A_ArrayList a = new A_ArrayList();
//		a.method1();
//		a.method2();
		a.method3();
	}
	
	public void method1() {
		List<String> list = new ArrayList<String>(); // List, ArrayList : import
		
		list.add("신대규");
		list.add("정대윤");
		list.add("조세미");
		list.add("정세영");
		list.add("권예빈");
		
		System.out.println(list);
	}
	
	

	public void method2() {
		/* 제네릭스(Generics) 
		 * - 컴파일 시 타입을 체크해 주는 기능
		 * - 다이아몬드 연산자(<>) 사용
		 * - 컬렉션에서 사용하는 이유
		 * 	  1. 명시된 타입의 객체만 저장하도록 제한을 두기 위해 사용
		 * 	  2. 
		 * 
		 * */
		
		// <> : 이 리스트는 데이터타입 Person이라는 것을 명시
		// 		명시하지 않으면 여러 데이터 타입을 넣을 수 있지만 명시하게 되면 다른 데이터타입은 에러 발생 
		ArrayList<Person> list = new ArrayList<Person>();
		
		// list.add("강호동2222"); 
		// => 다이아몬드 연산자(제네릭스) 명시 했기 때문에 "강호동2222"는 Person의 데이터타입이 아니라서 에러 발생!
		
		
		// 1. add : 리스트 끝에 추가
		list.add(new Person("전현무", "삼성동", 46)); // import 후 Person 클래스에서 생성자 생성
		list.add(new Person("남궁민", "서울숲", 45));
		list.add(new Person("이시언", "상도동", 41));
		list.add(new Person("이제훈", "삼성동", 39));
		
		// 2. add : 인덱스를 지정하여 해당 인덱스에 추가 -> 인덱스 지정 후 데이터 정보 입력
		//			내부적으로 기존에 있던 데이터들은 뒤로 밀려나고 지정한 인덱스에 해당 데이터 값 추가됨
		list.add(1, new Person("유재석", "압구정", 51));
		list.add(3, new Person("강호동", "도곡동", 53));
		
		// 3. set : 해당 인덱스의 값을 변경(수정)
		list.set(3, new Person("오은영", "삼성동", 57)); // 인덱스 3 자리에 있던 강호동이 오은영으로 변경됨
		
		// 4. size : 리스트 안에 몇 개의 데이터가 있는지  =>  length의 개념
		System.out.println("사람 수 : " + list.size()); // 6
		System.out.println(list);
		
		// 5. remove : 해당 인덱스의 객체 삭제
		//			   알아서 크기가 줄어들고, 뒤에 있던 객체들도 앞으로 당겨서 재정렬
		// Object로 삭제하는 방법도 있지만 Index로 삭제하는 방법 추천
		list.remove(0); // => 인덱스 0 데이터 : 전현무가 삭제됨
		
		System.out.println("\n삭제 후 사람 수 : " + list.size()); // 5
		System.out.println(list);
		
		// 6. get : 해당 인덱스의 객체 가져오기
		System.out.println(list.get(0)); // 유재석만 출력
		
		// 7. subList : 기존 리스트에서 원하는 만큼 추출해서 새로운 리스트 반환 (잘 사용하지 않음)
		// 				반환타입 List이므로, List로 담을 수 있음
		List<Person> sub = list.subList(0, 2); // 유재석, 남궁민 출력 (인덱스 2번까지 아님, 0 _ 1 _ 2 _ 3...)
		System.out.println("\nsub : \n" + sub);
		
		// 8. addAll : 컬렉션을 통째로 뒤에 추가 (컬렉션으로만 추가 됨)
		list.addAll(sub);
		System.out.println("\naddAll : \n" + list); // list 배열 마지막에 유재석, 남궁민(sub) 중복되어 추가됨 (데이터 중복 가능)
		
		// 9. isEmpty : 컬렉션이 비어있는지
		//				반환타입 boolean이므로, System.out.println으로 출력
		System.out.println("\n리스트가 비어있는가? " + list.isEmpty()); // false
	

		System.out.println("\n---------- 실습문제 ----------\n");
		
		// 1. 리스트에 저장된 사람들의 평균 연령을 출력
		int ageSum = 0;
				
		/* for문 풀이
		for(int i=0; i<list.size(); i++) {
			ageSum += list.get(i).getAge();
		}
		*/ 
		
		// 향상된 for문 풀이
		for(Person p : list) {
			ageSum += p.getAge();
		}
		System.out.println("1. 평균 연령 : " + ageSum/list.size());
		
		
		
		// 2. 저장된 사람들의 이름만 출력
		System.out.println("\n2. 이름만 출력 : ");
		
		/* for문 풀이
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		*/
		
		// 향상된 for문 풀이
		for(Person p : list) {
			System.out.println(p.getName());
		}
		
		
		
		// 3. 삼성동에 사는 사람들만 출력
		System.out.println("\n3. 삼성동에 사는 사람들 : ");
		
		/* for문 풀이
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getAddr() == "삼성동") { // == "삼성동" 대신 .equals("삼성동") 사용 가능
				System.out.println(list.get(i));	
			}
		} 
		*/
		
		// 향상된 for문 풀이
		for(Person p : list) {
			if(p.getAddr().equals("삼성동")) {
				System.out.println(p);
			}
		}
		
		
		
		// 4. 나이 순서대로 출력
//		System.out.println("\n4-1. 나이 순서대로 출력 : ");
//			// Collections.sort(list);  >> Person 클래스에 comepareTo 추상메서드 추가없이 작성 시 에러 발생 
//			// ->> 오류가 발생하는 이유 : 소괄호 안 데이터타입(Person) 클래스에 compareTo라는 추상메서드가 implements 되어있어야 함(Person 클래스 참고)
//		Collections.sort(list);
//		System.out.println(list);
		
		System.out.println("\n4-2. 이름 순서대로 출력 : ");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("\n-----------------------------\n");
		
		
		// 10. clear : 싹 비우기
		list.clear();
		System.out.println(list);
	}
	
	
	public void method3() {
		List<String> list = new ArrayList<>(); // String 선택 후 F3 : 선택한 클래스가 어떻게 짜여져 있는지 확인 가능
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("grape");
		
		// 11. 오름차순 정렬 : Comparable 인터페이스를 구현하고 있는 요소를 가지고 비교한 값들 반환하여 정렬
		Collections.sort(list);
		System.out.println("오름차순 정렬 : " + list);
		
		
		// 12. 내림차순 정렬 : sort 메서드를 통해서 오름차순 정렬 후 reverse 메서드를 호출하여 재정렬
		Collections.reverse(list); // 11번에서 오름차순 정렬을 한 정렬을 reverse
		System.out.println("(11번에서 오름차순 정렬 후)내림차순으로 재정렬 : " + list);
		
		
	}
	
	
	
	
	
	
}






















