package com.ke.test.lambda.function;

import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.FrequencyCap;

public class VisitFunction2 implements Function<FrequencyCap, List<FrequencyCap>> {

	@Override
	public List<FrequencyCap> apply(FrequencyCap t) {
		List<FrequencyCap> visits = Lists.newArrayList();
		for (int i = 0; i < 3000; i++) {
			visits.add(t.withVisit(String.valueOf(i)));
		}
		return visits;
	}

}
