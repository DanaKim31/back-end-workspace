package com.kh.test6;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.test6.model.Food;

public class Application {

	static Scanner sc = new Scanner(System.in);
	static Food f = new Food();
	static ArrayList<Food> list = new ArrayList<>();

	public static void main(String[] args) {

		boolean check = false;
		while (true) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.print("번호 선택 : ");
			int number = Integer.parseInt(sc.nextLine());

			switch (number) {
			case 1:
				addFood();
				break;
			case 2:
				showAllFood();
				break;
			case 3:
				deleteFood();
				break;
			case 4:
				System.out.println("종료");
				check = false;
				break;
			}
		}

	}

	public static void addFood() {
		System.out.print("추가할 음식 입력 : ");
		String name = sc.nextLine();

		System.out.print("칼로리 입력 : ");
		int kcal = Integer.parseInt(sc.nextLine());

		if (name != null) {
			System.out.println("음식 정보가 추가 되었습니다.");
			list.add(new Food(name, kcal));
		}
	}

	public static void showAllFood() {
		System.out.println(list);
	}

	public static void deleteFood() {
		System.out.println("삭제하고 싶은 음식 선택 : ");
		String name = sc.nextLine();
		
	}

}
