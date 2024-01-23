// 회원정보 없을 때 에러 발생
package com.kh.practice2.exception;

//1. 부모 클래스 상속받기
public class RecordNotFoundException extends Exception {

// 2. 생성자 추가 : 기본생성자, String 매개변수만 있는 생성자로만 생성
	public RecordNotFoundException() {
		this("회원 정보가 없어서 에러 발생!");
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	
	
}
