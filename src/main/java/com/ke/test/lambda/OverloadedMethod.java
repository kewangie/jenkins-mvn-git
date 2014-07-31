package com.ke.test.lambda;

import java.util.function.BinaryOperator;

public class OverloadedMethod {

	public String overloadedMethod(BinaryOperator<Integer> lambda) {
		return "BinaryOperator";
	}

	public String overloadedMethod(IntegerBiFunction lambda) {
		return "IntegerBinaryOperator";
	}

}
