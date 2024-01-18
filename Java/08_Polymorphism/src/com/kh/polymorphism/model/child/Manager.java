package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Manager extends Employee {

	private String dept;

	// 기본 생성자
	public Manager() {}

	public Manager(String name, int salary, String dept) { // String dept 추가
		super(name, salary);
		this.dept = dept; // dept 추가
	}

	
	// setter, getter
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	// toString 
	@Override
	public String toString() {
		return super.toString() + " / Manager [dept=" + dept + "]";
	}
	
}
