package com.ke.test.lambda;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import com.google.common.collect.Maps;

public class PriceRoundingServiceDriver {

	public static void main(String[] args) {

		Random random = new Random();

		Map<BigDecimal, BigDecimal> coefficients = Maps.newHashMap();
		for (int i = 0; i < 1000000; i++) {
			coefficients.put(new BigDecimal(Math.abs(random.nextLong())), new BigDecimal(Math.abs(random.nextLong())));
		}

		BigDecimal price = new BigDecimal(Math.abs(random.nextLong()));

		getCoefficientUsingEntrySet(price, coefficients);
		getCoefficientUsingEntrySetLimit(price, coefficients);
		getCoefficientUsingEntrySet(price, coefficients);
		getCoefficientUsingEntrySetLimit(price, coefficients);
		getCoefficientUsingEntrySet(price, coefficients);
		getCoefficientUsingKeySet(price, coefficients);
		getCoefficientUsingKeySet(price, coefficients);
		getCoefficientUsingEntrySetLimit(price, coefficients);
		getCoefficientUsingKeySet(price, coefficients);

		long startTime1 = System.currentTimeMillis();
		Optional<BigDecimal> value1 = getCoefficientUsingEntrySet(price, coefficients);
		long finishTime1 = System.currentTimeMillis() - startTime1;
		System.out.println("getCoefficientUsingEntrySet: " + finishTime1);

		long startTime2 = System.currentTimeMillis();
		Optional<BigDecimal> value2 = getCoefficientUsingKeySet(price, coefficients);
		long finishTime2 = System.currentTimeMillis() - startTime2;
		System.out.println("getCoefficientUsingKeySet: " + finishTime2);

		long startTime3 = System.currentTimeMillis();
		Optional<BigDecimal> value3 = getCoefficientUsingEntrySetLimit(price, coefficients);
		long finishTime3 = System.currentTimeMillis() - startTime3;
		System.out.println("getCoefficientUsingEntrySetLimit: " + finishTime3);
	}

	private static Optional<BigDecimal> getCoefficientUsingEntrySet(BigDecimal price, Map<BigDecimal, BigDecimal> coefficients) {

		if (isNegativePrice(price)) {
			return Optional.empty();
		}

		BigDecimal result = coefficients.get(price);
		if (result != null) {
			return Optional.of(result);
		}

		return coefficients.entrySet().stream().filter(e -> e.getKey().compareTo(price) == 1).sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.map(e -> e.getValue()).findFirst();

	}

	private static Optional<BigDecimal> getCoefficientUsingEntrySetLimit(BigDecimal price, Map<BigDecimal, BigDecimal> coefficients) {

		if (isNegativePrice(price)) {
			return Optional.empty();
		}

		BigDecimal result = coefficients.get(price);
		if (result != null) {
			return Optional.of(result);
		}

		Optional<Entry<BigDecimal, BigDecimal>> entry = coefficients.entrySet().stream().filter(e -> e.getKey().compareTo(price) == 1)
				.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).findFirst();

		if (entry.isPresent()) {
			return Optional.ofNullable(entry.get().getValue());
		}

		return Optional.empty();

	}

	public static Optional<BigDecimal> getCoefficientUsingKeySet(BigDecimal price, Map<BigDecimal, BigDecimal> coefficients) {

		if (isNegativePrice(price)) {
			return Optional.empty();
		}

		BigDecimal result = coefficients.get(price);
		if (result != null) {
			return Optional.of(result);
		}

		Optional<BigDecimal> nextAvailablePrice = coefficients.keySet().stream().filter(availablePrice -> availablePrice.compareTo(price) == 1)
				.sorted().findFirst();

		if (nextAvailablePrice.isPresent()) {
			return Optional.ofNullable(coefficients.get(nextAvailablePrice.get()));
		}

		return Optional.empty();
	}

	private static boolean isNegativePrice(BigDecimal price) {
		return price.signum() == -1;
	}

}
