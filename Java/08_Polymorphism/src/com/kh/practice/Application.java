// 1. 출력내용을 객체 없이 Application에서만 먼저 작성 해보기

package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.controller.LibraryController;

public class Application {
	
	LibraryController lc = new LibraryController();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine()); 
		
		int num = -1; // while문에서 1번 메뉴 선택 시 switch 내 case 1의 if문(num == 1) 결과 값이 출력되기 때문에 메뉴번호에 없는 -1로 설정
		int coupon = 0; // 쿠폰 누적 카운트를 위해 while문 밖에 변수 선언
		String book = null; // 대여한 누적 책을 출력하기 위해 변수 선언
		boolean check = true; // 프로그램 종료(3번 메뉴)에서 사용
		
		while(true) { 
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		int menu = Integer.parseInt(sc.nextLine());
		
		
		// 선택한 메뉴 번호에 따라 출력되는 내용 다름 -> 조건문 switch 사용
		switch(menu) {
			case 1: 
				 // 1번 메뉴를 선택했을 때만 출력되야 함
				System.out.println("Member[name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
				break;
			case 2:
				System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]");
				System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]");
				System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]");
				System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]");
				System.out.print("대여할 도서 번호 선택 : ");
				num = Integer.parseInt(sc.nextLine()); // case 1에서도 num 변수를 사용해야 하고, case 1 내에서 if문으로도 사용해야 하기 때문에 while문 밖에서 int = 0; 으로 선언
				
				// 대여 성공했을 때 조건
				if(num == 0) { 
					coupon++; // 0번 도서 빌릴 때마다 쿠폰 개수 카운트
					book = "Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
				} else if(num == 1) { 
					book = "Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]"; // 1번 도서 선택했을 때 대여한 내역
				} else if(num == 2 && age >= 19) { 
					book = "Book [title=원피스 107] / AniBook [accessAge=19]";
				} else if(num == 3 && age >= 15) { 
					book = "Book [title=주술회전 24] / AniBook [accessAge=15]";
				} 
				
				// 나이제한 실패/성공 조건
				if(num == 2 && age < 19 || num == 3 && age < 15) {
					System.out.println("나이 제한으로 대여 불가능입니다."); // 2번, 3번 도서 나이제한 조건
				} else {
					System.out.println("성공적으로 대여되었습니다.");
				}
				break;
			case 3: 
				check = false;
				break;
		}
		
		}
	}
	
	public void mainMenu() {
		
	}

}
