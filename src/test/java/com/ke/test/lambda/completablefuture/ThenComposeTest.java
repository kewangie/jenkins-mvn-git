package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class ThenComposeTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void thenComposeTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 10;
		}, EXECUTOR);

		CompletableFuture<Integer> returnedFuture = thisFuture.thenCompose(intValue -> CompletableFuture.supplyAsync(() -> {
			return intValue + 8;
		}, EXECUTOR));

		int result = returnedFuture.join();

		assertThat(result, is(18));
	}
}
