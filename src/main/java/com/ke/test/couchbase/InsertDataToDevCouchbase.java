package com.ke.test.couchbase;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.couchbase.client.CouchbaseClient;
import com.google.common.collect.Maps;

public class InsertDataToDevCouchbase {

	public static void main(String[] args) throws Exception {

		List<URI> hosts = Arrays.asList(new URI("http://m-dev-lana-qn07.advertising.aol.com:8091/pools"));

		String bucket = "couchbase_bucket";

		String password = "aVZsfnuAGTTL8";

		String versiondeKey = "{\"key\":\"deal_volume_estimate\",\"version\":2}";

		CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);

		Map<Long, Map<String, BigDecimal>> rtbMap = Maps.newHashMap();

		Map<String, BigDecimal> dealIdsMap = Maps.newHashMap();

		dealIdsMap.put("deal_1", BigDecimal.valueOf(0.2));
		dealIdsMap.put("deal_2", BigDecimal.valueOf(0.1));
		dealIdsMap.put("deal_3", BigDecimal.valueOf(0.2));

		rtbMap.put(1617L, dealIdsMap);

		client.set("deal_volume_estimate", versiondeKey).get();
		client.set(versiondeKey, rtbMap).get();

		client.shutdown();

	}
}
