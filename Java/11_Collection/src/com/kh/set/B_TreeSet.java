package com.kh.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

/*
 * TreeSet
 * 	- 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * 	- HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
 * */

public class B_TreeSet {

	public static void main(String[] args) {
		B_TreeSet a = new B_TreeSet();
//			a.method1();
			a.method2();
	}
		
	public void method1() {
		Set<String> set = new TreeSet<>(); // 작성 후 임포트 / String에는 comparable 가지고 있음
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		set.add("라미란");
		
		System.out.println(set); // [공명, 라미란, 염혜란, 박병은]  =>  자동 정렬되어 들어감
		System.out.println(set.size()); // 4
		System.out.println("라미란이 포함되어 있는가? " + set.contains("라미란")); // true
		
		set.remove("박병은");; // Set은 순서가 없기 때문에 list와 다르게 인덱스로 삭제(remove) 못 함 => 인덱스 대신 데이터 값을 직접 입력해서 삭제
		System.out.println(set); // [염혜란, 공명, 라미란]  => 박병은 remove 됨
		
		set.clear(); // 전체 값 지우기
		System.out.println("비어있는지? " + set.isEmpty()); // true
	}
	
	public void method2() {
		
		TreeSet<Person> set = new TreeSet<>();
		
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("염혜란", 47));
		set.add(new Person("박병은", 46));
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		
		// 객체는 주소값으로 저장됨. 각 객체의 주소값은 다름 => 각 라미란의 주소값이 다 다르기 때문에 모두 다른 객체로 인식 => 중복제거되지 않음
		// (객체의 주소값을 가지고 비교하기 때문에 모두 다른 객체로 인식해서 중복 제거되지 않음
		// 객체의 중복 제거를 원할 경우 --> 객체 클래스(Person)에서 hashCode and equals 메서드 재정의(Alt + Shift + s)
		System.out.println(set);
		
		// set은 index 없음. index 생성을 위해서 향상된 for문 사용
		for(Person p : set) {
			System.out.println(p);
		}
		
		System.out.println("\n===== Iterator =====");
		/*
		 * Iterator
		 * 	- 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * 	- Iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * 	- 향상된 for문으로 대체 가능
		 * */
		Iterator<Person> it = set.iterator(); // 입력 후 java.util로 임포트
		while(it.hasNext()) { // hasNext() : 읽어올 요소가 있는지 확인
			System.out.println(it.next()); // 다음 요소를 읽어옴
		}
	}
}


