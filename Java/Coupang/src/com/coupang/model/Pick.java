package com.coupang.model;

import java.util.Date;

public class Pick {
	private int pickCode;
//	private String id; --> foreign key를 포함관계로 변경
//	private int prodCode; --> foreign key를 포함관계로 변경
	private Date pickDate;
	
	private Customer customer; // 같은 coupang 패키지에 있기 때문에 import 필요 없음
	private Product product;
}
