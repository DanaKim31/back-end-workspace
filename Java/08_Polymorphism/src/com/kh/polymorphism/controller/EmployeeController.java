package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController{
	// 각각 매개변수와 리턴값 뭘로 처리를 해야하는지
	
	// 1. 이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {		
		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee;
			}
		}
		return null; // 위 조건에 해당하는 결과값이 없을 때 null로 return
	}
	
	
	
	// 2. 찾은 사람의 연봉은? -> 한 사람의 연봉을 찾는 기능!
	public int getAnnualSalary(Employee e) { // Employee result -> Employee e로 수정(변수명은 (Application에서와) 맞출 필요 없음)
		int annualSalary = e.getSalary() * 12;
		if(e instanceof Engineer) {
			Engineer engineer = (Engineer) e; // Employee(부모) 클래스를 Engineer(자식) 클래스에 넣기 때문에 강제 형 변환!
			return annualSalary + engineer.getBonus();
		} 
		return annualSalary;
	}
	
	
	
	// 3. 전체 사람들의 연봉 총 합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(Employee employee : empArr) {
			sum += getAnnualSalary(employee);
		}
		return sum;
	}

}
