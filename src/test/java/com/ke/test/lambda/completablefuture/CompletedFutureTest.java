package com.ke.test.lambda.completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class CompletedFutureTest {

	@Test
	public void completedFutureTest() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completedFutrue = CompletableFuture.completedFuture("It is completed");
		assertThat(completedFutrue.isDone(), is(true));
		assertThat(completedFutrue.get(), is("It is completed"));
	}

}
