package com.ke.test.lambda.function;

import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.FrequencyCap;

public class SecondFunction2 implements Function<FrequencyCap, List<FrequencyCap>> {

	@Override
	public List<FrequencyCap> apply(FrequencyCap t) {
		List<FrequencyCap> seconds = Lists.newArrayList();
		for (int i = 0; i < 3000; i++) {
			seconds.add(t.withSecond(String.valueOf(i)));
		}
		return seconds;
	}

}
