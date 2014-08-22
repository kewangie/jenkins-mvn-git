package com.ke.test.lambda.function;

import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

public class SecondFunction implements Function<String, List<String>> {

	@Override
	public List<String> apply(String t) {
		List<String> seconds = Lists.newArrayList();
		for (int i = 0; i < 3000; i++) {
			seconds.add(String.valueOf(i));
		}
		return seconds;
	}

}
