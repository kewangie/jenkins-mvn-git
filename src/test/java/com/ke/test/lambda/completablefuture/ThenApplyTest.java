package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class ThenApplyTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
	private CompletableFuture<Integer> completableFuture;

	@Before
	public void setUp() {
		completableFuture = new CompletableFuture<Integer>();
		completableFuture.complete(9);
	}

	@Test
	public void testThenApply() {
		CompletableFuture<Integer> future = execute(i -> i + 8);
		assertThat(future.join(), is(17));
	}

	private CompletableFuture<Integer> execute(Function<Integer, Integer> function) {
		return completableFuture.thenApply(function);
	}

}
