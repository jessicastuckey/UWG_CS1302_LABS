package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import utility.RecipeTextifier;

/**
 * Supports saving and loading recipe data,
 * 
 * @author js00547
 * @version Fall 2024
 */
public class CSVRecipePersistenceManager {

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
	public void saveRecipeData(Recipe recipe) throws IOException {
		if (recipe == null) {
			throw new IllegalArgumentException("recipe cannot be null");
		}
		ArrayList<Recipe> recipeList = this.loadRecipeData();
		if (this.isDuplicateRecipe(recipeList, recipe)) {
			throw new IllegalStateException();
		}
		try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
			writer.write(RecipeTextifier.getText(recipe));
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}

	private boolean isDuplicateRecipe(ArrayList<Recipe> recipeList, Recipe recipe) {
		for (Recipe currentRecipe : recipeList) {
			if (currentRecipe.getName().equals(recipe.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Loads the recipe and reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the recipe loaded
	 */
	public ArrayList<Recipe> loadRecipeData() throws FileNotFoundException, IOException {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		File inputFile = new File(DATA_FILE);
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
		}
		return recipeList;
	}

	@Override
	public String toString() {
		return "CSV";
	}

}
