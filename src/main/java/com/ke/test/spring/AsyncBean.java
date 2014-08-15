package com.ke.test.spring;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncBean {

	@Async
	public Future<String> hello() {
		return CompletableFuture.completedFuture("Hello");
	}

}
