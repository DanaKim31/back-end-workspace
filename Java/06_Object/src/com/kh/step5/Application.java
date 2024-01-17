package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		Book b = new Book(); // 객체 생성
		
		b.setTitle("처음부터 시작하는 주식투자 단타전략"); // b.title = "처음부터...";로 작성하는 것을 setter로 담음
		b.setAuthor("홍인기");
		b.setPrice(21000);
		b.setDiscountRate(0.1);
		
		Book b2 = new Book("나는 메트로폴리탄 미술관의 경비원입니다", 17500, 0.1, "패트릭 브링리");
		
		// getter를 이용하여 두 객체 각각 할인율을 적용한 책 가격을 계산해서 제목과 같이 출력
		// 할인된 가격 = 가걱 - (가격 * 할인율)
		int discount = (int) (b.getPrice() - (b.getPrice() * b.getDiscountRate()));
		int discount2 = (int) (b2.getPrice() - (b2.getPrice() * b2.getDiscountRate()));
			
		System.out.println("'" + b.getTitle() + "'" + "의 가격은 " + discount + "원 입니다.");
		System.out.println("'" + b2.getTitle() + "'" + "의 가격은 " + discount2 + "원 입니다.");
		
	}
	
	
}
