package com.ke.test.lambda.model;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;

public final class Album {

	@Getter
	private String name;
	private List<Track> tracks;

	public Album(String name, List<Track> tracks) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(tracks);

		this.name = name;
		this.tracks = new ArrayList<>(tracks);
	}

	public List<Track> getTrackList() {
		return unmodifiableList(tracks);
	}
}
