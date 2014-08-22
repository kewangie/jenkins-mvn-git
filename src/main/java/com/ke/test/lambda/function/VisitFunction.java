package com.ke.test.lambda.function;

import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

public class VisitFunction implements Function<String, List<String>> {

	@Override
	public List<String> apply(String t) {
		List<String> visits = Lists.newArrayList();
		for (int i = 0; i < 3000; i++) {
			visits.add(String.valueOf(i));
		}
		return visits;
	}

}
