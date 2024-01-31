package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다
public class SharedMemoryTest {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();
		
		// 결과값 : user1, user2 모두 50 출력 --> 공유자원이기 때문에 user1 100으로 실행, user2 50으로 실행 시 user1의 값도 50으로 출력(user2 것만 작업이 진행 됨) 
		// 동시에 작업이 들어왔을 때 순차적으로 처리 : 동기화 처리, 위의 경우 setMemory에 동기화 처리 필요함
	}

}
