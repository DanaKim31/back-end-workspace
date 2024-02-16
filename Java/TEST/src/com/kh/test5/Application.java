package com.kh.test5;

import java.util.ArrayList;
import java.util.List;

import com.kh.test5.model.Fruit;

public class Application {

	public static void main(String[] args) {
		
		// 1. 제네릭스(<>)와 바나나 타입 다름  -->>  바나나 삭제 또는 제네릭스 삭제
		// 2. i<list.length  -->>  i<list.size()
		// 3. [i].getName  -->>  (i).getName
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보라"));
//		list.add(new Fruit("바나나"));
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}

}
