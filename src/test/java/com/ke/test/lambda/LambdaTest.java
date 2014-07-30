package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ke.test.TwoArgIntOperator;

public class LambdaTest {

	@Test
	public void testLambda() {
		assertThat((intMethod((x, y) -> x + y, 5, 10)), is(15));

	}

	private int intMethod(TwoArgIntOperator operator, int x, int y) {
		return operator.op(x, y);
	}
}
