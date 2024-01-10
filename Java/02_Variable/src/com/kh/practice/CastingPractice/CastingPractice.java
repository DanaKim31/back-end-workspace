package com.kh.practice.CastingPractice;

import java.util.Scanner;

public class CastingPractice {
	
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
//		c.method1();
		c.method2();
	}
	
	Scanner sc = new Scanner(System.in);

	public void method1() {
		
		System.out.print("문자 : ");
		String input = sc.nextLine();
		char a = input.charAt(0);
		int first = a;
		int second = first + 1;
		char b = (char) second;
		// char b = input.charAt(0);
		
		System.out.printf("%s unicode : %d\n", a, first);
		System.out.printf("%s unicode : %d", b, second);
	}
	
	public void method2() {
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = (double) sum / 3;
		
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.2f", avg);
	}
}
