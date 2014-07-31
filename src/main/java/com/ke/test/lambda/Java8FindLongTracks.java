package com.ke.test.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Java8FindLongTracks {

	public List<String> findLongTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTrackList().stream()).filter(tract -> tract.getLength() > 60).map(tract -> tract.getName())
				.collect(Collectors.toList());
	}

}
