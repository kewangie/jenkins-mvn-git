package com.ke.test.lambda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmptyStreamTest {

	@Test
	public void testEmptyStream() {

		List<Integer> list = new ArrayList<>();

		list.stream().forEach((next) -> {
		});

	}

}
