package com.kh.practice;

import java.util.Scanner;

public class VariablePracticeDana {
	
	public static void main(String[] args) {
		
		VariablePracticeDana v = new VariablePracticeDana();
//		v.method1();
//		v.method2();
		v.method3();
	}
	
	public void method1() {
		int adult = 2;
		int teen = 3;
		
		int aTicket = 10000;
		int tTicket = 7000;
		
		int total = adult * aTicket + teen * tTicket;
		
		System.out.println("성인 2명 : " + adult*aTicket + "원");
		System.out.println("청소년 3명 : " + teen*tTicket + "원");
		System.out.println("\n총 금액 : " + total + "원");
	}
	
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int num = x; 
		x = y;
		y = z;
		z = num;
		
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}
	
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println("첫번째 문자 : " + str.charAt(0));
		System.out.println("마지막 문자 : " + str.charAt(str.length()-1));
	}
}
