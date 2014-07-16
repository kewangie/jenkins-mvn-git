package com.ke.test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.Manifest;

public class ManifestReader {

	@SuppressWarnings("rawtypes")
	public void readManifest() throws IOException {

		// final java.util.jar.Manifest manifest = new java.util.jar.Manifest();
		// InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
		// manifest.read(inputStream);
		// final java.util.jar.Attributes attributes = manifest.getMainAttributes();
		// for (final Map.Entry attribute : attributes.entrySet()) {
		// System.out.println(attribute.getKey().toString() + ": " + attribute.getValue().toString());
		// }

		Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
		while (resources.hasMoreElements()) {
			URL file = resources.nextElement();
			System.out.println(file.getFile());
			try {
				Manifest manifest = new Manifest(file.openStream());
				final java.util.jar.Attributes attributes = manifest.getMainAttributes();
				for (final Map.Entry attribute : attributes.entrySet()) {
					System.out.println(attribute.getKey().toString() + ": " + attribute.getValue().toString());
				}
			} catch (IOException E) {

			}

		}
	}

}
