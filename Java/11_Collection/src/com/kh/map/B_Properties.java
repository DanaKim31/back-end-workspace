package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * Properties
 * 	- HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현하는 것 / HashTable : key도 value도 Object
 * 	- (String, String) 형태로 단순화된 컬랙션 클래스
 * 	- 주로 환경설정과 관련된 속성(property)을 저장하는데 사용
 * */

public class B_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties(); // 임포트
		
		// 키값 중복 안되고 순서 없음
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop); // 3개 출력됨(키값 중복 안되고 순서 없음) / Map은 나중에 입력된 Properties로 수정됐음
		// Collection 우선순위 : ArrayList > Properties > HashSet
		
		System.out.println();
		
		Enumeration en = prop.propertyNames(); // 임포트 / Enumeration : Iterator 방식처럼 가지고 오는 방법
		while(en.hasMoreElements()) {
			String key = (String) en.nextElement(); // en.nextElement의 형 : Object 이므로 String으로 형 변환
			String value = prop.getProperty(key);
			
			System.out.println(key + " : " + value);
		}
		
		System.out.println();
		
		Set<Entry<Object, Object>> entrySet = prop.entrySet(); // Hashtable을 상속받았기 때문에 Object, Object 형태
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	} 

}
