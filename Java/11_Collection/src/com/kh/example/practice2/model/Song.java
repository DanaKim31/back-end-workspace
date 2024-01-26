package com.kh.example.practice2.model;

public class Song {

	private String title;
	private String singer;
	
	
	
	public Song() {
	}



	public Song(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}


	
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



	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
}
