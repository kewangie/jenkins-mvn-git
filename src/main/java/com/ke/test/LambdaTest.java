package com.ke.test;

public class LambdaTest {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("Hello world two!");
			System.out.println("Hello world three!");
		}).start();

		System.out.println("Hello world!");
		System.out.println(intMethod((x, y) -> x + y, 5, 10));

	}

	public static int intMethod(TwoArgIntOperator operator, int x, int y) {
		return operator.op(x, y);
	}
}
