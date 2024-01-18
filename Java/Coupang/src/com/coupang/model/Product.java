package com.coupang.model;

import java.util.Date;

public class Product {

	private int prodCode;
//	private String enteId; --> foreign key를 포함관계로 변경
//	private int cateCode; --> foreign key를 포함관계로 변경
	private String prodName;
	private String prodDesc;
	private int price;
	private int stock;
	private Date prodDate;
	
	private Enterprise enterprise;
	private Category category;
}
