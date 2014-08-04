package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class ThenCombineTest {
	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void thenCombineTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 10;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
			}
			return 8;
		}, EXECUTOR);

		int result = thisFuture.thenCombine(otherFuture, (thisValue, otherValue) -> thisValue + otherValue).join();

		assertThat(result, is(18));
	}

	@Test
	public void thenCombineOtherExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 10;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from other");
		}, EXECUTOR);

		int result;
		try {
			result = thisFuture.thenCombine(otherFuture, (thisValue, otherValue) -> thisValue + otherValue).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from other"));
		}

	}

	@Test
	public void thenCombineBothExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from this");
		}, EXECUTOR);
		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from other");
		}, EXECUTOR);

		int result;
		try {
			result = thisFuture.thenCombine(otherFuture, (thisValue, otherValue) -> thisValue + otherValue).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from this"));
		}

	}
}