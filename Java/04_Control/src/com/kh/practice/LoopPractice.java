package com.kh.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
		l.method5();
//		l.method6();
	}
	
	
    /*
        1. 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("숫자(1 ~ 100) 입력 > ");
    	int num = sc.nextInt();
    	
    	for(int i=num; i>0; i--) {
    		System.out.println(i);
    	}
    }

    
    
    
    // 2. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int sum = 0;
    	int num = 1;
    	
    	while(sum < 100) {
    		if(num % 2 == 0) {
    			sum += -num; // sum -= num;과 같음
    		} else {
    			sum += num;
    		}
    		
    		if(sum >= 100) {
    			break;
    		}
    		
    		num++;
    	}
    	
    	System.out.println("총 합이 100 이상이 되려면 [" + num + "] 까지 더해야 한다");
    	
    	/*
    	while(true) {
    		if(num % 2 != 0) {
    			sum += num;
    		} else sum += num*-1;
    		
    		if(sum>=100) {
        		System.out.println("num : " + num);
        		break;
        	} 
    		num++;
    	}*/
    }

    
    
    
    /*
        3. 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	
    	// for문 풀이
//    	for(int i=0; i<str.length(); i++) {
//    		if(str.charAt(i) == ch) {
//    		count++;
//    		}
//    	}
    	
    	// 향상된 for문 풀이
    	//	 - str.toCharArray() : 문자열을 문자배열로 변경!
    	for(char s : str.toCharArray()) {
    		if(s == ch) count++;
    	}
    	
    	System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + count);
    }

    
    
    
    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
//    	double random = Math.random(); // 0.0 <= random < 1.0
    	// 사칙연산보다 형변환이 우선순위 더 높음
    	while(true) {
    		int random = (int)(Math.random() * 10);
    		System.out.println(random);
    		if(random == 0) break;
    	}

    }

    
    
    
    /*
        5. 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
//    	double random = Math.random(); // 0.0 <= random < 1.0
    	
    	// 배열 풀이
    	int[] dice = new int[6];
    	
    	for(int i=0; i<10; i++) {
    		int random = (int) (Math.random() * 6); // 주사위 1 = 0 ... 6 = 5
    		dice[random]++;
    	}
    	
    	for(int i=0; i<dice.length; i++) {
    		System.out.println((i+1) + " : " + dice[i]);
    	}
    	
    	
    	
    	/*
    	for(int i=0; i<10; i++) {
    		int random = (int) (Math.random() * 6 + 1);
    		
    		switch(random) {
    		case 1: dice[0]++;
    			break;
    		case 2: dice[1]++;
    			break;
    		case 3: dice[2]++;
    			break;
    		case 4: dice[3]++;
    			break;
    		case 5: dice[4]++;
    			break;
    		case 6: dice[5]++;
    			break;
    		}
    	}
    	
    	for(int i=0; i<dice.length; i++) {
    		System.out.println((i+1) + " : " + dice[i]);
    	}*/
    	
    	
// ----------------------------------------------------------------
    	
    	/* 변수 풀이
    	int count = 0;
    	
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	int d = 0;
    	int e = 0;
    	int f = 0;
    	
    	while(true) {
    		int random = (int) (Math.random() * 6 + 1);
//    		System.out.println(random);
    		count++;
    		if(count == 10) break;
    		
    		switch(random) {
    		case 1 : a++; break;
    		case 2 : b++; break;
    		case 3 : c++; break;
    		case 4 : d++; break;
    		case 5 : e++; break;
    		case 6 : f++; break;
    		
    		}
    	}
    	
    	System.out.println("1 : " + a);
    	System.out.println("2 : " + b);
    	System.out.println("3 : " + c);
    	System.out.println("4 : " + d);
    	System.out.println("5 : " + e);
    	System.out.println("6 : " + f);
    	*/
    	
    }

    
    
    
    /*
        6. 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.


        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
    */
    public void method6() {
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	System.out.print("가위바위보 : ");
    	String input = sc.nextLine();
    	
//    	String computer = null;
    	int random = (int) (Math.random() * 3);
		switch(random) {
			case 0 : System.out.println("컴퓨터 : 가위"); break;
			case 1 : System.out.println("컴퓨터 : 바위"); break;
			case 2 : System.out.println("컴퓨터 : 보"); break;
		}
		
		String result = name + " : " + input + "\n"; 
		
		if(input.equals("가위")) {
			if(random == 0) System.out.println(result + "비겼습니다.");
			else if(random == 1) System.out.println(result + "졌습니다 ㅠㅠ");
			else System.out.println(result + "이겼습니다 !");
		} else if(input.equals("바위")) {
			if(random == 0) System.out.println(result + "이겼습니다 !");
			else if(random == 1) System.out.println(result + "비겼습니다.");
			else System.out.println(result + "졌습니다 ㅠㅠ");
		} else if(input.equals("보")) {
			if(random == 0) System.out.println(result + "졌습니다 ㅠㅠ");
			else if(random == 1) System.out.println(result + "이겼습니다 !");
			else System.out.println(result + "비겼습니다.");
		} else System.out.println("잘못 입력했습니다.");
		
		
		
		/* 강사님 풀이
		String rps = new String{"가위", "바위", "보"};
		
		System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
		switch(true) {
			System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		//  0 - 가위, 1 - 바위, 2 - 보
    		int computer = (int) (Math.random() * 3);
    		System.out.print("컴퓨터 : " + computer);
    		
    		int number = Arrays.asList(rps).indexOf(input);
    		// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
    		System.out.print(name + " : " + number);
    		
    		if(computer == number) {
    			// 비겼을 경우
    			System.out.print("비겼습니다.");
    		} else if((number == 0 && computer == 2) || (number == 1 && computer == 0) || (number == 2 && computer == 1)) {
    			// 이겼을 경우
    			System.out.print("이겼습니다 !");
    			break;
    		} else {
    			// 졌을 경우
    			System.out.print("졌습니다 ㅠㅠ");
    		}
    		
  
		}
		*/
			
    	
    	
    }

}