package com.ke.test.couchbase;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;
import com.ke.test.couchbase.model.FrequencyCap;

public class ReadData {

	public static void main(String[] args) throws Exception {

		// (Subset) of nodes in the cluster to establish a connection
		List<URI> hosts = Arrays.asList(new URI("http://127.0.0.1:8091/pools"));

		// Name of the Bucket to connect to
		String bucket = "default";

		// Password of the bucket (empty) string if none
		String password = "";

		// Connect to the Cluster
		CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);

		View view = client.getView("fcap", "all_keys");
		Query query = new Query();
		query.setIncludeDocs(true);

		ViewResponse result = client.query(view, query);

		Gson gson = new Gson();
		for (ViewRow row : result) {
			if (row.getId().contains("FrequencyCap")) {
				FrequencyCap frequencyCap = gson.fromJson((String) row.getDocument(), FrequencyCap.class);
				System.out.println(frequencyCap.getCoefficient());
				System.out.println(row.getId());
			}
		}

		client.shutdown();
	}

}
