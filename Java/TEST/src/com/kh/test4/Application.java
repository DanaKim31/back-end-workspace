package com.kh.test4;

import com.kh.test4.model.Person;

public class Application {

	public static void main(String[] args) {
		Person[] pArr = new Person[3];
		pArr[0] = new Person("가");
		pArr[1] = new Person("나");
		pArr[2] = new Person("다");
		
		// 1. 배열에 값이 없어서 null   =>   배열에 값 
		// 2. i<=pArr  -->>  i<pArr
		for(int i=0; i<pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
	}

}
