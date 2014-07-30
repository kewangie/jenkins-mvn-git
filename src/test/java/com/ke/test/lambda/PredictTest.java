package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

import org.junit.Test;

public class PredictTest {

	private Predicate<Integer> atLeast5 = x -> x > 5;

	@Test
	public void predicateTestTrue() {
		assertThat(atLeast5.test(6), is(true));
	}

	@Test
	public void predicateTestFalse() {
		assertThat(atLeast5.test(3), is(false));
	}

}
