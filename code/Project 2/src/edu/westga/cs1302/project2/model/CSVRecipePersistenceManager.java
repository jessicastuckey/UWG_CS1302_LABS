package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
	public void saveRecipeData(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("recipe cannot be null");
		}

		try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
			String output = recipe.getName() + ",";
			for (Ingredient currentItem : recipe.getIngredients()) {
				output += currentItem.getName() + "," + currentItem.getType() + ",";
			}
			writer.println(output);
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}

	/**
	 * Loads the recipe and reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the recipe loaded
	 */
	public Recipe loadRecipeData() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			String[] parts = reader.nextLine().strip().split(",");
			String name = parts[0];
			recipe.setName(name);

			try {
				for (int index = 1; index < parts.length; index += 2) {
					String ingredientName = parts[index];
					String type = parts[index + 1];
					Ingredient ingredient = new Ingredient(name, type);
					recipe.addItem(ingredient);
				}
			} catch (IllegalArgumentException recipeDataError) {
				throw new IOException("Unable to create recipe, bad name/type on line ");
			}
		}
		return recipe;
	}

	@Override
	public String toString() {
		return "CSV";
	}

}
