package com.kh.practice1;

import java.io.FileNotFoundException;
// import java.io.IOException;

public class E_SubClass extends E_SuperClass {

//	@Override
//	public void method() {
//		// 오버라이딩 시 throws 작성하지 않아도 됨
//	}
	
	
	
//	@Override
//	public void method() throws ClassNotFoundException {
//		// 부모 클래스의 메서드와 다른 Exception(IOException 외 다른 Exception)을 throws 하는 것은 불가능
//	}
	
	
	
//	@Override
//	public void method() throws Exception {
//		// 부모 클래스의 메서드보다 더 상위 타입의 Exception을 throws 하는 것은 불가능
		// 부모 클래스의 메서드 : IOException, Exception은 IOException보다 상위 Exception
	
		
	
	@Override
	public void method() throws FileNotFoundException {
		// 부모 클래스의 메서드보다 더 하위 타입의 Exception을 throws 하는 것은 가능
		// 부모 클래스의 메서드와 같은 Exception(IOException)을 throws 하는 것도 가능
		// IOException의 자식으로 FileNotFoundException이 있기 때문에 throws 가능
	}
	
	
	
	
	
}
