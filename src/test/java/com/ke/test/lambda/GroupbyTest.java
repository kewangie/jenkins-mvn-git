package com.ke.test.lambda;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import com.ke.test.lambda.model.Customer;

public class GroupbyTest {

	Customer customer1 = new Customer("customer1", "address1");
	Customer customer2 = new Customer("customer2", "address3");
	Customer customer3 = new Customer("customer3", "address2");
	Customer customer4 = new Customer("customer4", "address2");
	Customer customer5 = new Customer("customer5", "address1");
	Customer customer6 = new Customer("customer6", "address3");
	Customer customer7 = new Customer("customer7", "address2");
	Customer customer8 = new Customer("customer8", "address3");
	Customer customer9 = new Customer("customer9", "address3");

	@Test
	public void testGroupby() {

		Map<String, List<Customer>> customersByAddress = Stream.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
				customer8, customer9).collect(groupingBy(customer -> customer.getAddress()));

		assertThat(customersByAddress.get("address1").stream().map(Customer::getName).collect(toList()).toString(), is("[customer1, customer5]"));
		assertThat(customersByAddress.get("address2").stream().map(Customer::getName).collect(toList()).toString(),
				is("[customer3, customer4, customer7]"));
		assertThat(customersByAddress.get("address3").stream().map(Customer::getName).collect(toList()).toString(),
				is("[customer2, customer6, customer8, customer9]"));

	}

	@Test
	public void testCounting() {
		Map<String, Long> numberOfCustomersByAddress = Stream.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
				customer8, customer9).collect(groupingBy(customer -> customer.getAddress(), counting()));
		assertThat(numberOfCustomersByAddress.get("address1"), is(2l));
		assertThat(numberOfCustomersByAddress.get("address2"), is(3l));
		assertThat(numberOfCustomersByAddress.get("address3"), is(4l));
	}

	@Test
	public void testMapping() {
		Map<String, List<String>> customersNameByAddress = Stream.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
				customer8, customer9).collect(groupingBy(customer -> customer.getAddress(), mapping(Customer::getName, toList())));

		assertThat(customersNameByAddress.get("address1").toString(), is("[customer1, customer5]"));
		assertThat(customersNameByAddress.get("address2").toString(), is("[customer3, customer4, customer7]"));
		assertThat(customersNameByAddress.get("address3").toString(), is("[customer2, customer6, customer8, customer9]"));

	}
}
