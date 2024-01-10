package com.kh.variable;

public class A_Variable {

	/*
	 * 변수(Variable) = 속성 - 값을 저장하는 "공간"
	 * main method 안!!
	 */

	public static void main(String[] args) {

		// 실행할 메소드가 있는 클래스를 생성(new)
		A_Variable variable = new A_Variable();

		// 생성한 클래스로 메소드 실행(호출)
//		variable.printValue();
		variable.variableTest();
//		variable.constant();
	}

	// method가 여러개 존재할 수 있음
	public void printValue() {

		// Console에 원의 둘레와 원의 넓이를 출력하시오.
		// 원의 둘레 = 반지름(10) x 2 x 3.141592
		// 원의 넓이 = 반지름(10) x 반지름 x 3.141592

		// 변수를 사용하지 않으면
		System.out.println(10 * 2 * 3.141592);
		System.out.println(10 * 10 * 3.141592);

		System.out.println("---------------------------");

		// 변수를 사용하면
		int r = 30; // 10을 변수명 'r'로 담아냄, 정수 데이터 타입 : int
		double pi = 3.141592; // 3.141592를 변수명 'pi'로 담아냄, 실수 데이터 타입 : double

		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
	}

	public void variableTest() {
		/*
		 *   * 변수의 선언
		 *   자료형 변수명;
		 *   
		 *   - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보
		 *   - 변수명 : 변수의 이름으로 값을 읽고, 쓰고, 지우는 작업을 할 때 사용
		 *   
		 *   * 변수의 초기화
		 *   변수명 = 값;
		 *   
		 *   - 변수에 처음으로 값을 저장하는 것
		 *   - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 * */

		// * 기본 자료형(Primitive type) : 실제 값을 저장. 총 여덟개, 그 외에는 다 class
		// stack 메모리에 생성된 공간에 실제 변수값이 저장
		// 1. 논리형(Boolean : True/False) : 1byte(= 8bit / bit : 가장 작은 단위) 
		boolean isTrue; // 변수 선언
		isTrue = true; //변수 초기화
		
		boolean isFalse = false;
//		isFalse = 1; -> boolean 값인 true나 false가 아닌 1이 들어갔기 때문에 에러 발생!
		
		// 2. 문자형 (따옴표 사용, 따옴표 안 무조건 한 글자만 작성) : 2byte(= 16bit)
		char ch = 'a';
//		ch = 'ab'; -> 두 글자 작성했기 때문에 에러 발생!
		
		// 3. 정수형
		byte bNum = 1; // 1byte(-128 ~ 127) 256 = 2^8(2의 8승)
//		bNum = 128; -> 오버플로우(Overflow) 발생
		short sNum = 128; // 2byte = 2^16
		int iNum = 922337283; // 4byte (기본) 2^32
		long lNum = 922337283458L; // 8byte, 숫자 뒤에 L(l)를 입력
		
		System.out.println(lNum);
		
		// 4. 실수형
		float fNum = 1.2F; // 4byte - 숫자 뒤에 F(f)를 입력
		double dNum = 1.2; //8byte (기본)
		
		System.out.println(fNum);
		
		// * 참조 자료형 : 4byte, 기본형을 제외한 나머지 (클래스) - 주소 값을 저장
		// 실제 데이터 값은 heap 메모리에 저장, stack 메모리의 변수 공간에는 실제 변수값이 저장된 heap 메모리의 위치값을 저장
		String name = "이상현"; // String : 여러 글자를 담을 수 있음
		String name2 = new String("이상현");
		System.out.println(name2);
		
		// 변수 네이밍 규칙
		// 1. 대소문자 구분
		int number;
//		String number; -> 자료형(int/String)이 달라도 변수명(number)이 같으면 에러 발생!. 클래스 이름은 패키지 포함!
		int NUMBER; // 대/소문자 다르기 때문에 다른 변수로 인식, 에러 안 남
		int Number; // 대/소문자 다르기 때문에 다른 변수로 인식, 에러 안 남
		
		//2. 숫자로 시작하면 안된다.
//		int 1age; -> 숫자 1이 첫 번째로 왔기 때문에 에러 발생!
		int a2g3e4;
		
		//3. 특수문자는 '_', '$'만 사용 가능. 주로 '$' 사용
		int _age;
		int a_g_e;
		int age$;
//		int %age; -> Syntax(문법) 에러 발생!
//		int age@;
		
		// 4. 예약어(Reserved word)를 사용하면 안 된다.
//		int public;
//		int void;
//		int int;
		int class2;
		
		// 5. [권장사항] 낙타표기법(카멜케이스)
		// 첫 글자는 항상 소문자, 여러 단어가 오면 대문자로 구분
		int maxnumber;
		int max_number; // 자바에서 X(권고하지 않음)
		int maxNumber;
	}
	
	public void constant() {
		/*
		 * 상수
		 * final 자료형 변수명;
		 * 
		 * - 변하지 않는 값으로 특정 변수의 값이 변경되는걸 원하지 않을 때 사용(js에서 const)
		 * - 초기화 이후에는 값을 변경할 수 없다.
		 * */
		int age = 20;
		age = 25;
		System.out.println(age); // 25
		
		// 상수는 변수명을 대문자로 작성
		final int AGE = 30;
//		AGE = 35; -> 에러발생
		System.out.println(AGE);
	}
	
	
}















