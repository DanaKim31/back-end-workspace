package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {

	public Member[] mArr = new Member[3];	

	public int count = 0; // --> Application에서도 접근할 수 있도록 public으로 설정

	
	
	// 멤버 추가
	public void insertMember(Member m) {
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
//		System.out.println(Arrays.toString(mArr)); // 임시 확인
		
	}
	
	
	
	// 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1; // 없는 경우를 -1로 지정(인덱스는 0~2 이기 때문에 -1 존재하지 않음)
	}

	
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) {
		int index = checkId(id);
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
