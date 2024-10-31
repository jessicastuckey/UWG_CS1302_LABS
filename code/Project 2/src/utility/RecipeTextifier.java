package utility;

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
	 * @precondition none
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
}
