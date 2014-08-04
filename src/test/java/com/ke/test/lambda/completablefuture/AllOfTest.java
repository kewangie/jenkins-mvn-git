package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.AfterClass;
import org.junit.Test;

public class AllOfTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
	private static AtomicInteger result = new AtomicInteger();

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void allOfTest() {

		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
			return result.incrementAndGet();
		}, EXECUTOR);

		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
			return result.incrementAndGet();
		}, EXECUTOR);

		CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> {
			return result.incrementAndGet();
		}, EXECUTOR);

		CompletableFuture.allOf(f1, f2, f3).join();

		assertThat(result.get(), is(3));
	}

	@Test
	public void allOfExceptionTest() {

		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Exception from f1");
		}, EXECUTOR);

		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
			return result.incrementAndGet();
		}, EXECUTOR);

		CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> {
			return result.incrementAndGet();
		}, EXECUTOR);

		try {
			CompletableFuture.allOf(f1, f2, f3).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from f1"));
		}

	}
}
