package com.kh.stream.intermediate;

import java.util.Arrays;

/*
 * 반복
 * 	- 요소 전체를 반복하는 역할
 * 	- peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * 			 최종 처리를 만나기 전 까지는 다른 중간 처리와 함께 쓸 수 있음
 * 	- forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * 				다른 최종처리와 같이 쓰일 수 없음
 * */

public class D_Looping {

	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5};
		
		// peek
		int sum = Arrays.stream(values).filter(i -> i % 2 == 0)
						.peek(value -> System.out.println(value)) // 중간처리만 있기 때문에 실행 안됨(최종처리를 만나야 처리 됨)
						.sum();
		System.out.println("1~5 중 짝수의 합계 : " + sum);
		
		
		// forEach
		Arrays.stream(values).filter(i -> i % 2 == 0)
							 .forEach(value -> System.out.println(value)); 
//							 .sum(); ==> forEach, sum 모두 최종처리 이기 때문에 에러 발생!
		
		int sum2 = Arrays.stream(values)
						 .filter(i -> i % 2 == 0)
						 .sum();
		
		System.out.println("1~5 중 짝수의 합계 : " + sum2);
	}

}
