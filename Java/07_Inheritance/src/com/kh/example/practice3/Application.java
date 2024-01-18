package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;

import com.kh.example.practice3.model.Employee;

public class Application {

	Scanner sc = new Scanner(System.in);
	
	Employee viewEmployee = new Employee();
	
	EmployeeController employeeController = new EmployeeController();
	
	// static일 경우 바로 사용 가능, static 없을 경우 객체생성 후 사용 가능한 메서드
	public static void main(String[] args) {
		
		Application a = new Application();
			
		boolean check = true;
		while(check) {
			int select = a.employeeMenu();
			switch(select) {
				case 1 : a.insertEmp();
					break;
				case 2 : a.updateEmp();
					break;
				case 3 : a.printEmp();
					break;
				case 9 : System.out.println("프로그램을 종료합니다.");
					check = false;
					break; // break만 쓰면 while문에서만 빠져 나옴 > blooean 활용
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			} 
		}
	}
	
	
	// 메인 메뉴를 출력
	public int employeeMenu() {
		System.out.println("1. 사원 정보 추가\n" + "2. 사원 정보 수정\n" + "3. 사원 정보 출력\n" + "9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");		
		return Integer.parseInt(sc.nextLine());
	}
	
	
	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		String add = sc.nextLine();
		
		if(add.equals("y")) {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			System.out.print("사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			
			System.out.print("보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			
			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
			
		} else {
			employeeController.add(empNo, name, gender, phone);
		}
	}
	
	
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?\n" + "1. 사원 번호\n" + "2. 사원 연봉\n" + "3. 보너스 율\n" + "9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
			case 1 : System.out.print("전화 번호 입력 : ");
					 String phone = sc.nextLine();
					 employeeController.modify(phone);
				break;
			case 2 : System.out.print("사원 연봉 입력 : ");
					 int salary = Integer.parseInt(sc.nextLine());
					 employeeController.modify(salary);
				break;
			case 3 : System.out.print("보너스 율 입력 : ");
			 		 double bonus = Double.parseDouble(sc.nextLine());
			 		 employeeController.modify(bonus);
				break;
			case 9 : 
				break;
		}
	}

	
	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(employeeController.info());
	}
}
