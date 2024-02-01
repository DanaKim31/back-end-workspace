package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SongController_t;
import com.kh.example.practice2.model.Song_t;

public class Application_t {
	// 여러 메서드에서 사용 -> 전역변수로 빼두기, Application_t에서만 쓰이기 때문에 private 변수로 지정
	private Scanner sc = new Scanner(System.in);
	
	// 담는 역할을 하는 배열리스트는 controller에 작성해야 함
	private SongController_t control = SongController_t.getInstance();
	
	public static void main(String[] args) {
		Application_t app = new Application_t();
		app.mainMenu();
	}

	public void mainMenu() {
		try {

			boolean check = true;
			while (check) {
				System.out.println("===== 메인 메뉴 =====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내림차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				int menu = Integer.parseInt(sc.nextLine());

				switch (menu) {
				case 1:
					addLastList();
					break;
				case 2:
					addFirstList();
					break;
				case 3:
					printAll();
					break;
				case 4:
					searchSong();
					break;
				case 5:
					removeSong();
					break;
				case 6:
					updateSong();
					break;
				case 7:
					ascTitle();
					break;
				case 8:
					descArtist();
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다 : " + e.getMessage());
			mainMenu();
		}
	}

	
	// 1. 마지막 위치에 곡 추가
	public void addLastList() {
		System.out.println("\n****** 마지막 위치에 곡 추가 ******");

		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		System.out.print("가수 명 : ");
		String artist = sc.nextLine();

		Song_t song = new Song_t(title, artist);
//		list.add(new Song_t(title, artist)); // Controller로 빠질 "기능"적인 로직
		boolean result = control.addLastList(song);
		if(result) {
			System.out.println("추가 성공\n");
		} else {
			System.out.println("추가 실패\n");
		}
	}
	

	// 2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("\n****** 첫 위치에 곡 추가 ******");
		
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();

		Song_t song = new Song_t(title, artist);
//		list.add(0, new Song_t(title, artist)); // Controller로 빠질 "기능"적인 로직
		boolean result = control.addFirstList(song);
		if(result) {
			System.out.println("추가 성공\n");	
		} else {
			System.out.println("추가 실패\n");
		}
	}

	
	// 3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("\n****** 전체 곡 목록 출력 ******");
//		for (Song_t song : list) { // Controller로 빠질 "기능"적인 로직
//			System.out.println(song); 
//		}
		for (Song_t song : control.printAll()) {
			System.out.println(song); 
		}
	}

	// 4. 특정 곡 검색
	public void searchSong() {
		System.out.println("\n****** 특정 곡 검색 ******");
		
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();

//		for(Song_t song : list) { // Controller로 빠질 "기능"적인 로직
//			if(song.getTitle().contains(title)) { 
//				System.out.println(song + "을 검색했습니다.");
//			} 
//		}
		Song_t song = control.searchSong(title);
		
		if(song!=null) {
			System.out.println(song + "을 검색했습니다.");
		} else {
			System.out.println("검색할 곡을 찾지 못했습니다.");
		}
	}

	// 5. 특정 곡 삭제
	public void removeSong() {
		System.out.println("\n****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		Song_t song = control.removeSong(title);
		
		if(song != null) {
			System.out.println(song + "을 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
		
	}

	// 6. 특정 곡 수정
	public void updateSong() {
		System.out.println("\n****** 특정 곡 수정 ******");
		
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("수정할 가수 명 : ");
		String artist = sc.nextLine();
		
//		for(Song_t song : list) {
//			System.out.println(song + "의 값이 변경 되었습니다.");
//			if(song.getTitle().equals(search)) { // Controller로 빠질 "기능"적인 로직
//				list.set(list.indexOf(song), new Song_t(title,artist)); // 리스트 목록 수정 : 리스트명.set(수정할 요소 인덱스, 수정할 객체)
//			}
//		}
		Song_t update = new Song_t(title, artist);
		Song_t song = control.updateSong(search, update);
		
		if(song != null) {
			System.out.println(song + "의 값이 변경 되었습니다.");
		} else {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
		

	}

	/*
	 * 얕은배열 복사 / 깊은배열 복사
	 * */
	// 7. 곡 명 오름차순 정렬 => 정렬과 관련된 클래스 추가 생성 해야 함 (compare > TitleAscending)
	public void ascTitle() {
		System.out.println("\n****** 곡 명 오름차순 정렬 ******");
		
		for(Song_t song : control.ascTitle()) { // Controller로 빠질 "기능"적인 로직
			System.out.println(song);
		}
	}

	// 8. 가수명 내림차순 정렬
	public void descArtist() {
		System.out.println("\n****** 가수 명 내림차순 정렬 ******");
		
		for(Song_t song : control.descArtist()) { // Controller로 빠질 "기능"적인 로직
			System.out.println(song);
		}
	}
}
