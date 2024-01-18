package com.coupang.model;

public class Category {
	private int cateCode;
	private String cateName;
//	private int parentCode; -> sql에서 foreign key를 포함관계 방식으로 수정
	
	private Category category;
}
