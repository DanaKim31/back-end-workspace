// Controller에는 문자 없애는 편. 있을 경우 23개국 번역해야 함
package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.model.Song_t;

public class SongController_t {

	private ArrayList<Song_t> list = new ArrayList<>();
	
	// 싱글톤 패턴(Singleton Pattern) 
	//	- 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	// 1. 생성자는 private
	private SongController_t() {}
	
	// 2. 유일한 객체를 담을 static 변수
	private static SongController_t instance;
	
	// 3. 객체를 반환하는 정적 메서드(유일한 public)
	public static SongController_t getInstance() {
		if(instance == null) instance = new SongController_t();
		return instance;
	}
	
	
	public boolean addLastList(Song_t song) {
		// Application_t 의 addLastList 메서드의 기능을 가져온 후
		// list.add의 return type(boolean) 확인
		// addLastList의 반환값 void -> boolean 변경
		// {} 안 return 
		if(!song.getTitle().equals("") && !song.getArtist().equals("")) {
			return list.add(song);
		}
		return false;	
	}

	
	public boolean addFirstList(Song_t song) {
		if(!song.getTitle().equals("") && !song.getArtist().equals("")) { // 곡명과 가수명 입력값이 있을 때만 추가 성공
			list.add(0, song);
			return true;
		}
		return false;
	}
		
	
	public ArrayList<Song_t> printAll() {
		return list;
	}
	
	
	public Song_t searchSong(String title) {
		for(Song_t song : list) { // Controller로 빠질 "기능"적인 로직
			if(song.getTitle().contains(title)) { 
				return song;
			} 
		}
		return null;
	}
	
	
	public Song_t removeSong(String title) {
		for(Song_t song : list) {
			if(song.getTitle().equals(title)) { // Controller로 빠질 "기능"적인 로직
//				list.remove(song); // Controller로 빠질 "기능"적인 로직
				return list.remove(list.indexOf(song));
			} 
		}
		return null;
	}
	
	
	public Song_t updateSong(String search, Song_t update) {
		for(Song_t song : list) {
			if(song.getTitle().equals(search)) { // Controller로 빠질 "기능"적인 로직
				return list.set(list.indexOf(song), update); // 리스트 목록 수정 : 리스트명.set(수정할 요소 인덱스, 수정할 객체)
			}
		}
		return null;
	}
	
	
	public ArrayList<Song_t> ascTitle() {
		ArrayList<Song_t> cloneList = (ArrayList<Song_t>) list.clone(); // 7번메뉴 실행 시에만 오름차순 정렬, 기존 곡 목록 배열은 변경 없음
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
	}
	
	
	public ArrayList<Song_t> descArtist() {
		ArrayList<Song_t> cloneList = (ArrayList<Song_t>) list.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
	}
}
