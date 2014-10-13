package com.ke.test.lambda.template;

public interface WorkflowManager {

	public default void doTasks() {
		doTask1();
		doTask2();
		doTask3();
	}

	public default void doTask1() {
		System.out.println("Doing Task1...");
	}

	public void doTask2();

	public default void doTask3() {
		System.out.println("Doing Task3...");
	}
}
