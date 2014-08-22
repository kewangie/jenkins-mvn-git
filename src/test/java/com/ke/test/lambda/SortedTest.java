package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Maps;

public class SortedTest {

	@Test
	public void testIntSorted() {

		List<Integer> list = Arrays.asList(3, 2, 5, 10, 19, 38, 25);

		int min = list.stream().sorted((p1, p2) -> Integer.compare(p1, p2)).collect(Collectors.toList()).get(0);

		assertThat(min, is(2));

		int max = list.stream().sorted((p1, p2) -> Integer.compare(p1, p2)).collect(Collectors.toList()).get(list.size() - 1);

		assertThat(max, is(38));

		min = list.stream().sorted().collect(Collectors.toList()).get(0);

		assertThat(min, is(2));

		max = list.stream().sorted().collect(Collectors.toList()).get(list.size() - 1);

		assertThat(max, is(38));

	}

	@Test
	public void testBigDecimalSorted() {

		List<BigDecimal> list = Arrays.asList(new BigDecimal("3.00"), new BigDecimal("2.00"), new BigDecimal("5.00"), new BigDecimal("10.00"),
				new BigDecimal("19.00"), new BigDecimal("38.00"), new BigDecimal("25.00"));

		Set<BigDecimal> set = new HashSet<>(list);

		BigDecimal min = set.stream().filter(p -> p.compareTo(new BigDecimal("8.00")) == 1).sorted((p1, p2) -> p1.compareTo(p2))
				.collect(Collectors.toList()).get(0);

		assertThat(min, is(new BigDecimal("10.00")));

		BigDecimal max = set.stream().sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList()).get(list.size() - 1);

		assertThat(max, is(new BigDecimal("38.00")));

		min = list.stream().sorted().collect(Collectors.toList()).get(0);

		assertThat(min, is(new BigDecimal("2.00")));

		max = list.stream().sorted().collect(Collectors.toList()).get(list.size() - 1);

		assertThat(max, is(new BigDecimal("38.00")));

	}

	@Test
	public void testBigDecimalSortedMap() {

		Map<BigDecimal, BigDecimal> map = Maps.newHashMap();
		map.put(new BigDecimal("3.68"), new BigDecimal("25.88"));
		map.put(new BigDecimal("0.58"), new BigDecimal("13.88"));
		map.put(new BigDecimal("2.68"), new BigDecimal("8.88"));
		map.put(new BigDecimal("1.68"), new BigDecimal("57.88"));
		map.put(new BigDecimal("5.78"), new BigDecimal("10.88"));

		assertThat(
				map.entrySet().stream().filter(e -> e.getKey().compareTo(new BigDecimal("2.00")) == 1)
						.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).map(e -> e.getValue()).findFirst().get(), is(new BigDecimal("8.88")));

	}
}
