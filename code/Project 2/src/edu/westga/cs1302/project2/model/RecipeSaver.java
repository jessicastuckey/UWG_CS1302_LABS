package edu.westga.cs1302.project2.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import edu.westga.cs1302.project2.utility.RecipeTextifier;

/**
 * Supports saving and loading recipe data,
 * 
 * @author js00547
 * @version Fall 2024
 */
public class RecipeSaver {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Writes all recipe data to DATA_FILE
	 * 
	 * @precondition recipe != null
	 * @postcondition none
	 * 
	 * @param recipe the recipe to save
	 * @throws IOException
	 */
	public static void saveRecipeData(Recipe recipe) throws IOException {
		if (recipe == null) {
			throw new IllegalArgumentException("recipe cannot be null");
		}
		ArrayList<Recipe> recipeList = RecipeLoader.loadRecipeData();
		if (isDuplicateRecipe(recipeList, recipe)) {
			throw new IllegalStateException();
		}
		try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
			writer.write(RecipeTextifier.getText(recipe));
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}

	private static boolean isDuplicateRecipe(ArrayList<Recipe> recipeList, Recipe recipe) {
		for (Recipe currentRecipe : recipeList) {
			if (currentRecipe.getName().equals(recipe.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "CSV";
	}

}
