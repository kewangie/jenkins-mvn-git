package com.ke.test.couchbase;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import com.couchbase.client.CouchbaseClient;

public class LockTest2 {

	private CouchbaseClient client;

	@Before
	public void setUp() throws Exception {

		List<URI> hosts = Arrays.asList(new URI("http://127.0.0.1:8091/pools"));
		String bucket = "default";
		String password = "";
		client = new CouchbaseClient(hosts, bucket, password);
	}

	// @Test
	public void testLock() throws InterruptedException {

		client.getAndLock("1-1-3600-0.01", 0);
		while (true) {
			System.out.println("Hello From LockTest2");
			Thread.sleep(2000l);
		}

	}

}
