package com.coupang.model;

import java.util.Date;

public class Rivew {
	private int reviCode;
//	private String id; --> foreign key를 포함관계로 변경
//	private int prodCode; --> foreign key를 포함관계로 변경
	private String reviTitle;
	private String reviDesc;
	private Date reviDate;
	private int rating;
	
	private Customer customer;
	private Product product;
}
