package com.ke.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
	
	private HelloWorld helloWorld;
	
	@Before
	public void setUp() {
		helloWorld = new HelloWorld();
	}
	
	@Test
	public void testSayHelloToTheWorld() {
		assertThat(helloWorld.sayHelloToTheWorld(), is("Hello World xxx"));				
	}

}
