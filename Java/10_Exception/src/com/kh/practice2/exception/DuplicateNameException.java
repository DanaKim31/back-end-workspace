// 중복이름 제외 Exception

package com.kh.practice2.exception;

//1. 부모 클래스 상속받기
public class DuplicateNameException extends Exception {

// 2. 생성자 추가 : 기본생성자, String 매개변수만 있는 생성자로만 생성
	public DuplicateNameException() {
		this("중복된 이름 에러 발생!"); // 만들었을 때 문구 출력
	}

	public DuplicateNameException(String message) {
		super(message); // 입력받은 메시지로 출력
	}

	
	
}
