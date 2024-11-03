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
	public static ArrayList<Recipe> loadRecipeData() throws IOException {
	    ArrayList<Recipe> recipeList = new ArrayList<>();
	    File inputFile = new File(RecipeSaver.DATA_FILE);
	    
	    if (!inputFile.exists()) {
	        throw new FileNotFoundException("Data file not found: " + RecipeSaver.DATA_FILE);
	    }

	    try (Scanner reader = new Scanner(inputFile)) {
	        while (reader.hasNextLine()) {
	            String line = reader.nextLine().strip();
	            System.out.println("Reading line: " + line);
	            
	            String[] parts = line.split(", ");
	            if (parts.length < 1) {
	                throw new IOException("Invalid recipe format: " + line);
	            }

	            Recipe recipe = new Recipe(parts[0]);

	            for (int index = 1; index < parts.length; index++) {
	                String ingredientString = parts[index].trim();
	                if (ingredientString.isEmpty()) {
	                    continue;
	                }
	                
	                String[] ingredientParts = ingredientString.split(", ");
	                if (ingredientParts.length != 2) {
	                    throw new IOException("Incomplete ingredient data for recipe: " + recipe.getName());
	                }

	                String ingredientName = ingredientParts[0].trim();
	                String type = ingredientParts[1].trim();
	                Ingredient ingredient = new Ingredient(ingredientName, type);
	                recipe.addItem(ingredient);
	            }

	            recipeList.add(recipe);
	        }
	    } catch (FileNotFoundException fnfe) {
	        throw new FileNotFoundException("Error reading file: " + fnfe.getMessage());
	    } catch (IllegalArgumentException recipeDataError) {
	        throw new IOException("Unable to create recipe, bad data: " + recipeDataError.getMessage());
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
