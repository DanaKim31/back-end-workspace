package person;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonTest {
	
	PersonController pc = new PersonController();

	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
		
		try {			
			// person 테이블에 추가
//			pt.addPerson(111, "김강우", "서울");
//			pt.addPerson(222, "고아라", "제주도");
//			pt.addPerson(333, "강태주", "경기도");
			
			// person 테이블에서 데이터 수정
//			pt.updatePerson(111, "제주도");
			
			// person 테이블에서 데이터 삭제
//			pt.removePerson(333);
			
			// person 테이블에 있는 데이터 전체 보여주기
			pt.searchAllPerson();
			
			// person 테이블에서 데이터 한개만 가져오기
			pt.searchPerson(111);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object) : 메서드 5가지 세트
	// VO(Value Object) : Person
	// VO + DAO = model
	// person 테이블에 추가
	public void addPerson(int id, String name, String address) throws SQLException {
		int result = pc.addPerson(id, name, address);
		if (result == 1) { // result : Controller에 명시. pc.addPerson(~)을 int result로 담은 후 컨트롤러의 addPerson 메서드를 void -> int로 전환, return값을 result로 지정
			System.out.println(name + "님, 회원가입 완료!");
		}
		
	}
	
	
	// person 테이블에서 데이터 수정
	public void updatePerson(int id, String address) throws SQLException {
		pc.updatePerson(id, address);
		if (pc.updatePerson(id, address) == 1) { // result 대신 pc.updatePerson(~)을 바로 넣고 컨트롤러에서 void -> int로 변경, return result 지정
			System.out.println(id + "님, 수정 완료!");
		}
	}
	
	
	// person 테이블에서 데이터 삭제
	public void removePerson(int id) throws SQLException {
		pc.removePerson(id);
		if (pc.removePerson(id) == 1) {
			System.out.println(id + "님, 삭제 완료!");
		}
	}
	
	
	// person 테이블에 있는 데이터 전체 보여주기
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
		for (Person p : list) { // Person : 객체 Person
//			System.out.println(p.getId() + ", " + p.getName() + ", " + p.getAddress());    또는   
			System.out.println(p);
		}
	}
	
	
	// person 테이블에서 데이터 한개만 가져오기
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);
	}

}
