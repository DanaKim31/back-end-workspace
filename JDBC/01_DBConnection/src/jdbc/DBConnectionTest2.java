package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	// 상수값들은 관리하기 쉽도록 따로 빼둠, 상수 : 대문자 + 언더스코어
	// String을 상수값으로 변환 -> final
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";

	public static void main(String[] args) {

		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			
			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
			
			// 3. 쿼리 준비 - INSERT
			//	  바뀌는 데이터 : ?로 입력
			String query = "INSERT INTO employee_copy(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			// 물음표 값 지정
			ps.setInt(1, 700); // 물음표 순서, 데이터값
			ps.setString(2, "김다은");
			ps.setString(3, "111111-2222222");
			
			System.out.println(ps.executeUpdate() + "명 추가!"); // ps.executeUpdate() 리턴타입 : int => 쿼리문 성공 시 1 반환, 실패 시 -1 반환하기 때문
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
