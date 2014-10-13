package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

public class PredictTest {

	private Predicate<String> sayHello = (x) -> {
		return x.contains("Hello");
	};

	//private Predicate<String> sayHello = PredictTest::isContainHello;

	//	private Predicate<String> sayHello = new Predicate<String>() {
	//		@Override
	//		public boolean test(String t) {
	//			return t.contains("Hello");
	//		}
	//	};

	//	public boolean isContainHello(String t) {
	//		return t.contains("Hello");
	//	}

	public static boolean isContainHello(String t) {
		return t.contains("Hello");
	}

	//Predicate<String> sayHello = new HelloPredicate();

	@Test
	public void predicateTestTrue() {
		assertThat(sayHello.test("Hello Ke"), is(true));
	}

	@Test
	public void predicateTestFalse() {
		assertThat(sayHello.test("Very good, Ke"), is(false));
	}

	@Test
	public void testPredicateList1() {

		List<String> filteredList = Stream.of("Hello Ke", "Hello Marco", "Very good, Ke").filter(sayHello).collect(Collectors.toList());

		assertThat(filteredList.toString(), is("[Hello Ke, Hello Marco]"));

	}

	@Test
	public void testPredicateList2() {

		List<String> filteredList = Stream.of("Hello Ke", "Hello Marco", "Very good, Ke").filter(x -> x.contains("Hello"))
				.collect(Collectors.toList());

		assertThat(filteredList.toString(), is("[Hello Ke, Hello Marco]"));

	}

	@Test
	public void testPredicateLoop() {
		List<String> list = Lists.newArrayList("Hello Ke", "Hello Marco", "Very good, Ke");
		List<String> filteredList = Lists.newArrayList();
		for (String element : list) {
			if (element.contains("Hello")) {
				filteredList.add(element);
			}
		}
		assertThat(filteredList.toString(), is("[Hello Ke, Hello Marco]"));
	}
}
