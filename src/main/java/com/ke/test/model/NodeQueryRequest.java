package com.ke.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Wither;

import com.google.common.collect.ImmutableList;

@Getter
@AllArgsConstructor
@Wither
public class NodeQueryRequest {

	private final String name;
	private final Boolean returnZeroResults;
	private final ImmutableList<NodeQueryRequest> multiple;

}
