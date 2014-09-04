package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void fibonacciTest() {

		int number = 40;

		long start = System.currentTimeMillis();
		int result1 = loopFib(number);
		long finish = System.currentTimeMillis() - start;
		System.out.println("Loop Fib: " + finish);
		System.out.println("Loop Fib Result: " + result1);

		start = System.currentTimeMillis();
		int result2 = fib(number);
		finish = System.currentTimeMillis() - start;
		System.out.println("Recursive Fib: " + finish);
		System.out.println("Recursive Fib Result: " + result2);

		assertThat(result1, is(result2));

	}

	private int loopFib(int number) {

		if (number == 1 || number == 2) {
			return 1;
		}
		int[] feb = new int[number + 1];
		feb[0] = 0;
		feb[1] = 1;
		feb[2] = 1;
		for (int i = 3; i <= number; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		return feb[number];
	}

	private int fib(int number) {
		if (number == 1 || number == 2)
			return 1;

		return fib(number - 1) + fib(number - 2);
	}
}
