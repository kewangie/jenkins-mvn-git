package com.ke.test.lambda.stratety;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.ke.test.lambda.strategy.Add3Strategy;
import com.ke.test.lambda.strategy.Add5Strategy;
import com.ke.test.lambda.strategy.AddStrategy;

public class StrategyTest {

	@Test
	public void testStragetyOldJava() {
		List<AddStrategy> strategies = Lists.newArrayList(new Add3Strategy(), new Add5Strategy());
		for (AddStrategy addStrategy : strategies) {
			System.out.println(addStrategy.add(8));
		}
	}

	@Test
	public void testStragetyJava8() {
		List<AddStrategy> strategies = Lists.newArrayList(x -> x + 3, x -> x + 5);
		for (AddStrategy addStrategy : strategies) {
			System.out.println(addStrategy.add(8));
		}
	}
}
