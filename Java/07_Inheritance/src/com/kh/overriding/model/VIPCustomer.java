package com.kh.overriding.model;

// Customer의 특징들을 포함한 특별고객 이므로 Customer를 상속
public class VIPCustomer extends Customer{

	private double saleRatio; // 할인율

	public VIPCustomer(String name) {
		this.name = name;
		this.grade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.1;
	}

	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	@Override // -> toString 시 상속받을 항목(inherited fields) 체크 후 Generate
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", name=" + name + ", grade=" + grade + ", bonusPoint="
				+ bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	/*
	 * 오버라이딩(overriding)
	 * - 자식 클래스가 상속받은 부모 클래스의 메서드를 재정의하는 것
	 * 
	 *  오버라이딩 조건
	 *  - 부모 클래스의 메서드명, 매개변수, 리턴타입 모두 동일 (오버로딩 : 메서드명 일치?)
	 *  - 접근제어자를 좁은 범위로 변경할 수 없다.
	 *  	-> 부모 클래스 메서드가 protected라면, 범위가 같거나 넓은 protected나 public으로만 변경 가능
	 *  
	 *  @Override 어노테이션
	 *   - 명시 안 해줘도 오버라이딩 됨
	 *   - 어노테이션을 붙이는 이유
	 *     : 해당 메서드가 오버라이딩 된 메서드라는 것을 컴파일러에게 알려주는 역할
	 *     : 자식 메서드에서 재정의를 잘못한 경우 컴파일 에러 표시
	 *     
	 * */
	
	
	@Override
	// 할인율 재정의
	public int calcPrice(int price) {
		this.bonusPoint += price * bonusRatio; // 보너스 포인트 계산!
		return price - (int)(price * saleRatio);
	}
	
}
