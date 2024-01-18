package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Secretary extends Employee {

	private String nameOfBoss;

	
	// 기본 생성자
	public Secretary() {}

	public Secretary(String name, int salary, String nameOfBoss) {
		super(name, salary);
		this.nameOfBoss = nameOfBoss;
	}

	
	// getter, setter
	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void setNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	
	// toString
	@Override
	public String toString() {
		return super.toString() + " / Secretary [nameOfBoss=" + nameOfBoss + "]";
	}
	
	
	
	
	
	
}
