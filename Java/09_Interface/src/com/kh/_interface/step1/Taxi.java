package com.kh._interface.step1;

public class Taxi implements Vehicle {

	@Override
	public void run() { // 강제성으로 부여
		System.out.println("택시가 달립니다.");
	}

	@Override
	public void turn() {
		System.out.println("택시가 돕니다.");
	}

}
