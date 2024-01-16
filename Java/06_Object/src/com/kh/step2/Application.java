package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {

		// 클래스 변수는 객체 생성 없이 호출 가능! (width, height 호출 가능)
		System.out.println("width : " + Card.width);
		System.out.println("height : " + Card.height);
		
		Card c1 = new Card(); // static을 붙이지 않았기 때문에 객체(Card c1 = new Card();) 생성 후에 접근(cl.~~) 가능
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 3;
		
		Card.width = 50;
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
		// stack : c1, c2
		// class : Card 
		// Static : width, height (static : 모든곳에서 공유되는 저장공간)
		c1.width = 70; // c2의 width도 바뀜
		c1.height = 90; // c2의 height도 바뀜
		
		
		System.out.println("첫번째 카드는 " + c1.kind + " " + c1.number + " 이며, "
							+ "크기는 " + c1.width + " X " + c1.height + " 입니다.");
		
		System.out.println("두번째 카드는 " + c2.kind + " " + c2.number + " 이며, "
				+ "크기는 " + c2.width + " X " + c2.height + " 입니다.");
	}

}
