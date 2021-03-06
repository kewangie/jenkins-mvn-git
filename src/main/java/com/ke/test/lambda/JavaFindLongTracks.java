package com.ke.test.lambda;

import java.util.List;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.Album;
import com.ke.test.lambda.model.Track;

public class JavaFindLongTracks {

	public List<String> findLongTracks(List<Album> albums) {
		List<String> trackNames = Lists.newArrayList();
		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}
		return trackNames;
	}

}
