package com.ke.test.lambda.template;

import org.junit.Test;

public class TemplateTest {

	@Test
	public void templateTest() {
		WorkflowManager manager = new WorkflowManagerImpl();
		manager.doTasks();
	}

	@Test
	public void templateTestLabda() {
		WorkflowManager manager = () -> System.out.println("Java 8 Lambda is Doing Task 2...");
		manager.doTasks();
	}

}
