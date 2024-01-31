package com.kh.step4;

import javax.swing.JOptionPane;

//두 스레드간의 Communication은 프로세스의 자원으로 해야한다
// 프로세스
public class InputThreadTest3 {

	boolean check = false; 
	
	public static void main(String[] args) {
		
		InputThreadTest3 process = new InputThreadTest3();

		InputThread3 input = new InputThread3(process); // 에러발생! -> 프로세스를 담을 수 있는 생성자 생성
		input.start();

		CountThread3 count = new CountThread3(process);
		count.start();

	}
}



class InputThread3 extends Thread {

	// 생성자로 받은 매게변수
	InputThreadTest3 process;
	
	// 프로세스를 담을 수 있는 생성자 생성
	InputThread3(InputThreadTest3 process) {
		this.process = process;
	}
	
	public void run() {
		// 1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..");
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
		
		process.check = true;
	}
}

class CountThread3 extends Thread {

	InputThreadTest3 process;
	
	// 프로세스(main)를 담을 수 있는 생성자 생성
	CountThread3(InputThreadTest3 process) {
		this.process = process;
	}
	
	public void run() {
		// 2. 카운팅 작업
		for (int i = 10; i > 0; i--) {
			if(process.check) break;
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000); // 1초에 하나씩 / try-catch
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		// 카운트다운 종료시까지 인풋 미입력시 강제 종료
		if(!process.check) {
			System.out.println("10초 경과! 값 입력 중지");
			System.exit(0); // 강제종료
		}
	}
}