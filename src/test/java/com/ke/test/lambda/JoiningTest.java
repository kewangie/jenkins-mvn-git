package com.ke.test.lambda;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.ke.test.lambda.model.Customer;

public class JoiningTest {

	private static String EXPECTED_RESULT = "[customer1, customer2, customer3]";

	private Customer customer1 = new Customer("customer1", "address1");
	private Customer customer2 = new Customer("customer2", "address3");
	private Customer customer3 = new Customer("customer3", "address2");

	List<Customer> customers;

	@Before
	public void setUp() {
		customers = Lists.newArrayList(customer1, customer2, customer3);
	}

	@Test
	public void testJoining() {
		String result = customers.stream().map(Customer::getName).collect(joining(", ", "[", "]"));
		assertThat(result, is(EXPECTED_RESULT));
	}

	@Test
	public void testJava7() {
		StringBuilder builder = new StringBuilder("[");
		for (Customer customer : customers) {
			if (builder.length() > 1)
				builder.append(", ");

			String name = customer.getName();
			builder.append(name);
		}
		builder.append("]");
		String result = builder.toString();

		assertThat(result, is(EXPECTED_RESULT));

	}

	@Test
	public void testForEach() {
		StringBuilder builder = new StringBuilder("[");
		customers.stream().map(Customer::getName).forEach(name -> {
			if (builder.length() > 1)
				builder.append(", ");

			builder.append(name);
		});
		builder.append("]");
		String result = builder.toString();
		assertThat(result, is(EXPECTED_RESULT));
	}

	@Test
	public void testReduce() {

		StringBuilder reduced = customers.stream().map(Customer::getName).reduce(new StringBuilder(), (builder, name) -> {
			if (builder.length() > 0) {
				builder.append(", ");
			}
			builder.append(name);
			return builder;
		}, (left, right) -> left.append(right));

		reduced.insert(0, "[");
		reduced.append("]");
		String result = reduced.toString();
		assertThat(result, is(EXPECTED_RESULT));
	}

	@Test
	public void testStringCombiner() {

		String result = customers.stream().map(Customer::getName)
				.reduce(new StringCombiner(", ", "[", "]"), StringCombiner::add, StringCombiner::merge).toString();

		assertThat(result, is(EXPECTED_RESULT));

	}

	@Test
	public void testStringCollector() {
		String result = customers.stream().map(Customer::getName).collect(new StringCollector(", ", "[", "]"));
		assertThat(result, is(EXPECTED_RESULT));
	}

}
