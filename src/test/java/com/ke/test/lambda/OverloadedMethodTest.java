package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OverloadedMethodTest {

	@Test
	public void overloadedMethodTest() {
		OverloadedMethod overloadedMethod = new OverloadedMethod();
		String returnValue = overloadedMethod.overloadedMethod((x, y) -> x * y);
		assertThat(returnValue, is("IntegerBinaryOperator"));
	}

}
