package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * 	- key-value 쌍으로 저장
 * 	- 순서 없음
 * 	- 중복 : 키(key)는 중복 허용하지 않음, 값(value)는 중복 허용
 * 
 * HashMap
 * 	- Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * */

public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();
	}

	public void method1() {
		Map<String, Integer> map = new HashMap<>(); // 제네릭스도 키와 값 각각 두개 지정 / 작성 후 임포트
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		System.out.println(map); // {웨하스=250, 고래밥=180, 나쵸=450, 칸쵸=800}  =>  순서 없음
		
		// 1. 키만 가져오기
		Set<String> key = map.keySet(); // key는 중복 허용하지 않음, set 중복허용하지 않음 / 작성 후 임포트
		System.out.println("1. 키만 가져오기 : " + key); // [웨하스, 고래밥, 나쵸, 칸쵸]
		
		// 2. 값(value)만 가져오기
		Collection<Integer> col = map.values(); // 작성 후 임포트
		System.out.println("\n2. 값만 가져오기 : " + col); // [250, 180, 450, 800]
		
		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator(); // java.util로 임포트, key에 접근
		while(it.hasNext()) {
			String name = it.next();
			// System.out.println(it.next()); // 웨하스 / 고래밥 / 나쵸 / 칸쵸
			System.out.println("\n3." + name + " : " + map.get(name)); // 250 / 180 / 450 / 800
		}
		
		System.out.println("\n향상된 for문으로 변경 : ");
		
		for(String str : key) {
			System.out.println(str + " : " + map.get(str));
		}
		
		System.out.println();
		
		// 4. entrySet
		//  - Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진 것)를 Set 컬렉션에 담아서 반환
		// 	- 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		Set<Entry<String, Integer>> entrySet = map.entrySet(); // Entry : java.util.map으로 임포트
		System.out.println(entrySet);
		
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<>(); // 입력 후 Snack 임포트
		
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		
		System.out.println("과자의 개수 : " + map.size()); // 9 => map의 key는 중복 허용하지 않음. 웨하스 중복
		
		// key값이 중복되서 하나는 자동 제거된 "웨하스"는 둘 중 어떤 웨하스가 들어 있을까요?
		System.out.println(map.get("웨하스")); // 딸기 / put은 단순히 추가가 아니라 수정 역할도 함
		
		// key 값으로 "꼬깔콘" 삭제하기
		map.remove("꼬깔콘");
		System.out.println("과자의 개수 : " + map.size()); // 8 => 꼬깔콘이 삭제됐음
		
		// 1. 홈런볼에 해당하는 과자 정보 출력
		System.out.println("\nQ1. 홈런볼 정보 : " + map.get("홈런볼"));
		
		// 2. 후렌치파이의 맛 정보 출력
		System.out.println("Q2. 후렌치파이 맛 정보 : " + map.get("후렌치파이").getFlavor());
		
		// 3. 모든 과자의 칼로리 총합과 평균 출력
		int sum = 0;
		
		/* entrySet 풀이
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> entry : entrySet) {
			Snack snack = entry.getValue();
			sum += snack.getCalorie();
		} */
		
		/* keySet 풀이 */
		for(String key : map.keySet()) { // map에서 key 값을 가져옴
			Snack snack = map.get(key); // 각 key들의 snack(value) 정보 가져오기
			sum += snack.getCalorie();
		}
		
		
		
		System.out.println("칼로리 총 합 : " + sum);
		System.out.println("칼로리 평균 : " + sum/map.size());
		
		
		
		// 모든 Entry 객체 삭제
		map.clear();
		System.out.println("비어있는지 체크 : " + map.isEmpty()); // true
		System.out.println(map); // 비어있음!
		
	}
}





