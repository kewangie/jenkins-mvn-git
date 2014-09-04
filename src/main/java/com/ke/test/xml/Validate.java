package com.ke.test.xml;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Validate {

	public static void main(String[] args) throws Exception {

		String xsdfile = "zooinventory.xsd";

		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new StreamSource(xsdfile));
		Validator validator = schema.newValidator();

		ErrorHandler errHandler = new ErrorHandler() {
			public void error(SAXParseException e) {
				System.out.println(e);
			}

			public void fatalError(SAXParseException e) {
				System.out.println(e);
			}

			public void warning(SAXParseException e) {
				System.out.println(e);
			}
		};
		validator.setErrorHandler(errHandler);

		try {
			validator.validate(new SAXSource(new InputSource("zooinventory.xml")));
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}
	}
}
