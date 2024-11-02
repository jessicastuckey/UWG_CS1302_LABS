package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Supports loads multiple recipes from a file
 * 
 * @author js00547
 * @version Fall 2024
 */
public class RecipeLoader {
		
	/**
	 * Loads the recipe and reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the recipe loaded
	 */
	public static ArrayList<Recipe> loadRecipeData() throws FileNotFoundException, IOException {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		File inputFile = new File(RecipeSaver.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			String[] parts = reader.nextLine().strip().split(",");
			Recipe recipe = new Recipe(parts[0]);
			try {
				parts = reader.nextLine().strip().split(",");
				for (int index = 1; index < parts.length; index += 2) {
					String ingredientName = parts[index];
					String type = parts[index + 1];
					Ingredient ingredient = new Ingredient(ingredientName, type);
					recipe.addItem(ingredient);
				}
			} catch (IllegalArgumentException recipeDataError) {
				throw new IOException("Unable to create recipe, bad name/type on line ");
				}
			} catch (FileNotFoundException fnfe) {
				return new ArrayList<Recipe>();
			}
			return recipeList;
		}
	
	/**
	 * Finds recipes that contain a specified ingredient
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @param ingredient the ingredient to search for
	 * @throws IOException
	 * 
	 * @return recipesWithIngredient the list of recipes that contain that ingredient
	 */
	public static ArrayList<Recipe> findRecipesWithIngredient(Ingredient ingredient) {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		try {
			recipeList = loadRecipeData();
		} catch (IOException ioe) {
			return new ArrayList<Recipe>();
		} 
		ArrayList<Recipe> recipesWithIngredient = new ArrayList<Recipe>();
		for (Recipe currentRecipe : recipeList) {
			String ingredientName = currentRecipe.getName();
			if (ingredientName.equals(ingredient.getName())) {
				recipesWithIngredient.add(currentRecipe);
			}
		}
	return recipesWithIngredient;
	}
}
