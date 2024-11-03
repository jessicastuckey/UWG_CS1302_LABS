package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

public class TestAddItem {

	@Test
	public void testWhenIngredientIsNull() {
		Recipe recipe = new Recipe("Chicken Sandwich");
		
		assertThrows(IllegalArgumentException.class, ()->{recipe.addItem(null);});
	}
	
	@Test
	public void testAddingOneIngredient() {
		Recipe recipe = new Recipe("Chicken Sandwich");
		Ingredient ingredient = new Ingredient("Chicken", "Meat");
		
		recipe.addItem(ingredient);
		Ingredient firstItem = recipe.getIngredients().get(0);
		
		assertEquals("Chicken", firstItem.getName());
		assertEquals("Meat", firstItem.getType());
	}
	
	@Test
	public void testAddingMultipleIngredients() {
		Recipe recipe = new Recipe("Chicken Sandwich");
		Ingredient ingredient = new Ingredient("Chicken", "Meat");
		Ingredient ingredient2 = new Ingredient("Mayonnaise", "Condiment");
		Ingredient ingredient3 = new Ingredient("Bread", "Bread");
		
		recipe.addItem(ingredient);
		recipe.addItem(ingredient2);
		recipe.addItem(ingredient3);
		Ingredient firstItem = recipe.getIngredients().get(0);
		Ingredient secondItem = recipe.getIngredients().get(1);
		Ingredient thirdItem = recipe.getIngredients().get(2);
		
		assertEquals("Chicken", firstItem.getName());
		assertEquals("Meat", firstItem.getType());
		assertEquals("Mayonnaise", secondItem.getName());
		assertEquals("Condiment", secondItem.getType());
		assertEquals("Bread", thirdItem.getName());
		assertEquals("Bread", thirdItem.getType());

	}

}
