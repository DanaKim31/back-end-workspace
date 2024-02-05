package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

	// 1. 드라이버 로딩
	public BookController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	// 2. DB 연결
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");	
		return conn;
	}
	
	
	// 자원 반납 메서드
	
	
	
	// 기능 메서드
	
	// 1. 전체 책 조회
	public void printBookAll() throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int bookNo = rs.getInt("BK_NO");
			String bookTitle = rs.getString("BK_TITLE");
			String bookAuthor = rs.getString("BK_AUTHOR");
			int bookPrice = rs.getInt("BK_PRICE");
			int bookPubNo = rs.getInt("BK_PUB_NO");
			
			System.out.println(bookNo + " / " + bookTitle + " / " + bookAuthor + " / " + bookPrice + " / " + bookPubNo);
		}
		System.out.println();
	}
	
	// 2. 책 등록
	public void registerBook() throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문
		String query = "INSERT INTO tb_book VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
	}
	
	
}
