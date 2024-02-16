package com.kh.test6.model;

import com.kh.test6.Application;

public class Food extends Application {
	public String name;
	public int kcal;
	
	
	public Food() {
	}


	public Food(String name, int kcal) {
		super();
		this.name = name;
		this.kcal = kcal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKcal() {
		return kcal;
	}


	public void setKcal(int kcal) {
		this.kcal = kcal;
	}


	@Override
	public String toString() {
		return "Food [name=" + name + ", kcal=" + kcal + "]";
	}
	
	
	public static void addFood() {
		
	}
	
	public static void showAllFood() {
		
	}

	public static void deleteFood() {
		
	}
}
