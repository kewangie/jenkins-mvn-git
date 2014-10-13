package com.ke.test.lambda;

import java.util.stream.Stream;

import org.junit.Test;

public class DebugTest {

	@Test
	public void testDebug() {

		//		List<Integer> list1 = Stream.of(1, 2, 3, 4, 5, 6, 7).filter(x -> x > 3)
		//				.peek(x -> System.out.println("Found an integer which is greater than three: " + x)).map(x -> x + 8).collect(Collectors.toList());

		//		Stream.of(1, 2, 3, 4, 5, 6, 7).filter(x -> {
		//			System.out.println("Found an integer which is greater than three: " + x);
		//			return x > 3;
		//		}).map(x -> {
		//			int retsult = x + 8;
		//			System.out.println(retsult);
		//			return retsult;
		//		}).peek(x -> System.out.println(x)).collect(Collectors.toList());

		//assertThat(list1.toString(), is("[12, 13, 14, 15]"));

		//		List<Integer> list2 = Lists.newArrayList();
		//		for (int i = 1; i < 8; i++) {
		//			if (i > 3) {
		//				System.out.println("Found an integer which is greater than three: " + i);
		//				list2.add(i + 8);
		//			}
		//		}

		//		Stream.of(1, 2, 3, 4, 5, 6, 7).filter(x -> {
		//			System.out.println("Found an integer which is greater than three: " + x);
		//			return x > 3;
		//		}).map(x -> {
		//			int retsult = x + 8;
		//			System.out.println(retsult);
		//			return retsult;
		//		}).peek(x -> System.out.println(x)).collect(Collectors.toList());

		//		List<Integer> list1 = Stream.of(1, 2, 3).map(x -> {
		//			int result = x + 3;
		//			System.out.println("Stream elements after plus three: " + result);
		//			return result;
		//		}).collect(Collectors.toList());
		//
		//		List<Integer> list2 = list1.stream().filter(x -> {
		//			if (x > 4) {
		//				System.out.println("Stream elements greater than four: " + x);
		//				return true;
		//			}
		//			return false;
		//		}).collect(Collectors.toList());

		//		int firstGreaterThanFour = list2.stream().findFirst().get();
		//		System.out.println("firstGreaterThanFour: " + firstGreaterThanFour);

		//		int firstGreaterThanFour = Stream.of(9, 3, 6).map(x -> {
		//			int result = x + 3;
		//			System.out.println("Stream elements after plus three: " + result);
		//			return result;
		//		}).filter(x -> {
		//			if (x > 4) {
		//				System.out.println("Stream elements greater than four: " + x);
		//				return true;
		//			}
		//			return false;
		//		}).findFirst().get();

		int firstGreaterThanFour = Stream.of(1, 2, 3).map(x -> x + 3).peek(x -> System.out.println("Stream elements after plus three: " + x))
				.filter(x -> x > 4).peek(x -> System.out.println("Stream elements greater than four: " + x)).findFirst().get();

		System.out.println("firstGreaterThanFour: " + firstGreaterThanFour);

	}
}
