package com.kh.inheritance.child;

import com.kh.inheritance.parent.Product;

public class SmartPhone extends Product {
	
	private String mobileAgency; // 통신사

	
	// 생성자 추가
	public SmartPhone() {}

	public SmartPhone(String brand, String pCode, String name, int price, String mobileAgency) { // mobileAgency 추가
		super(brand, pCode, name, price);
		this.mobileAgency = mobileAgency; // mobileAgency 추가
	}

	
	// setter, getter(mobileAgency) 추가
	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	
	// toString 추가
	@Override
	public String toString() {
		return super.toString() +  ", SmartPhone [mobileAgency=" + mobileAgency + "]";
	}
	
	
	

	
}
