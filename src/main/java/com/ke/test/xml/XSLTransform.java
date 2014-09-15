package com.ke.test.xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.TransformerFactoryImpl;

public class XSLTransform {

	public static void main(String[] args) throws Exception {

		String xslFile = "/Users/kewang/Downloads/XSLT-2-0-and-XPath-2-0-Programmer/ch02/books.xsl";
		String xmlFile = "/Users/kewang/Downloads/XSLT-2-0-and-XPath-2-0-Programmer/ch02/books.xml";

		TransformerFactory factory = new TransformerFactoryImpl();
		Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
		StreamSource xmlsource = new StreamSource(xmlFile);
		StreamResult output = new StreamResult(System.out);
		transformer.transform(xmlsource, output);
	}

}
