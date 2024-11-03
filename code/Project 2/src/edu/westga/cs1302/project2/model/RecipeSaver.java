package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileWriter;
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
	        throw new IllegalArgumentException("Recipe cannot be null");
	    }
	    
	    File dataFile = new File(RecipeSaver.DATA_FILE);
	    if (!dataFile.exists()) {
	        dataFile.createNewFile();
	    }

	    ArrayList<Recipe> recipeList = RecipeLoader.loadRecipeData();
	    if (isDuplicateRecipe(recipeList, recipe)) {
	        throw new IllegalStateException("Duplicate recipe: " + recipe.getName());
	    }

	    try (FileWriter fileWriter = new FileWriter(DATA_FILE, true);
	         PrintWriter writer = new PrintWriter(fileWriter)) {
	        writer.println(RecipeTextifier.getText(recipe));
	    } catch (IOException writerException) {
	        throw new IOException("Failed to write to file: " + writerException.getMessage(), writerException);
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
