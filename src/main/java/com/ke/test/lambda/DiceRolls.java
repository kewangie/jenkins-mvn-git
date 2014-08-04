package com.ke.test.lambda;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import lombok.core.Main;

public class DiceRolls {

	private static final int N = 100000000;

	public static void main(String[] ignore) throws IOException {
		final String[] args = { ".*DiceRolls.*", "-wi", "5", "-i", "5" };
		Main.main(args);
	}

	public Map<Integer, Double> serialDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream.range(0, N).mapToObj(twoDiceThrows()).collect(groupingBy(side -> side, summingDouble(n -> fraction)));
	}

	public Map<Integer, Double> parallelDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream.range(0, N) // <1>
				.parallel() // <2>
				.mapToObj(twoDiceThrows()) // <3>
				.collect(groupingBy(side -> side, // <4>
						summingDouble(n -> fraction))); // <5>
	}

	private static IntFunction<Integer> twoDiceThrows() {
		return i -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			int firstThrow = random.nextInt(1, 7);
			int secondThrow = random.nextInt(1, 7);
			return firstThrow + secondThrow;
		};
	}

}
