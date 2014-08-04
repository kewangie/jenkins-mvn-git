package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class RunAfterBothTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
	private static volatile int result;

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void runAfterBothTest() {

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

		thisFuture.runAfterBoth(otherFuture, () -> result = 88).join();

		assertThat(result, is(88));
	}

	@Test
	public void runAfterBothOtherExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			return 5;
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from other");
		}, EXECUTOR);

		try {
			thisFuture.runAfterBoth(otherFuture, () -> result = 88).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from other"));
		}

	}

	@Test
	public void runAfterBothThisExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from this");
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			return 8;
		}, EXECUTOR);

		try {
			thisFuture.runAfterBoth(otherFuture, () -> result = 88).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from this"));
		}

	}

	@Test
	public void runAfterBothBothExceptionTest() {

		CompletableFuture<Integer> thisFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000l);
			} catch (Exception e) {

			}
			throw new RuntimeException("Exception from this");
		}, EXECUTOR);

		CompletableFuture<Integer> otherFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from other");
		}, EXECUTOR);

		try {
			thisFuture.runAfterBoth(otherFuture, () -> result = 88).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from this"));
		}

	}
}
