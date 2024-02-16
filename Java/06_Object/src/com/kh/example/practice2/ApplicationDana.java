package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackControllerDana;

public class ApplicationDana {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		SnackControllerDana con = new SnackControllerDana();
		System.out.println(con.savaData(kind, name, flavor, numOf, price));
		
		System.out.println(con.confirmData());
	}

}
