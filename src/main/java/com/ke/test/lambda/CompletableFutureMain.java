package com.ke.test.lambda;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		final CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return "5";
			// throw new RuntimeException("hahaha");
			}, EXECUTOR);

		CompletableFuture<Integer> f2 = f1.thenApply(stringValue -> {
			System.out.println(Thread.currentThread().getName());
			return Integer.parseInt(stringValue);
		});

		// CompletableFuture<Double> f3 = f2.thenApply(r -> {
		// System.out.println(Thread.currentThread().getName());
		// return r * r * Math.PI;
		// });
		//
		// f3.thenAcceptAsync(db -> {
		// System.out.println(Thread.currentThread().getName());
		// System.out.println(db);
		// }, EXECUTOR);
		//
		// CompletableFuture<Integer> safe = f1.handle((ok, ex) -> {
		// if (ok != null) {
		// System.out.println(Thread.currentThread().getName());
		// return Integer.parseInt(ok);
		// } else {
		// System.out.println("Problem: " + ex.getMessage());
		// return -1;
		// }
		// });

		EXECUTOR.shutdown();

	}
}
