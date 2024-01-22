package com.kh._abstract.step1;

public class BasketBall extends Sports {

	public BasketBall(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	public void rule() { // 부모 클래스(Sports)에서 추상 메서드를 사용했기 때문에 무조건 재정의 해야 함
		System.out.println("BasketBall의 선수의 수는 " + this.numberOfPlayers + "명, 공을 던져서 링에 넣어야 한다.");
	}
}
