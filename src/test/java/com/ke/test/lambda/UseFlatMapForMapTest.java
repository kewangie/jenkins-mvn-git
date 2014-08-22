package com.ke.test.lambda;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class UseFlatMapForMapTest {

	@Test
	public void useFlatMapForMapTest() {
		Map<String, Map<Integer, Integer>> data = Maps.newHashMap();

		Map<Integer, Integer> intMap1 = Maps.newHashMap();
		intMap1.put(1, 11);
		intMap1.put(2, 22);
		intMap1.put(3, 33);
		data.put("intMap1", intMap1);

		Map<Integer, Integer> intMap2 = Maps.newHashMap();
		intMap2.put(4, 44);
		intMap2.put(5, 55);
		intMap2.put(6, 66);

		data.put("intMap2", intMap2);

		data.values().stream().flatMap(it -> it.entrySet().stream()).forEach((entry) -> {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		});
	}
}
