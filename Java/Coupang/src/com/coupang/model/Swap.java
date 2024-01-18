package com.coupang.model;

import java.util.Date;

public class Swap {
	private int swapCode;
//	private String id; --> foreign key를 포함관계로 변경
//	private int prodCode; --> foreign key를 포함관계로 변경
	private String reason;
	private Date swapDate;
	private int price;
	private String swapStatus;
	
	private Customer customer;
	private Product product;
}
