package com.ke.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

	public void readProperties() throws IOException {

		Properties props = new Properties();

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test.txt");
		props.load(inputStream);

		System.out.println(props.get("hello"));
		System.out.println(props.get("world"));

	}

}
