package com.ke.test.lambda.model;

import lombok.Getter;
import lombok.experimental.Wither;

@Getter
@Wither
public class FrequencyCap {

	private static final String SEPARATOR = "/";

	private final String visit;
	private final String second;

	public FrequencyCap(String visit, String second) {
		this.visit = visit;
		this.second = second;
	}

	@Override
	public String toString() {
		return visit + SEPARATOR + second;
	}

}
