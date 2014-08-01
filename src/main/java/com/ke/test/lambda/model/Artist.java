/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package com.ke.test.lambda.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import lombok.Getter;

public final class Artist {

	@Getter
	private String name;
	private List<Artist> members;
	@Getter
	private String nationality;

	public Artist(String name, String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist(String name, List<Artist> members, String nationality) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(members);
		Objects.requireNonNull(nationality);
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public Stream<Artist> getMembers() {
		return members.stream();
	}

	public boolean isSolo() {
		return members.isEmpty();
	}

	public boolean isFrom(String nationality) {
		return nationality.equals(nationality);
	}
}
