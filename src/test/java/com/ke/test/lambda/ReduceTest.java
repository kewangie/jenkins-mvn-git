package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

public class ReduceTest {

	@Test
	public void testReduce() {

		int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

		assertThat(6, is(count));

		count = Stream.of(1, 2, 3).reduce(9, (acc, element) -> acc + element);

		assertThat(15, is(count));

	}

}
