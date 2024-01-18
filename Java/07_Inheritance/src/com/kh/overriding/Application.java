package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	public static void main(String[] args) {

		Customer customer1 = new Customer("이상현");
//		customer1.setName("이상현");
		// System.out.println(customer1.getGrade()); // null, 호출한 Customer는 기본 생성자
		
		Customer customer2 = new Customer("이상현");
		
		// customer1과 customer2 객체를 따로 각각 생성했기 때문에 customer1과 customer2의 주소값은 다름.(동명이인)
		System.out.println(customer1);
		System.out.println(customer2);
		
		System.out.println(customer1 == customer2); // false
		System.out.println(customer1.equals(customer2)); // true(Customer에서 오버라이드로 재정의(이름이 같으면 같은 값으로 인식)
		
		System.out.println();
		
		VIPCustomer customer3 = new VIPCustomer("정세영");
		VIPCustomer customer4 = new VIPCustomer("정세영");
		
		System.out.println(customer3.equals(customer4)); // true (VIPCustomer가 Customer를 상속받았기 때문에 equals 재정의도 상속받음)
		
		// customer1 또는 customer2
		// customer3 또는 customer4
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~~원이며, 적립된 포인트는 ~~점입니다.
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.", 
						  customer1.getName(), customer1.getGrade(), customer1.calcPrice(1000),
						  customer1.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.", 
				  customer3.getName(), customer3.getGrade(), customer3.calcPrice(1000),
				  customer3.getBonusPoint());
	}

}
