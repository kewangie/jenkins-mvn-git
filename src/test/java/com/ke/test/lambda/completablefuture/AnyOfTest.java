package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class AnyOfTest {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
	private static volatile String result;

	@AfterClass
	public static void cleanUp() {
		EXECUTOR.shutdown();
	}

	@Test
	public void anyOfTest() {

		CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
			result = "f1";
		}, EXECUTOR);

		CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {

			}
			result = "f2";
		}, EXECUTOR);

		CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(2000l);
			} catch (Exception e) {

			}
			result = "f3";
		}, EXECUTOR);

		CompletableFuture.anyOf(f1, f2, f3).join();

		assertThat(result, is("f1"));
	}

	@Test
	public void anyOfExceptionTest() {

		CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
			throw new RuntimeException("Exception from f1");
		}, EXECUTOR);

		CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {

			}
			result = "f2";
		}, EXECUTOR);

		CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(2000l);
			} catch (Exception e) {

			}
			result = "f3";
		}, EXECUTOR);

		try {
			CompletableFuture.anyOf(f1, f2, f3).join();
		} catch (Exception e) {
			assertThat(e.getCause().getMessage(), is("Exception from f1"));
		}

	}

	@Test
	public void anyOfQuickestWinsTest() {

		CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(2000l);
			} catch (Exception e) {

			}
			throw new RuntimeException("Exception from f1");
		}, EXECUTOR);

		CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
			result = "f2";
		}, EXECUTOR);

		CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(2000l);
			} catch (Exception e) {

			}
			result = "f3";
		}, EXECUTOR);

		CompletableFuture.anyOf(f1, f2, f3).join();
		assertThat(result, is("f2"));
	}
}
