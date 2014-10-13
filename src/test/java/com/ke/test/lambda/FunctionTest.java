package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

public class FunctionTest {

	//private Function<Integer, Integer> plus8 = x -> x + 8;
	private Function<Integer, Integer> plus8 = this::plus8Method;

	private Integer plus8Method(Integer x) {
		return x + 8;
	}

	@Test
	public void testApply() {
		assertThat(plus8.apply(7), is(15));
	}

	@Test
	public void testInMap() {

		List<Integer> listPlused8 = Stream.of(1, 2, 3).map(x -> x + 8).collect(Collectors.toList());

		assertThat(listPlused8.toString(), is("[9, 10, 11]"));

	}

	@Test
	public void testInLoop() {
		List<Integer> list = Lists.newArrayList(1, 2, 3);
		List<Integer> listPlused8 = Lists.newArrayList();
		for (Integer element : list) {
			listPlused8.add(element + 8);
		}
		assertThat(listPlused8.toString(), is("[9, 10, 11]"));
	}
}
