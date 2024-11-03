package edu.westga.cs1302.project2.utility;

import java.util.ArrayList;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

/**
 * Generates text for a recipe
 * 
 * @author js00547
 * @version Fall 2024
 */

public class RecipeTextifier {
	
	/**
	 * Return the recipe as a string.
	 * 
	 * @precondition recipe != null
	 * @postcondition none
	 * 
	 * @param recipe the recipe converted
	 * 
	 * @return a String summarizing the recipe
	 */
	public static String getText(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("Must provide a valid Recipe");
		}
		String text = recipe.getName() + System.lineSeparator();
		for (Ingredient ingredient : recipe.getIngredients()) {
			if (ingredient != null) {
				text += ingredient.getName() + ", " + ingredient.getType() + ", ";
			}
		}
	return text;
	}
	
	/**
	 * Return the list of recipes as a string.
	 * 
	 * @precondition recipes != null
	 * @postcondition none
	 * 
	 * @param recipes the list of recipes
	 * 
	 * @return recipesListText the list of recipes as a String
	 */

	public static String recipeListFormatter(ArrayList<Recipe> recipes) {
		if (recipes == null) {
			throw new IllegalArgumentException("Must provide a valid Recipe");
		}
		StringBuilder recipesListText = new StringBuilder();
		for (Recipe currentRecipe : recipes) {
			recipesListText.append(getText(currentRecipe));
			recipesListText.append(System.lineSeparator());
		}
		return recipesListText.toString();
	}
}
