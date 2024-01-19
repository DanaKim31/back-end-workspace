package com.kh.example.practice4;

import java.util.Scanner;

import com.kh.example.practice4.controller.CircleController;
import com.kh.example.practice4.controller.RectangleController;

// View
public class Application {

	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	
	private RectangleController rc = new RectangleController();
	
	public static void main(String[] args) {
		
		Application a = new Application();
		a.mainMenu();
	}
	
	
	// 메인 메뉴 출력
	public void mainMenu() {
		boolean check = true;
		while(check) {
			System.out.println("===== 메뉴 =====\n" + "1. 원\n" + "2. 사각형\n" + "9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			switch(Integer.parseInt(sc.nextLine())) {
			case 1 : circleMenu();
				break;
			case 2 : rectangleMenu();
				break;
			case 9 : System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
		
	}
	
	// 원 메뉴 출력
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====\n" + "1. 원 둘레\n" + "2. 원 넓이\n" + "9. 메인으로");
		System.out.print("메뉴 번호 : ");		
//		Integer.parseInt(sc.nextLine()); --> switch 괄호 안과 중복으로 들어갈 경우 사용자에게 입력을 두 번 받는다는 의미이므로 삭제
		
		switch(Integer.parseInt(sc.nextLine())) {
			case 1 : calcCircum();
				break;
			case 2 : calcCircleArea();
				break;
			case 9 : // mainMenu();
				break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
					  circleMenu();
		}
	}
	
	// 사각형 메뉴 출력
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====\n" + "1. 사각형 둘레\n" + "2. 사각형 넓이\n" + "9. 메인으로");
		System.out.print("메뉴 번호 : ");
		
		switch(Integer.parseInt(sc.nextLine())) {
			case 1 : calcPerimeter();
				break;
			case 2 : calcArea();
				break;
			case 9 : // mainMenu();
			break;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				  circleMenu();
			
		}
	}
	
	// 원 정보, 원 둘레 출력
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		
		System.out.print("반지름 : ");
		int r = Integer.parseInt(sc.nextLine());
		
		System.out.println(cc.calcCircum(x, y, r));
//		System.out.printf("위치 : (%d, %d), 너비 : %d, 높이 : %d / 둘레 : %d", x, y, ); 
	}
	
	
	// 원 정보, 원 넓이 출력
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		
		System.out.print("반지름 : ");
		int r = Integer.parseInt(sc.nextLine());
		
		System.out.println(cc.calcArea(x, y, r));
	}
	
	
	// 사각형 정보, 사각형 둘레 출력
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		
		System.out.print("높이 : ");
		int height = Integer.parseInt(sc.nextLine());
		
		System.out.print("너비 : ");
		int width = Integer.parseInt(sc.nextLine());
		
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	
	
	// 사각형 정보, 사각형 넓이 출력
	public void calcArea() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		
		System.out.print("높이 : ");
		int height = Integer.parseInt(sc.nextLine());
		
		System.out.print("너비 : ");
		int width = Integer.parseInt(sc.nextLine());
		
		System.out.println(rc.calcArea(x, y, height, width));
	}	
		
		
}

	
	