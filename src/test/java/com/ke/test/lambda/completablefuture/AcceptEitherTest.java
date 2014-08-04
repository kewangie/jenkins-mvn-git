package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class AcceptEitherTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
	private static volatile String result;

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void acceptThisTest() {

		CompletableFuture<String> thisFuture = CompletableFuture.supplyAsync(() -> {
			return "Value from this future";
		}, EXECUTOR);

		CompletableFuture<String> otherFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
			}
			return "Value from other future";
		}, EXECUTOR);

		thisFuture.acceptEither(otherFuture, value -> result = value).join();

		assertThat(result, is("Value from this future"));
	}

	@Test
	public void acceptThisOtherExceptionTest() {

		CompletableFuture<String> thisFuture = CompletableFuture.supplyAsync(() -> {
			return "Value from this future";
		}, EXECUTOR);

		CompletableFuture<String> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException();
		}, EXECUTOR);

		thisFuture.acceptEither(otherFuture, value -> result = value);

		assertThat(result, is("Value from this future"));
	}

	@Test
	public void acceptOtherTest() throws InterruptedException, ExecutionException {

		CompletableFuture<String> thisFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
			}
			return "Value from this future";
		}, EXECUTOR);

		CompletableFuture<String> otherFuture = CompletableFuture.supplyAsync(() -> {
			return "Value from other future";
		}, EXECUTOR);

		thisFuture.acceptEither(otherFuture, value -> result = value);

		assertThat(result, is("Value from other future"));
	}
}
