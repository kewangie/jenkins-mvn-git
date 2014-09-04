package com.ke.test.xml;

import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ke.test.xml.model.Animal;
import com.ke.test.xml.model.FoodRecipe;
import com.ke.test.xml.model.Inventory;

public class TestJAXBMarshall {

	public static void main(String[] args) throws JAXBException {
		Inventory inventory = new Inventory();
		FoodRecipe recipe = new FoodRecipe();
		recipe.name = "Gorilla Chow";
		recipe.ingredient.addAll(Arrays.asList("leaves", "insects", "fruit"));
		Animal animal = new Animal(Animal.AnimalClass.mammal, "Song Fang", "Giant Panda", "China", "Bamboo", "Friendly", 45.0, recipe);
		inventory.animal.add(animal);

		marshall(inventory);
	}

	public static void marshall(Object jaxbObject) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(jaxbObject, System.out);
	}

}
