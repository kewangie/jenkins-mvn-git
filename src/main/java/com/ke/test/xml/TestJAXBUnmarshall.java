package com.ke.test.xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ke.test.xml.model.Animal;
import com.ke.test.xml.model.FoodRecipe;
import com.ke.test.xml.model.Inventory;

public class TestJAXBUnmarshall {

	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Inventory.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(null); //No Schema
		Inventory inventory = (Inventory) unmarshaller.unmarshal(new File("zooinventory.xml"));
		System.out.println("Animals = ");
		List<Animal> animals = inventory.animal;
		for (Animal animal : animals)
			System.out.println("\t" + animal.name);
		Animal fang = inventory.animal.get(1);
		FoodRecipe recipe = fang.foodRecipe;
		System.out.println("Recipe = " + recipe.name);
		for (String ingredient : recipe.ingredient)
			System.out.println("\t" + ingredient);
	}

}
