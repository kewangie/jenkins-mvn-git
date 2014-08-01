package com.ke.test.lambda.model;

import lombok.Getter;

@Getter
public class Customer {

	private final String name;
	private final String address;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

}
