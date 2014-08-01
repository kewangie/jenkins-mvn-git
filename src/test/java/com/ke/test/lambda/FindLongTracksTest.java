package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.Album;
import com.ke.test.lambda.model.Track;

public class FindLongTracksTest {

	private JavaFindLongTracks javaFindLongTracks;
	private Java8FindLongTracks java8FindLongTracks;
	private List<Album> albums;

	@Before
	public void setUp() {
		javaFindLongTracks = new JavaFindLongTracks();
		java8FindLongTracks = new Java8FindLongTracks();

		albums = Lists.newArrayList();
		Track track1 = new Track("track1", 70);
		Track track2 = new Track("track2", 70);
		Track track3 = new Track("track3", 25);
		Track track4 = new Track("track4", 70);
		Track track5 = new Track("track5", 70);
		Track track6 = new Track("track6", 35);
		Track track7 = new Track("track7", 70);

		List<Track> tracks1 = Lists.newArrayList(track1, track2, track3);
		List<Track> tracks2 = Lists.newArrayList(track4, track5, track6, track7);

		Album album1 = new Album("album1", tracks1);
		Album album2 = new Album("album2", tracks2);

		albums.add(album1);
		albums.add(album2);
	}

	@Test
	public void testFindLongTracks() {
		List<String> trackNames1 = javaFindLongTracks.findLongTracks(albums);
		List<String> trackNames2 = java8FindLongTracks.findLongTracks(albums);

		assertThat(trackNames1.size(), is(5));
		assertThat("[track1, track2, track4, track5, track7]", is(trackNames1.toString()));

		assertThat(trackNames2.size(), is(5));
		assertThat("[track1, track2, track4, track5, track7]", is(trackNames2.toString()));
	}
}
