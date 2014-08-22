package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.ke.test.lambda.function.SecondFunction;
import com.ke.test.lambda.function.SecondFunction2;
import com.ke.test.lambda.function.VisitFunction;
import com.ke.test.lambda.function.VisitFunction2;
import com.ke.test.lambda.model.FrequencyCap;

public class ParallelStreamForStreamMultiplyTest {

	private static final String SEPARATOR = "/";

	@Before
	public void setUp() {
		useNestedLoop();
		useSingleLoop();
		useSingleLoopParallel();
	}

	@Test
	public void testParallelStream() {
		long start = System.currentTimeMillis();
		assertThat(useNestedLoop(), is(9000000));
		System.out.println("useNestedLoop: " + (System.currentTimeMillis() - start));

		long start2 = System.currentTimeMillis();
		assertThat(useSingleLoop(), is(9000000));
		System.out.println("useSingleLoop: " + (System.currentTimeMillis() - start2));

		long start3 = System.currentTimeMillis();
		assertThat(useSingleLoopParallel(), is(9000000));
		System.out.println("useSingleLoopParallel: " + (System.currentTimeMillis() - start3));

		long start5 = System.currentTimeMillis();
		assertThat(useNestedLoop(), is(9000000));
		System.out.println("useNestedLoop: " + (System.currentTimeMillis() - start5));

		long start4 = System.currentTimeMillis();
		assertThat(useSingleLoop(), is(9000000));
		System.out.println("useSingleLoop: " + (System.currentTimeMillis() - start4));

		long start6 = System.currentTimeMillis();
		assertThat(useSingleLoopParallel(), is(9000000));
		System.out.println("useSingleLoopParallel: " + (System.currentTimeMillis() - start6));

	}

	public int useNestedLoop() {
		List<String> results = Lists.newArrayList();
		Stream.of("a").map((it) -> {
			return new VisitFunction().apply(it);
		}).flatMap(it -> it.stream()).forEach((visit) -> {
			Stream.of("a").map((it) -> {
				return new SecondFunction().apply(it);
			}).flatMap(it -> it.stream()).forEach((second) -> {
				results.add(visit + SEPARATOR + second);
			});
		});
		return results.size();
	}

	public int useSingleLoop() {
		List<String> results = Lists.newArrayList();
		Stream.of(new FrequencyCap(null, null)).map((it) -> {
			return new VisitFunction2().apply(it);
		}).flatMap(it -> it.stream()).map((it) -> {
			return new SecondFunction2().apply(it);
		}).flatMap(it -> it.stream()).forEach(it -> results.add(it.toString()));
		return results.size();
	}

	public int useSingleLoopParallel() {
		List<String> results = Lists.newArrayList();

		Stream.of(new FrequencyCap(null, null)).map((it) -> {
			return new VisitFunction2().apply(it);
		}).flatMap(it -> it.stream()).parallel().map((it) -> {
			return new SecondFunction2().apply(it);
		}).flatMap(it -> it.stream()).parallel().forEach(it -> results.add(it.toString()));
		return results.size();
	}
}
