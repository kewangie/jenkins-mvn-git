package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FlatMapTest {

	@Test
	public void testFlatMap() {
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());

		assertThat(together, is(Arrays.asList(1, 2, 3, 4)));

	}
}
