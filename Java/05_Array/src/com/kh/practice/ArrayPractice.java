package com.kh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
		a.method5();
	}

	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 */
	public void method1() {
//		String[] fruit = {"사과", "포도", "복숭아", "체리", "딸기"};
		String[] fruits = new String[5];
		fruits[0] = "사과";
		fruits[1] = "포도";
		fruits[2] = "복숭아";
		fruits[3] = "체리";
		fruits[4] = "❤딸기❤";

		System.out.println(fruits[4]);
		
		
//		==================== ArrayList 풀이 ====================

		ArrayList<String> fruitsList = new ArrayList<>(Arrays.asList(fruits));
//		fruitsList.add("사과");
//		fruitsList.add("포도");
//		fruitsList.add("복숭아");
//		fruitsList.add("체리");
//		fruitsList.add("❤딸기❤");
		
		System.out.println(fruitsList.get(4));
		
	}

	
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된
	 * 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5 배열 0번째 인덱스에 넣을 값 : 4 배열 1번째 인덱스에 넣을 값 : -4 배열 2번째 인덱스에 넣을 값 : 3 배열 3번째
	 * 인덱스에 넣을 값 : -3 배열 4번째 인덱스에 넣을 값 : 2 [4, -4, 3, -3, 2] 2
	 */
	public void method2() {
		System.out.print("정수 : ");
		int num = sc.nextInt();

		int[] arr = new int[num];

		int sum = 0;
		/*
		for (int i = 0; i < num; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		*/
		
//		==================== ArrayList 풀이 ===================
		
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
		System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
		// arrList.add(sc.nextInt());
		// sum += arrList.get(i);
		
		int answer = sc.nextInt();
		arrList.add(answer);
		sum += answer;
		}
		
		System.out.println(arrList);
		System.out.println(sum);
		
	}

	
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을
	 * 출력하세요.
	 * 
	 */
	public void method3() {
		String[] menu = { "라자냐", "피자", "스테이크", "치킨캐서롤", "파스타" };

		System.out.print("메뉴 입력 : ");
		String input = sc.nextLine();

//		==================== for문 풀이 ====================
		
		/* for문 풀이_1
		boolean check = false;
		for (int i = 0; i < menu.length; i++) {
			if (menu[i].equals(input)) {
				check = true;
			}
		} 
		if(check == true) {
			System.out.println("배달 가능");
		} else {
			System.out.println("배달 불가능");
		}
		*/	
		
		/* for문 풀이_2
		for (int i = 0; i < menu.length; i++) {
			if (menu[i].equals(input)) {
				System.out.println("배달 가능");
				break;
			} else if(i == menu.length-1) {
				System.out.println("배달 불가능");
			}
		} 
		*/
		
//		============== 향상된 for문 + 삼항연산자 풀이 ==============
		
		/*
		boolean check = false;
		for(String food : menu) {
			if(input.equals(food)) {
				check = true;
			}
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");
		*/
		
//		==================== ArrayList 풀이 ====================
		
		ArrayList<String> menuList = new ArrayList<>(Arrays.asList(menu));
		boolean check = false;
		for(String food : menuList) {
			if(input.equals(food)) {
				check = true;
			}
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");
	}

	
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요. 단, 원본 배열은 건드리지 않고!
	 * 
	 * 주민등록번호 : 123456-1234567 123456-1******
	 * 
	 */
	public void method4() {
		System.out.print("주민등록번호 : ");
		String idNo = sc.nextLine();

//		==================== for문 풀이 ====================
		
		/* for문_1
		char[] arr = idNo.toCharArray(); // String을 배열로 변경
		for (int i = 0; i < arr.length; i++) {
			if (i > 7) arr[i] = '*';
		}
		System.out.print(arr);
		*/
		
		/* for문_2
		char[] arr = idNo.toCharArray(); // String을 배열로 변경
		String[] strNo = idNo.split("");
		for (int i = 0; i < arr.length; i++) {
			if (i <= 7) {
				System.out.print(strNo[i]);
			} else {
				System.out.print("*");
			}
		}
		*/
		
//		==================== ArrayList 풀이 ====================
		
		
	}

	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요.
	 * 
	 * 단어 입력 : programming gnimmargorp
	 * 
	 */
	public void method5() {
		System.out.print("단어 입력 : ");
		String input = sc.nextLine();

		String[] arr = input.split("");

//		==================== for문 풀이 ====================
		
		/*
		for (int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		*/
		
//		==================== ArrayList 풀이 ====================
		
		ArrayList<String> inputList = new ArrayList<>(Arrays.asList(arr));
		Collections.reverse(inputList);
		for(String s : inputList) {
			System.out.print(s);
		}
	}

}
