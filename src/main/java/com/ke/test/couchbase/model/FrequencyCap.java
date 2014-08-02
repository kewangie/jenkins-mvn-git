package com.ke.test.couchbase.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FrequencyCap implements Serializable {

	private static final long serialVersionUID = 1L;

	private final long adserviceId;
	private final int visits;
	private final long seconds;
	private final BigDecimal price;
	private final BigDecimal coefficient;

	public String getKey() {
		return "FrequencyCap-" + adserviceId + "-" + visits + "-" + seconds + "-" + price.toString();
	}

}
