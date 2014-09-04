package com.ke.test.xml.model;

import java.util.ArrayList;
import java.util.List;

public class FoodRecipe {

	public String name;
	public List<String> ingredient = new ArrayList<String>();

	public String toString() {
		return name + ": " + ingredient.toString();
	}

}
