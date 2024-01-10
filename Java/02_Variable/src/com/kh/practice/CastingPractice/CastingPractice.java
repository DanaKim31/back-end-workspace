package com.kh.practice.CastingPractice;

import java.util.Scanner;

public class CastingPractice {
	
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
		c.method1();
	}
	
	Scanner sc = new Scanner(System.in);

	public void method1() {
		
		System.out.print("문자 : ");
		String input = sc.nextLine();
		char a = input.charAt(0);
		char b = input.charAt(a+1);
		
		System.out.printf("A unicode : " + a);
		System.out.println();
		System.out.printf("B unicode : " + b);
	}
}
