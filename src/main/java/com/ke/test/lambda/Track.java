package com.ke.test.lambda;

import lombok.Getter;

@Getter
public final class Track {

	private final String name;
	private final int length;

	public Track(String name, int length) {
		this.name = name;
		this.length = length;
	}
}
