package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 컨트롤러에서는 화면단 로직은 빼기, 백 단 로직만 두기

public class PersonController {

	// 0. 기본생성자 메서드 생성 -> 기본생성자 메서드 안에 드라이버 로딩 -> try-catch
	public PersonController() {
		// 드라이버 로딩 (메서드 여러개라도 한 번만 해도 됨)
		// 자바에서 제공하는 JDK에 없기 때문에 jar파일 따로 추가해서 연결
		// 자바파일 라이브러리 : 자바 기능 압축파일
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 쿼리 하나가 기능 하나.
	// 1. PersonTest에서 만든 쿼리문이 있는 메소드명 복사 (throws 제외)
	// 2. PersonTest에서 만든 고정적인 반복 기능 메서드 가져오기 (디비 연결, 자원 반납 2개. 총 3개 메서드)
	// 3. 드라이버 로딩 가져오기

	// 고정적인 반복 부분 -- 디비 연결, 자원 반납 -> 공통적인 메서드 정의 후 메서드마다 호출해서 사용
	// 디비 연결 메서드
	public Connection getConnect() throws SQLException {
		// 2. 디비 연결 - 실제로 연결 할 때는 스키마명이 다른 경우가 많음
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	// 자원 반납 메서드(SELECT 제외)
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	// 자원 반납 메서드(SELECT) - 오버로딩 / 매개변수가 다르면 메서드명이 동일해도 됨
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate(); // 양수면 성공, 음수면 실패 / 리턴값 : int
		
		closeAll(ps, conn);
		
		return result;
	}

	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate();

		closeAll(ps, conn);
		
		return result;

	}

	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);

		int result = ps.executeUpdate();

		closeAll(ps, conn);

		return result;
	}

	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();

		while (rs.next()) {
			// 생성자 방식으로 값을 담는 방법
//			list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			
			// setter 방식으로 값을 담는 방법
			Person person = new Person(); // 돌아갈 때마다 객체 생성 해줘야 함
			
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAddress(rs.getString("address"));
			
			list.add(person); // 돌아갈 때마다 리스트에 추가해줘야 함
		
		}
		
		closeAll(rs, ps, conn);
		return list;
				
	}

	public Person searchPerson(int id) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Person person = null;
		
		if (rs.next()) {
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
		}
		
		closeAll(rs, ps, conn);
		
		return person;
		
	}
}
