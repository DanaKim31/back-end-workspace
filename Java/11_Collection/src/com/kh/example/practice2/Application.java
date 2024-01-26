package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.model.Song;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Song> songList = new ArrayList<>();

	public static void main(String[] args) {
		Application a = new Application();
		a.mainMenu();
	}
	
	
	public void mainMenu() {

		boolean check = true;
		while(check) {
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
		
		
		try {
		int menuNum = sc.nextInt(); // try-catch에서 잡아야 하기 때문에 try 안으로 이동
		sc.nextLine();
			switch(menuNum) {
			case 1: songAddLast();
				break;
			case 2: songAddFirst();
				break;
			case 3: printAll();
				break;
			case 4: songSearch();
				break;
			case 5: songRemove();
				break;
			case 6: songUpdate();
				break;
			case 7: sortTitle();
				break;
			case 8: sortSinger();
				break;
			case 9: System.out.println("종료");
				check = false;
				break;
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다");
		}
			
		}
	}
	
	
	public void songAddLast() {
		System.out.println("\n****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		System.out.println("추가 성공\n");
		
		songList.add(new Song(title, singer));
		
//		if(title == "") {
//			System.out.println("곡 명을 입력해 주세요.");
//		} else if(singer == "") {
//			System.out.println("가수 명을 입력해 주세요.");
//		} else {
//			System.out.println("추가 성공");
//		}
	}
	
	
	public void songAddFirst() {
		System.out.println("\n****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
	
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		System.out.println("추가 성공\n");
		
		songList.add(0, new Song(title, singer));
	}
	
	
	public void printAll() {
		System.out.println("\n****** 전체 곡 목록 출력 ******");
		System.out.println(songList + "\n");
	}
	
	
	public void songSearch() {
		System.out.println("\n****** 특정 곡 검색 ******");
		System.out.println("검색할 곡 명 : ");
		String searchInput = sc.nextLine();
		
		if(songList.contains(searchInput)) {
			System.out.println(" - " + "을 검색했습니다.");
		} else {
			System.out.println("검색한 곡이 없습니다.");
		}
	}
	
	
	public void songRemove() {
		System.out.println("\n****** 특정 곡 삭제 ******");
		System.out.println("삭제할 곡 명 : ");
		String removeInput = sc.nextLine();
		
		if(songList.contains(removeInput)) {
			songList.remove(removeInput);
			System.out.println(" - " + "을 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	
	public void songUpdate() {
		System.out.println("\n****** 특정 곡 수정 ******");
		System.out.println("검색할 곡 명 : ");
		String searchTitle = sc.nextLine();
		
		System.out.println("수정할 곡 명 : ");
		String updateTitle = sc.nextLine();
		
		System.out.println("수정할 가수 명 : ");
		String updateSinger = sc.nextLine();
		
		if(songList.contains(searchTitle)) {
			// 업데이트 진행
			System.out.println(" - " + "의 값이 변경 되었습니다.");
		} else {
			System.out.println("수정할 곡이 없습니다.");
		}
	}
	
	
	public void sortTitle() {
		System.out.println("\n****** 곡 명 오름차순 정렬 ******");
		// Collections.sort(songList);
		System.out.println(songList);
	}
	
	
	public void sortSinger() {
		System.out.println("\n****** 가수 명 내림차순 정렬 ******");
		// Collections.sort(songList);
		System.out.println(songList);
	}

}
