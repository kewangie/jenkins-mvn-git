package com.ke.test.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.ke.test.xml.model.Animal;
import com.ke.test.xml.model.FoodRecipe;
import com.ke.test.xml.model.Inventory;

public class TestSAXModelBuilder {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		XMLReader parser = saxParser.getXMLReader();
		SAXModelBuilder mb = new SAXModelBuilder();
		parser.setContentHandler(mb);

		parser.parse(new InputSource("zooinventory.xml"));
		Inventory inventory = (Inventory) mb.getModel();
		System.out.println("Animals = " + inventory.animal);
		Animal cocoa = (Animal) (inventory.animal.get(1));
		FoodRecipe recipe = cocoa.foodRecipe;
		System.out.println("Recipe = " + recipe);
	}

}
