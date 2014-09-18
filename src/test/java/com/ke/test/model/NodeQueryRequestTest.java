package com.ke.test.model;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class NodeQueryRequestTest {

	@Test
	public void nodeQueryRequestTest() {

		NodeQueryRequest level31 = new NodeQueryRequest("level31", true, ImmutableList.of());
		NodeQueryRequest level32 = new NodeQueryRequest("level32", true, ImmutableList.of());
		NodeQueryRequest level33 = new NodeQueryRequest("level33", true, ImmutableList.of());

		NodeQueryRequest level34 = new NodeQueryRequest("level34", true, ImmutableList.of());
		NodeQueryRequest level35 = new NodeQueryRequest("level35", true, ImmutableList.of());

		NodeQueryRequest level21 = new NodeQueryRequest("level21", true, ImmutableList.of(level34, level35));
		NodeQueryRequest level22 = new NodeQueryRequest("level22", true, ImmutableList.of(level31, level32, level33));

		NodeQueryRequest root = new NodeQueryRequest("root", true, ImmutableList.of(level21, level22));

		dftPrint(root);

		NodeQueryRequest newRoot = dftChangeFlagToFalse(root);

		dftPrint(newRoot);
	}

	private void dftPrint(NodeQueryRequest root) {
		System.out.println(root.getName() + ": " + root.getReturnZeroResults());
		root.getMultiple().forEach((child) -> dftPrint(child));
	}

	private NodeQueryRequest dftChangeFlagToFalse(NodeQueryRequest root) {

		List<NodeQueryRequest> children = Lists.newArrayList();

		root.getMultiple().forEach((child) -> {
			children.add(dftChangeFlagToFalse(child));
		});

		return root.withMultiple(ImmutableList.copyOf(children)).withReturnZeroResults(false);

	}
}
