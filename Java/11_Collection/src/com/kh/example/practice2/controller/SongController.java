package com.kh.example.practice2.controller;

import java.util.ArrayList;
import com.kh.example.practice2.model.Song;

public class SongController {

	public ArrayList<Song> sList = new ArrayList<>();
	
	
	public void insertMusicLast(Song s) {
		sList.add(new Song(s.getTitle(), s.getSinger()));
	}
	
	
	public void insertMusicFirst(Song s) {
		sList.add(0, new Song(s.getTitle(), s.getSinger()));
	}
	
	
	public ArrayList<Song> printAll() {
		return sList;
	}
	
	
	
	
	
	
	
}
