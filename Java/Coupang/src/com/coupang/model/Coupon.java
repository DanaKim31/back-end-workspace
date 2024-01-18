package com.coupang.model;

import java.util.Date;

public class Coupon {
	private int couponCode;
	private String couponName;
	private Date expiryDate;
//	private String id; --> foreign key를 포함관계로 변경
//	private int prodCode; --> foreign key를 포함관계로 변경
	
	private Customer customer;
	private Product product;
}
