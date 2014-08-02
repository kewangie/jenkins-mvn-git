package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class FlatMapTest {

	@Test
	public void testFlatMap() {
		int sum = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(numbers -> numbers.stream()).mapToInt(number -> number).sum();

		assertThat(sum, is(10));

	}
}
