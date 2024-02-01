package com.kh.example.practice2.compare;

import java.util.Comparator;

import com.kh.example.practice2.model.Song_t;

public class ArtistDescending implements Comparator<Song_t> {
	
	// extends vs implements
	// class class = extends
	// class interface = implements
	// interface interface = extends
	// class : 단일상속
	// interface : 다중상속

	@Override
	public int compare(Song_t o1, Song_t o2) {
		return o2.getArtist().compareTo(o1.getArtist());
	}

}
