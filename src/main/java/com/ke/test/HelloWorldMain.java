package com.ke.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class HelloWorldMain {

	public static void main(String[] args) throws IOException {

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();

		for (URL url : urls) {
			System.out.println(url.getFile());
		}

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current dir: " + workingDir);

	}
}
