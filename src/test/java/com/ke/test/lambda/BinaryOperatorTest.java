package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.BinaryOperator;

import org.junit.Test;

public class BinaryOperatorTest {

	private BinaryOperator<Long> add = (x, y) -> x + y;

	@Test
	public void binaryOperatorTest() {
		assertThat(add.apply(5l, 6l), is(11l));
	}

}
