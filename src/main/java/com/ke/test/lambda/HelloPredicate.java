package com.ke.test.lambda;

import java.util.function.Predicate;

public class HelloPredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return t.contains("Hello");
	}

}
