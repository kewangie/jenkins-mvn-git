package com.ke.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	// private static final LinkedBlockingQueue<Runnable> myQueue = new LinkedBlockingQueue<Runnable>();
	private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 5; i++) {
			EXECUTOR.submit(new Runnable() {
				@Override
				public void run() {
					while (true) {
						System.out.println("Hell From: " + Thread.currentThread().getName());
						try {
							Thread.sleep(1000l);
						} catch (InterruptedException e) {
						}
					}
				}
			});
		}

		while (true) {
			Thread.sleep(2000l);
			System.out.println("Queue size:" + EXECUTOR.getQueue().size());
			System.out.println("active count:" + EXECUTOR.getActiveCount());

		}
	}
}
