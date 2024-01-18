package com.coupang.model;

import java.util.Date;

public class Delivery {
	private int deliCode;
//	private int purCode; --> foreign key를 포함관계로 변경
	private Date deliDate;
	private String deliCompany;
	private int deliCost;
	private String deliAddr;
	
	private Purchase purchase;
}
