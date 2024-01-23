package com.kh.practice2.controller;

import com.kh.practice2.exception.DuplicateNameException;
import com.kh.practice2.exception.RecordNotFoundException;
import com.kh.practice2.model.Member;

public class MemberController {

	public Member[] mArr = new Member[3];	

	public int count = 0; // --> Application에서도 접근할 수 있도록 public으로 설정

	
	
	// 멤버 추가
	public void insertMember(Member m) throws DuplicateNameException, RecordNotFoundException {
		
// Exception!! 
		int index = checkId(m.getId());
		if(index==-1) {
		
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
//		System.out.println(Arrays.toString(mArr)); // 임시 확인
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException(); // import 후 throw ->  public void insertMember에 throws 추가 및 application 오류 발생
		}
	}
	
	
	
	// 멤버 index를 아이디로 조회  -->  에러 발생 시키는 부분이 추가/수정 때! 아래 public 차례로 추가할 때 에러 발생, 수정할 때 에러 발생
	public int checkId(String id) throws DuplicateNameException, RecordNotFoundException {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				throw new DuplicateNameException(); // import 후 throw (checkId에 throws)
			} else {
				// throw new RecordNotFoundException(); // import 후 throw (checkId에 throws)
			}
		}
		return -1; // 없는 경우를 -1로 지정(인덱스는 0~2 이기 때문에 -1 존재하지 않음)
	}

	public int checkUpdateId(String id) throws DuplicateNameException, RecordNotFoundException {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// throw new DuplicateNameException();
			} else {
				throw new RecordNotFoundException(); // import 후 throw (checkId에 throws)
			}
		}
		return -1; // 없는 경우를 -1로 지정(인덱스는 0~2 이기 때문에 -1 존재하지 않음)
	}
	
	
	
	
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) throws DuplicateNameException, RecordNotFoundException {
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
	}

	
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
	
	
	
//		public void insertMember(String id, String name, String password, String email, char gender, int age) {
		// second
//		mArr[count++] = new Member(id, name, password, email, gender, age);
		
		// first
//		mArr[count] = new Member();
//		mArr[count].setId(id);
//		mArr[count].setName(name);
//		mArr[count].setPassword(password);
//		mArr[count].setEmail(email);
//		mArr[count].setGender(gender);
//		mArr[count].setAge(age);
//		count += 1;
//		}
	

}
