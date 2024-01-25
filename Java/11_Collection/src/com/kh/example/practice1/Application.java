package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Application {

	public static void main(String[] args) {
		Application a = new Application();
//		a.method1(); // HashSet 풀이
		a.method2(); // ArrayList 풀이
	}
	
	public void method1() {
		// 로또 번호 랜덤 배열
		HashSet<Integer> ltNum = new HashSet<>(); // Integer : int, double 등 숫자타입
		
//		for(int i=0; ltNum.size()<6; i++) { 
		// => for문 쓸 경우, Set은 중복번호를 자동제거 하기 때문에 중복번호를 제거하고도 여섯개의 값을 출력하려면 i<6; 대신 ltNum.size()<6;  
		// ==> ltNum의 사이즈가 6 미만일 때까지 반복
		while(ltNum.size()<6) {	
			int ltRandom = (int) (Math.random()*45+1);
			ltNum.add(ltRandom);
		}
		// System.out.println("로또번호 : " + ltNum);
		
		int count = 0;
		
		while(true) {
			// 내 번호 랜덤배열
			HashSet<Integer> myNum = new HashSet<>();
			
			while(myNum.size()<6) {
				int myRandom = (int) (Math.random()*45+1);
				myNum.add(myRandom);
			}
			
			count++;
			
			System.out.println("로또번호 : " + ltNum);
			System.out.println("내 번호 : " + myNum);
			
			// while문이 멈추는 조건 : ltNum == myNum
			if(ltNum.equals(myNum)) {
				System.out.println("횟수 : " + count);
				break;
			}
		}		
	}
	
	// ArrayList 풀이 : index 까지 맞춰야 함
	public void method2() {
		ArrayList<Integer> ltNum = new ArrayList<>();
		while(ltNum.size()<6) {	
			int ltRandom = (int) (Math.random()*45+1);
			if(!ltNum.contains(ltRandom)) { // 포함된 데이터값이 없을 경우에만 추가(=중복 값 없이 추가)
	 		ltNum.add(ltRandom);
			}
		}
		// System.out.println(ltNum);
		// Collections.sort(ltNum);
		
		int count = 0;
		
		while(true) {
			// 내 번호 랜덤배열
			ArrayList<Integer> myNum = new ArrayList<>();
			
			while(myNum.size()<6) {
				int myRandom = (int) (Math.random()*45+1);
				if(!myNum.contains(myRandom)) {
				myNum.add(myRandom);
				}
			}
			
			count++;
			
			System.out.println("로또번호 : " + ltNum);
			System.out.println("내 번호 : " + myNum);
			
			// Array로 풀 경우 정렬이 다르면 다른값으로 인식하기 때문에 정렬을 맞춘 후 비교(아래 if문)
			Collections.sort(ltNum); 
			Collections.sort(myNum);
			
			// while문이 멈추는 조건 : ltNum == myNum
			if(ltNum.equals(myNum)) {
				System.out.println("횟수 : " + count);
				break;
			}
		}

	}

}
