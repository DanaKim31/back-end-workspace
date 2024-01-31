package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest2 {

	public static void main(String[] args) { // main도 Thread
		
		BeepThread beep = new BeepThread();
		beep.start();

		Toolkit tool = Toolkit.getDefaultToolkit();
		// 경고음 5번 울리는 작업
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000); // 작성 후 try-catch
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
