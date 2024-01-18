package com.coupang.model;

import java.util.Date;

public class Purchase {
	private int purCode;
//	private String id; --> foreign key를 포함관계로 변경
//	private int prodCode; --> foreign key를 포함관계로 변경
	private Date purDate;
	private String purStatus;
	
	private Customer customer;
	private Product product;
}
