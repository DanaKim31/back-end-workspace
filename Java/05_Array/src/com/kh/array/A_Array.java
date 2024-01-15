package com.kh.array;

public class A_Array {

	/*
	 * 변수 : 하나의 공간에 하나의 값을 담음
	 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형)을 담음
	 * 
	 * 1. 배열의 선언(두가지 방법)
	 * 	
	 * 		자료형[] 배열명;
	 * 		자료형 배열명[];
	 * 
	 * 		- 배열을 선언하다고 해서 값을 저장할 공간이 생성되는 것이 아니라
	 * 		  배열을 다루는데 필요한 "변수"가 생성되는 것
	 * 
	 * 2. 배열의 초기화
	 * 
	 * 		배열명 = new 자료형[배열크기];
	 * 
	 * 		- 생성된 배열에 처음으로 값을 저장
	 * 
	 * 3. 배열의 선언과 초기화 동시 진행
	 * 
	 * 		자료형[] 배열명 = new 자료형[배열크기];
	 * 		자료형 배열명[] = new 자료형[배열크기];
	 * 
	 * 		- 배열크기 미입력시 에러 발생
	 * */
	public void method1() {
		int[] nums = new int[5]; // 배열크기(5)를 지정하지 않으면 에러!
//		int[] nums = null; -> 가능
		System.out.println(nums); // [I@3d012ddd -> 주소값
		
		// 배열 생성 후 해당 값들은 초기화하지 않은 상태 -> 기본값인 0이 들어간 것 확인
		// 기본값 -> 정수형 : 0 / 실수형 : 0.0 / 문자형 : \u0000 / 논리형 : false / 참조형 : null
		System.out.println(nums[0]); // 0 (int 기본값 : 0)
		System.out.println(nums[1]); // 0
		System.out.println(nums[2]); // 0
		System.out.println(nums[3]); // 0
		System.out.println(nums[4]); // 0
		
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		System.out.println(nums[0]); // 100
		System.out.println(nums[1]); // 70
		System.out.println(nums[2]); // 90
		System.out.println(nums[3]); // 80
		System.out.println(nums[4]); // 60
	}
	
	// 배열 선언과 동시에 값들 초기화
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		
		/*
		 * nums[0]
		 * nums[1]
		 * nums[2]
		 * nums[3]
		 * nums[4]
		 * */
		
		for(int i=0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
	
	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
		a.method2();
	}

}
