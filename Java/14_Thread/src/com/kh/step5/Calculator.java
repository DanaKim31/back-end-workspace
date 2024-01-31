package com.kh.step5;

/*
 * 동기화(synchronized)
 * 	- 스레드가 사용 중인 객체의 작업이 끝날 때까지 사용 중인 객체에 잠금을 걸어서 다른 스레드가 접근할 수 없도록 하는 것
 * 	- 동기화 메서드가 객체 내에 여러 개 있을 경우 스레드가 이들 중 하나를 실행하면 다른 스레드는 해당 메서드는 물론이고 객체 내의 다른 동기화 메서드도 실행할 수 없다
 * */

// 공유자원
public class Calculator {

	private int memory;

	
	// getter, setter 추가
	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) { // 동기화 처리(synchronized) 시 user1과 user2 순서대로 각각 처리
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	
}
