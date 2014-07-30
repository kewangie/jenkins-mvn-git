package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestMaxAndMin {

	@Test
	public void testMin() {

		List<Integer> list = Arrays.asList(3, 2, 5, 10, 19, 38, 25);

		int min = list.stream().min(Comparator.comparing(x -> x)).get();

		assertThat(min, is(2));

		int max = list.stream().max(Comparator.comparing(x -> x)).get();

		assertThat(max, is(38));

	}

}
