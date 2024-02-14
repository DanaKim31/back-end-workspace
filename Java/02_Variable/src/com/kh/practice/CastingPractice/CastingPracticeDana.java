package com.kh.practice.CastingPractice;

import java.util.Scanner;

public class CastingPracticeDana {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		CastingPracticeDana c = new CastingPracticeDana();
		c.method1();
//		c.method2();
	}
	
	public void method1() {
		System.out.print("문자 : ");
		char a = sc.nextLine().charAt(0);
		
		int first = a;
		int second = a+1;
		
		char b = (char) second;
		
		System.out.println(a + " unicode : " + first);
		System.out.println(b + " unicode : " + second);
		
	}
	
	public void method2() {
		System.out.print("국어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		
		System.out.print("영어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		
		System.out.print("수학 : ");
		int math = Integer.parseInt(sc.nextLine());
		
		int total = kor + eng + math;
		
		double avg = (double) total / 3;
		
		System.out.printf("총점 : %d\n평균 : %.2f", total, avg);		
		
	}
}
