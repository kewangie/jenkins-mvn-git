package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Supplier;

import org.junit.Test;

public class SupplierTest {

	private Supplier<Integer> return8 = () -> 8;

	@Test
	public void testReturn8() {
		assertThat(return8.get(), is(8));
	}

}
