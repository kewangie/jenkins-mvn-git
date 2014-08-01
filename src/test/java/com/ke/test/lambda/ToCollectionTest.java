package com.ke.test.lambda;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ToCollectionTest {

	@Test
	public void testToCollection() {

		Set<Integer> treeSet = Stream.of(1, 2, 59, 23, 78, 32).collect(Collectors.toCollection(TreeSet::new));
		assertThat("[1, 2, 23, 32, 59, 78]", is(treeSet.toString()));
		List<Integer> list = Stream.of(1, 2, 59, 23, 78, 32).collect(toList());
		assertThat("[1, 2, 59, 23, 78, 32]", is(list.toString()));

	}
}
