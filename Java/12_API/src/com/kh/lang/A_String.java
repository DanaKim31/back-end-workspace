package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_String {

	public static void main(String[] args) {
		A_String a = new A_String();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}

	/*
	 * String 클래스
	 * 	- 불변의 클래스 (객체를 생성하면 변경 불가능)
	 * 	- 변경이 적고 읽기가 많은 경우에 사용하는 것이 좋다
	 * 	- new 없이도 객체를 생성할 수 있는 유일한 객체
	 * */
	public void method1() {
		// 문자열 리터럴과 new 연산자로 생성된 문자열 비교  /  리터럴 : 문자나 숫자 등 '값'
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello"); // new를 사용해서 객체를 생성할 수도 있음
		String str4 = new String("hello");
		
		// 메모리 영역 중 "String pool"이 있는데 1, 2와 같은 리터럴은 이 영역에 들어감
		// 3, 4(new 연산자로 생성된 문자열) : 다른 메모리 영역에 각각의 주소값으로 저장됨
		System.out.println("str1 == str2 : " + (str1 == str2)); // true
		System.out.println("str1 == str3 : " + (str1 == str3)); // false
		System.out.println("str3 == str4 : " + (str3 == str4)); // false
		
		// 메모리 영역 관계없이 값을 비교(명확한 값 비교)
		// .equals() : Object에 있는 메서드. 스트링으로 재정의, 스트링 클래스의 이퀄스라는 메서드 사용하여 비교
		System.out.println("str1.equals(str2) : " + (str1.equals(str2))); // true
		System.out.println("str1.equals(str3) : " + (str1.equals(str3))); // true
		System.out.println("str3.equals(str4) : " + (str3.equals(str4))); // true
	}
	
	// String 클래스에서 제공하는 메서드 중 유용한 메서드
	public void method2() {
		String str = "Hello, Java!";
		
		// 1. charAt
		//	- 매개변수 : int index
		//	- 리턴타입 : char
		// 	- method : 전달받은 index 위치의 하나의 문자만 추출해서 리턴
		char ch = str.charAt(3);
		System.out.println("ch : " + ch); // l
		
		// 2. concat
		//	- 매개변수 : String str
		//	- 리턴타입 : String
		//	- method : 전달받은 문자열과 원본 문자열을 하나로 합친 해로운 문자열을 생성해서 리턴
		String str2 = str.concat("!!!!!");
		str2 = str + "!!!!!"; // concat을 쓰지않고 문자열 합치는 다른 방법임
		System.out.println("str2 : " + str2); // Hello, Java!!!!!!
		
		// 3. substring
		//	- 매개변수 : int beginIndex
		//	- 리턴타입 : String
		//	- method : 문자열의 beginIndex(시작인덱스) 위치에서 부터 끝까지의 문자열을 새로 생성해서 리턴
		//			   * substring(ind beginIndex, int endIndex)
		//			     : 문자열의 beginIndex 위치에서부터 endIndex-1까지의 문자열을 새로 생성해서 리턴
		String str3 = str.substring(6);
		String str4 = str.substring(2, 7);
		System.out.println("str3 : " + str3); //  Java! (스페이스 부터 시작)
		System.out.println("str4 : " + str4); // llo,
		
		// 4. indexOf
		//	- 매개변수 : String str
		//	- 리턴타입 : int
		// 	- method : 전달받은 str의 시작 인덱스를 리턴 (포함되어 있지 않으면 '-1'을 리턴)
		int index = str.indexOf("!");
		System.out.println("index : " + index); // 11 (str 문자열에서 '!'의 인덱스)
		
		int index2 = str.indexOf("Java");
		System.out.println("index2 : " + index2); // 7 (str 문자열에서 'J'의 인덱스)
		
		int index3 = str.indexOf("?");
		System.out.println("index3 : " + index3); // -1 (str 문자열에서 '?'가 없으므로 -1 리턴)
		
		// 5. replace
		//	- 매개변수 : char oldChar, char newChar
		//	- 리턴타입 : String
		//	- method : 문자열에서 old 문자를 new 문자로 변경된 새로운 문자열을 생성해서 리턴
		String str5 = str.replace('l', 'c');
		System.out.println("str5 : " + str5); // Hecco, Java!
		
		// 6. toUpperCase() / toLowerCase()
		//	- 매개변수 : 없음
		//	- 리턴타입 : String
		//	- method : 문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴
		String str6 = str.toUpperCase();
		String str7 = str.toLowerCase();
		System.out.println("str6 : " + str6); // HELLO, JAVA!
		System.out.println("str7 : " + str7); // hello, java!
		
		// 7. trim()
		//	- 매개변수 : 없음
		//  - 리턴타입 : String
		// 	- method : 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴
		//			   실무에서 아이디/비밀번호 입력받은 값의 공백 제거를 위해 주로 쓰임
		String str8 = "                Hello,              Java!          ";
		System.out.println("str8(trim 전) : " + str8); // '                Hello,              Java!          '
		String str9 = str8.trim();
		System.out.println("str9(trim 후) : " + str9); // 'Hello,              Java!'
		
		// 8. toCharArray()
		//	- 매개변수 : 없음
		//	- 리턴타입 : char[]
		//	- method : 문자열의 문자들을 문자 배열에 담아서 해당 배열의 '주소값' 리턴
		char[] arr = str.toCharArray();
		ArrayList<char[]> arrList = new ArrayList<>(Arrays.asList(arr));
		System.out.println("arr : " + arr); // [C@515f550a   <- 주소값
		System.out.println("Arrays.toString(arr) : " + Arrays.toString(arr)); // [H, e, l, l, o, ,,  , J, a, v, a, !]
		System.out.println(arrList);
		
		// 9. valueOf
		//	- 매개변수 : 문자배열
		//	- 리턴타입 : String
		//	- 문자열로 변경해서 리턴
		String str10 = String.valueOf(arr);
		System.out.println("str10 : " + str10); // Hello, Java!
		
		System.out.println("str : " + str); // Hello, Java!
	}
	
	/* StringBuilder & StringBuffer
	 	* 공통점
		 - 가변의 클래스 : String 클래스(불변 클래스)와 달리 내부의 문자열을 수정할 수 있다
	     - 16개의 문자를 저장할 수 있는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가
     	* 차이점
	  	 - StringBuilder : 동기화 되지않음 -> 단일 스레드 환경 권장
	  	 - StringBuffer : 동기화 됨 -> 멀티 스레드 환경 권장
	 */
	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");
		
		// 1. append
		//	- 매개변수 : String str
		//	- 리턴타입 : StringBuilder
		//	- method : 기존 문자열 뒤에 문자열 추가
		sb.append("World!");
		System.out.println(sb); // Hello, World!
		
		// 2. insert
		//	- 매개변수 : int offset, String str
		//	- 리턴타입 : StringBuilder
		//	- method : 문자열의 offset 위치부터 전달받은 문자열 추가
		sb.insert(1, "eeeee");
		System.out.println(sb); // Heeeeeello, World!
		
		// 3. delete
		//	- 매개변수 : int start, int end
		//  - 리턴타입 : StringBuilder
		//	- method : start에서 end-1까지의 인덱스에 해당하는 문자열 삭제
		sb.delete(1, 6);
		System.out.println(sb); // Hello, World!
		
		// 4. reverse()
		//	- 매개변수 : 없음
		//	- 리턴타입 : StringBuilder
		//	- method : 문자열의 순서를 역으로 바꾼다
		sb.reverse();
		System.out.println(sb); // !dlroW ,olleH
		
		
		// 메서드 체이닝_method chaining
		//	- 메서드를 이어서 쓸 수 있다.
		StringBuilder sb2 = new StringBuilder("Java Program");
		sb2.insert(5, "API").delete(8, 15).reverse();
		System.out.println(sb2); // IPA avaJ
	}
	
	/*
	 * StringTokenizer
	 * 	- java.util 패키지에서 제공하는 클래스
	 * 	- 객체 생성 시 생성자로 전달받은 문자열을 구분자를 이용하여 분리
	 * 	- 분리된 최소 단위를 토큰이라고 부른다
	 * */
	public void method4() {
		String str = "HTML,CSS,JavaScript,MySQL,Java,JDBC,Servlet,JSP,jQuery,MyBatis,Spring,React";
		
		// 1. String 클래스의 split 메서드를 이용
		// split
		//	- 매개변수 : String regex
		//	- 리턴타입 : String[]
		//	- method : 입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴
		String[] strArr = str.split(",");
		System.out.println("과목 개수 : " + strArr.length); // 12
		for(String s : strArr) {
			System.out.println(s); // 각 과목명 하나씩 출력
		}
		
		// StringTokenizer 객체 이용
		StringTokenizer st = new StringTokenizer(str, ","); // str : 문자열, "," : 구분자
		String[] resultArray = new String[st.countTokens()];
		int i = 0;
		
		// 변수명.countTokens : 꺼내지 않고 남아있는 토큰의 수를 확인
		System.out.println("과목 개수 : " + st.countTokens()); // 12
	
		// hasMoreTokens() : 남아있는 토큰이 있는지 확인 (있으면 true, 없으면 false)
		// nextToken() : 토큰을 하나씩 꺼내옴 
//			System.out.println(st.hasMoreTokens()); // true
//			System.out.println(st.nextToken()); // HTML
//			System.out.println(st.nextToken()); // CSS
//			System.out.println("꺼내고 남은 과목 개수 : " + st.countTokens()); // 10 (HTML과 CSS를 꺼낸 후 남은 개수)
		
		while(st.hasMoreTokens()) {
			// System.out.println(st.nextToken());
			resultArray[i] = st.nextToken();
			i++;
		}
		System.out.println("array : " + Arrays.toString(resultArray));
		System.out.println("꺼내고 남은 과목 개수 : " + st.countTokens());

	}
}














