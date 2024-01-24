// 1. 출력내용을 객체 없이 Application에서만 먼저 작성 해보기

package com.kh.practice;

//import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.controller.LibraryController;
import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Member m = new Member();
	
	int num = -1; // while문에서 1번 메뉴 선택 시 switch 내 case 1의 if문(num == 1) 결과 값이 출력되기 때문에 메뉴번호에 없는 -1로 설정
	
	// 책에 대한 정보(rentBook) -> rentBook method에서 사용해야 하기 때문에 main method 밖으로 꺼내둠 
	Book[] books = {
			new Book("맛있는 지중해식 레시피", true),
			new Book("카페 샌드위치 마스터 클래스", false),
			new Book("원피스 107", 19),
			new Book("주술회전 24", 15)
	};
	
	LibraryController lc = new LibraryController();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	
	public void mainMenu() {
		// main 은 static이기 때문에 에러 발생! main은 실행용 method 
		// -> static을 피하기 위해서 mainMenu method 생성. main method에서 작성 시 모든 method를 static으로 변경해야 함
		// static은 객체 생성 전에 올라감, static이 아닌 method는 같이 올라가기 때문에 함께 사용 가능
		
		System.out.print("이름 : ");
		m.setName(sc.nextLine()); // setter
		
		System.out.print("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine())); // setter
		
		
		
//		String book = null; // 대여한 책을 출력하기 위해 변수 선언
		
		boolean check = true; // 프로그램 종료(3번 메뉴)에서 사용
		
		while(check) { 
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			
			// 선택한 메뉴 번호에 따라 출력되는 내용 다름 -> 조건문 switch 사용
			switch(menu) {
				case 1: myPage(); 
					break;
				case 2: rentBook();				
					break;
				case 3: check = false;
						System.out.println("프로그램이 종료되었습니다.");
					break;
			}
		
		}
	}
	
	public void myPage() {
		System.out.println(m); 
		// m.toString = 문자열 / 문자열 이기 때문에 출력을 위해서는 System.out.println();의 소괄호 안에 작성
		// 오버라이딩으로 재정의 했기 때문에 m으로 호출 시 문자열로 출력 됨
	}
	
	public void rentBook() {
		for(int i=0; i<books.length; i++) {
			System.out.println(i + "번 도서 : " + books[i]);
		}
		
		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine()); // case 1에서도 num 변수를 사용해야 하고, case 1 내에서 if문으로도 사용해야 하기 때문에 while문 밖에서 int = 0; 으로 선언
		
		Book selectBook = books[num]; // 사용자가 선택한 책! -> 대여할 도서 책!
		
		// getter를 이용해서 기존 책 리스트를 일단 가지고 와야 함!
		Book[] newBookList = m.getBookList(); // Member의 bookList는 private이기 때문에 newBookList로 생성
		
		for(int i=0; i<m.getBookList().length; i++) { // getter
			
			if(m.getBookList()[i] == null) { // 배열 내 인덱스가 null 일 때, getter
				// 대여 가능 공간!
				
//				// 대여 성공했을 때 조건
//				if(num == 0) { // setter
//					// 새로운 쿠폰 값(setter) = 기존 쿠폰 값(getter) + 1
//					
//					// Application에서 생성한 bookList의 setter는 String 배열로 담아야하므로, Application에 새로운 배열 생성(91번 째 줄)
//					// 기존 책 정보가 있으면서 새로운 정보를 추가해야 하기 때문에 newBookList에 m.getBookList를 담아 두고,
//					// 새로운 공간(newBookList)에 아래 새로운 정보들을 담음
//				} 

				// 내가 대여한 책의 쿠폰이 true인 경우
				if(selectBook.isCoupon()) {
					m.setCoupon(m.getCoupon() + 1); // coupon이 true인 경우!
				}
				
				// 내가 대여한 책의 접근 제한 나이보다 많은 경우
				if(m.getAge() >= selectBook.getAccessAge()) {
					newBookList[i] = books[num];
				}

				break;
				
			}
		}
		
		m.setBookList(newBookList); // newBookList를 m.setBookList로 넘김

		// 나이제한 실패/성공 조건
		if(m.getAge() < selectBook.getAccessAge()) { // getter
			System.out.println("나이 제한으로 대여 불가능입니다."); // 2번, 3번 도서 나이제한 조건
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}

}
