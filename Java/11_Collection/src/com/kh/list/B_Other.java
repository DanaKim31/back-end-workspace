package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	public static void main(String[] args) {
		B_Other b = new B_Other();
//		b.method1();
//		b.method2(); // 중요!
		b.method3(); // 중요!
	}
	
	/*
	 * Vector
	 * - 동기화를 제공. 동기화된(synchronized) 메서드로 구성 (개념을 스레드를 알아야 함. 스레드는 뒤에서 강의 예정)
	 * */
	public void method1() {
		Vector<Integer> v = new Vector<>(); // 입력 후 임포트
		v.add(0);
		v.add(1);
		System.out.println(v); // [0, 1]
		System.out.println("size : " + v.size()); // 2 - 사이즈
		System.out.println("capacity : " + v.capacity()); // 10 - 용량, 용량 지정하지 않으면 기본값 10
		
		v.trimToSize(); // capacity를 size에 맞춤
		System.out.println("size : " + v.size()); // 2
		System.out.println("capacity : " + v.capacity()); // 2
	}
	
	// 스택(Stack) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조
	// 참고 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html
	public void method2() {
		
		Stack<Integer> s = new Stack<>();
		s.push(0); // push : 생성한 Stack에 저장하는 역할(넣는 역할)
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop(); // pop : 생성한 Stack 내에 저장된 것을 꺼내는 역할, Stack이기 때문에 마지막에 저장된 것을 꺼냄
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		
		System.out.println(s); // [0, 1, 2, 5, 6]
	}
	
	// 큐(Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(Fist In First Out) 구조
	// 참고 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
	public void method3() {
		
		// Queue는 클래스가 아닌 인터페이스(인터페이스는 객체 생성 안됨). 데이터 타입으로는 사용 가능 -> Queue처럼 사용 가능한 LinkedList 메서드로 사용
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(0); // offer : 생성한 Queue에 저장하는 역할(넣는 역할)
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll(); // poll : 생성한 Queue 내에 저장된 것을 꺼내는 역할, Queue이기 때문에 처음에 저장된 것을 꺼냄
		q.add(4);
		q.remove(); // remove : poll과 동일
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
		
		System.out.println(q); // [3, 4, 5, 6, 7]
	}
}
