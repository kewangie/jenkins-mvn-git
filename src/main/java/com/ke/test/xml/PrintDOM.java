package com.ke.test.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class PrintDOM {

	public static void main(String[] args) throws Exception {
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = parser.parse(new InputSource("zooinventory.xml"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source source = new DOMSource(document);
		Result output = new StreamResult(System.out);
		transformer.transform(source, output);
	}

}
