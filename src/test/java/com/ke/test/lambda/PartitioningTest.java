package com.ke.test.lambda;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.Artist;

public class PartitioningTest {

	@Test
	public void partitoningTest() {

		Artist solo1 = new Artist("solo1", "Chinese");
		Artist solo2 = new Artist("solo2", "Chinese");
		Artist solo3 = new Artist("solo3", "Chinese");
		Artist solo4 = new Artist("solo4", "Chinese");
		Artist solo5 = new Artist("solo5", "Chinese");

		Artist band11 = new Artist("band11", "Chinese");
		Artist band12 = new Artist("band12", "Chinese");
		Artist band1 = new Artist("band1", Lists.newArrayList(band11, band12), "Chinese");

		Artist band21 = new Artist("band21", "Chinese");
		Artist band22 = new Artist("band22", "Chinese");
		Artist band2 = new Artist("band2", Lists.newArrayList(band21, band22), "Chinese");

		Map<Boolean, List<Artist>> bandsAndSolo = Stream.of(solo1, solo2, solo3, solo4, solo5, band1, band2).collect(
				partitioningBy(artist -> artist.isSolo()));

		assertThat(bandsAndSolo.get(true).stream().map(artist -> artist.getName()).collect(toList()).toString(),
				is("[solo1, solo2, solo3, solo4, solo5]"));

		assertThat(bandsAndSolo.get(false).stream().map(artist -> artist.getName()).collect(toList()).toString(), is("[band1, band2]"));
	}

}
