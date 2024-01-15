// 클래스 이름 : com.kh.proctice.VariablePractice
// FQCN(Fully Qualified Class Name)
package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
//		v.method1();
//		v.method2();
		v.method3();
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		int adult = 2;
		int teen = 3;
		
		int aPrice = 10000;
		int tPrice = 7000;
		
		int aTotal = adult * aPrice;
		int tTotal = teen * tPrice;
		int result = aTotal + tTotal;
		
		System.out.printf("성인 %d명 : %d원\n", adult, aTotal);
		System.out.printf("청소년 %d명 : %d원\n/n", teen, tTotal);
		System.out.printf("총 금액 : %d원", aTotal + tTotal);
		
//		System.out.printf("성인 " + adult + "명 : " + aTotal + "원\n");
//		System.out.printf("청소년 " + teen + "명 : " + tTotal + "원\n");
//		System.out.println();
//		System.out.printf("총 금액 : " + result + "원");		
	}

	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int number = x;
		
		x = y;
		y = z;
		z = number;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}
	
	public void method3() {
		
		System.out.print("문자열을 입력하세요 : ");
		String input = sc.nextLine();
		
		char first = input.charAt(0);
		char last = input.charAt(input.length() - 1);
		
		System.out.printf("첫 번째 문자 : " + first);
		System.out.println();
		System.out.printf("마지막 문자 : " + last);
	}
}















