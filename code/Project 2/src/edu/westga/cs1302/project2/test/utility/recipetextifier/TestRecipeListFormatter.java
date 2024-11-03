package edu.westga.cs1302.project2.test.utility.recipetextifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.utility.RecipeTextifier;

public class TestRecipeListFormatter {

	@Test
	public void testWhenListIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{RecipeTextifier.recipeListFormatter(null);});
	}
	
	@Test
	public void testWhenListHasOneRecipe() {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("A");
		Ingredient ingredient = new Ingredient("B", "C");
		Ingredient ingredient2 = new Ingredient("D", "E");
		
		recipe.addItem(ingredient);
		recipe.addItem(ingredient2);
		recipeList.add(recipe);
		
		String result = RecipeTextifier.recipeListFormatter(recipeList);
		
		String expected = "A" + System.lineSeparator()
							+ "B" + ", " + "C" + ", "
							+ "D" + ", " + "E" + ", "
							+ System.lineSeparator();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testWhenListHasMoreThanOneRecipe() {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("A");
		Ingredient ingredient = new Ingredient("B", "C");
		Ingredient ingredient2 = new Ingredient("D", "E");
		Recipe recipe1 = new Recipe("1");
		Ingredient ingredient3 = new Ingredient("2", "3");
		Ingredient ingredient4 = new Ingredient("4", "5");
		
		recipe.addItem(ingredient);
		recipe.addItem(ingredient2);
		recipe1.addItem(ingredient3);
		recipe1.addItem(ingredient4);
		recipeList.add(recipe);
		recipeList.add(recipe1);
		
		String result = RecipeTextifier.recipeListFormatter(recipeList);
		
		String expected = "A" + System.lineSeparator()
							+ "B" + ", " + "C" + ", "
							+ "D" + ", " + "E" + ", "
							+ System.lineSeparator()
							+ "1" + System.lineSeparator()
							+ "2"+ ", " + "3" + ", "
							+ "4" + ", " + "5" + ", "
							+ System.lineSeparator();
		
		assertEquals(expected, result);
	}
}
