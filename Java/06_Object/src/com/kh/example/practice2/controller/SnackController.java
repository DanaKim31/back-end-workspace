package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack();
	
	// saveDate로 사용자가 입력한 값 저장
	public String savaData(String kind, String name, String flavor, int numOf, int price) {
//		System.out.println("서버 시작!");
//		System.out.println(kind + ", " + name + ", " + flavor + ", " + numOf + ", " + price);
		
		s.setKind(kind); 
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다.";
	}
	
	public String confirmData() {
		return s.getKind() + "(" + s.getKind() + " - " + s.getFlavor() + ") " + s.getNumOf() + "개 " + s.getPrice() + "원";
	}
}
