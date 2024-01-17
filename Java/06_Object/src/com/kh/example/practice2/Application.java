package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {

	// 사용자가 Snack 객체에 데이터를 저장할 수 있도록 값을 받고 저장한 값을 출력
	public static void main(String[] args) {
		// ================================== 화 면 ==================================
		Scanner sc = new Scanner(System.in);
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		// ==========================================================================
		// 즉, 여기서 controller나 model에 직접 접근 하지 않음
		
		// 데이터를 서버한테 요청! 그럼 데이터를 서버한테 전달!
		// 전달할 때 controller한테 전달하면 됨!
		SnackController control = new SnackController();
		System.out.println(control.savaData(kind, name, flavor, numOf, price)); // 위(화면 단)에서 생성한 변수값을 그대로 전달
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로!
		System.out.println();
		
		
		

//		Snack s = new Snack("빵", "케이크", "블루베리", 1, 15000	);
//		System.out.println(s);
	}

}
