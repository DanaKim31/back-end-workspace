package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {

		// System.out.println(출력하고자하는값); -- 출력 후 줄바꿈 발생
		// System.out.print(출력하고자하는값); -- 출력만 함 (줄바꿈 발생하지 않음)
		System.out.print("hello\n");
		System.out.println("hello");
		
		System.out.println("------------------------------------------");
		
		// System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는 값, 값, ...);
		// 출력하고자하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*
		 * 포맷으로 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * */
		int iNum1 = 10;
		int iNum2 = 20;
		
		// "10% 20%" 출력
		System.out.println(iNum1 + "% " + iNum2 + "%");
		System.out.printf("%d%% %d%%", iNum1, iNum2); // %는 무조건 포맷으로 인식하기 때문에 '%'를 출력하기 위해서는 앞에 % 붙이기
		
		System.out.println(); // -> printf에는 줄바꿈이 없기 때문에 구분선(----)을 아랫줄에 출력하기 위해 넣음
		System.out.println("------------------------------------------");
		
		System.out.printf("%5d\n", iNum1); // 다섯자리 공간을 만든 후 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); // 공간숫자에 마이너스(-) 붙이면 왼쪽 정렬
		System.out.printf("%5d\n", 300);
		
		System.out.println("------------------------------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		// \t : 탭
		System.out.printf("%f\t%f\n", dNum1, dNum2); // 1.234568	4.530000 => 무조건 소수점 아래 6
		System.out.printf("%.3f\t%.2f\n", dNum1, dNum2); // 1.235	4.53 => .자릿수
	
		System.out.println("------------------------------------------");
		
		char ch = 'a';
		String str = "Hello";
		
//		System.out.printf("%c %10s %s\n", ch, str); -> %가 세개인데 값을 두가지만 넣었기 때문에 에러 발생!
//		System.out.printf("%c %10s %s\n", ch, str, ch, str); -> 값의 개수가 넘칠 경우 잘라내고 정상 출력
		System.out.printf("%c %10s %s\n", ch, str, ch); // a      Hello a
		System.out.printf("%C %S", ch, str); // A HELLO -> %를 대문자로 입력했기 때문에 대문자로 출력
	}
	

}





























