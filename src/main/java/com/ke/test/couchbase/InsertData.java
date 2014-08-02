package com.ke.test.couchbase;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.couchbase.client.CouchbaseClient;
import com.google.gson.Gson;
import com.ke.test.couchbase.model.FrequencyCap;

public class InsertData {

	public static void main(String[] args) throws Exception {

		// (Subset) of nodes in the cluster to establish a connection
		List<URI> hosts = Arrays.asList(new URI("http://127.0.0.1:8091/pools"));

		// Name of the Bucket to connect to
		String bucket = "default";

		// Password of the bucket (empty) string if none
		String password = "";

		// Connect to the Cluster
		CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);

		FrequencyCap cap1 = new FrequencyCap(1l, 1, 3600l, new BigDecimal("0.01"), new BigDecimal("0.000879"));
		FrequencyCap cap2 = new FrequencyCap(1l, 1, 7200l, new BigDecimal("0.02"), new BigDecimal("0.000899"));
		FrequencyCap cap3 = new FrequencyCap(1l, 2, 3600l, new BigDecimal("0.01"), new BigDecimal("0.006879"));
		FrequencyCap cap4 = new FrequencyCap(17l, 1, 3600l, new BigDecimal("0.01"), new BigDecimal("0.003879"));
		FrequencyCap cap5 = new FrequencyCap(17l, 1, 7200l, new BigDecimal("0.02"), new BigDecimal("0.005879"));
		FrequencyCap cap6 = new FrequencyCap(17l, 2, 3600l, new BigDecimal("0.01"), new BigDecimal("0.001879"));

		Gson gson = new Gson();

		client.set(cap1.getKey(), gson.toJson(cap1)).get();
		client.set(cap2.getKey(), gson.toJson(cap2)).get();
		client.set(cap3.getKey(), gson.toJson(cap3)).get();
		client.set(cap4.getKey(), gson.toJson(cap4)).get();
		client.set(cap5.getKey(), gson.toJson(cap5)).get();
		client.set(cap6.getKey(), gson.toJson(cap6)).get();

		// Shutting down properly
		client.shutdown();

	}

}
