package edu.westga.cs1302.project2.test.utility.recipetextifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.utility.RecipeTextifier;

class TestGetText {

	@Test
	void testNullRecipe() {
		assertThrows(IllegalArgumentException.class, ()->{RecipeTextifier.getText(null);});
	}

	@Test
	void testBillWithNoItems() {
		Recipe recipe = new Recipe("a");
		
		String result = RecipeTextifier.getText(recipe);
		
		String expected = "a" + System.lineSeparator();
		
		assertEquals(expected, result);
	}

	@Test
	void testBillWithOneItem() {
		Recipe recipe = new Recipe("a");
		Ingredient item1 = new Ingredient("1", "2");
		recipe.addItem(item1);
		
		String result = RecipeTextifier.getText(recipe);

		String expected = "a" + System.lineSeparator() + "1" + ", " + "2" + ", ";
		
		assertEquals(expected, result);
	}
	
	@Test
	void testBillWithMultipleItems() {
		Recipe recipe = new Recipe("a");
		Ingredient item1 = new Ingredient("1", "2");
		recipe.addItem(item1);
		Ingredient item2 = new Ingredient("3", "4");
		recipe.addItem(item2);
		
		String result = RecipeTextifier.getText(recipe);

		String expected = "a" + System.lineSeparator()
				+ "1" + ", " + "2" + ", "
				+ "3" + ", " + "4" + ", ";
		
		assertEquals(expected, result);
	}
}
