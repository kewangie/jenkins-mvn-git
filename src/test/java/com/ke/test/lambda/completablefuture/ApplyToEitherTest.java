package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class ApplyToEitherTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void applyThisTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 5;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
			}
			return 8;
		}, EXECUTOR);

		int result = thisFuture.applyToEither(otherFuture, value -> value + 10).join();

		assertThat(result, is(15));
	}

	@Test
	public void applyThisOtherExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 5;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException();
		}, EXECUTOR);

		int result = thisFuture.applyToEither(otherFuture, value -> value + 10).join();

		assertThat(result, is(15));
	}

	@Test
	public void applyOtherThisExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from this");
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			return 8;
		}, EXECUTOR);

		int result;
		try {
			result = thisFuture.applyToEither(otherFuture, value -> value + 10).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from this"));
		}

	}

	@Test
	public void applyOtherTest() throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
			}
			return 5;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			return 8;
		}, EXECUTOR);

		int result = thisFuture.applyToEither(otherFuture, value -> value + 10).join();

		assertThat(result, is(18));
	}
}
