package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Engineer extends Employee{

	private String tech;
	private int bonus;
	
	// 기본생성자
	public Engineer() {}
	public Engineer(String name, int salary, String tech, int bonus) { // tech, bonus 추가
		super(name, salary);
		this.tech = tech; // 따로 추가
		this.bonus = bonus; // 따로 추가
	}
	
	
	// getter, setter
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
	// toString
	@Override
	public String toString() { // 'super.toString() +' 추가
		return super.toString() + " / Engineer [tech=" + tech + ", bonus=" + bonus + "]";
	}
	
	
	
}
