package edu.westga.cs1302.project2.utility;

import java.util.ArrayList;
import java.util.List;

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
	    
	    StringBuilder text = new StringBuilder(recipe.getName() + System.lineSeparator());
	    List<Ingredient> ingredients = recipe.getIngredients();
	    
	    for (int index = 0; index < ingredients.size(); index++) {
	        Ingredient ingredient = ingredients.get(index);
	        if (ingredient != null) {
	            text.append(ingredient.getName()).append(", ").append(ingredient.getType());
	            if (index < ingredients.size() - 1) {
	                text.append(", ");
	            }
	        }
	    }
	    
	    return text.toString();
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
