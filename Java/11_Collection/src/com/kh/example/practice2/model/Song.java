package com.kh.example.practice2.model;

import java.util.Comparator;

public class Song implements Comparator<Song> {

	private String title;
	private String singer;
	
	
	// 기본 생성자
	public Song() {
	}



	// 매개변수 있는 생성자
	public Song(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}


	
	// getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}



	// toString
	@Override
	public String toString() {
		return singer + "-" + title;
	}



	// sort (Song 클래스에 'implements comparable<Sont>')
	@Override
	public int compare(Song o1, Song o2) {
		return 0;
	}
	
	
		
	
	
}
