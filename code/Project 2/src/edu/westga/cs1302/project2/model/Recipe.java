package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/** Stores information for a recipe
 * 
 * @author js00547
 * @version Fall 2024
 */
public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredientsList;

	/**
	 * Create a new empty recipe
	 */
	public Recipe() {
		this.name = name;
		this.ingredientsList = new ArrayList<Ingredient>();
	}
	
	/**Return the name of the recipe
	 * @return the name of the recipe
	 */
	public String getName() {
		return this.name;
	}
	
	/** Sets the name for the recipe
	 * 
	 * @precondition name != null && !name.isEmpty()
	 * @postcondition getName() == name
	 * 
	 * @param name the name of the recipe
	 */
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		this.name = name;
	}
	
	/**
	 * Adds the ingredient to the recipe
	 * 
	 * @precondition ingredient != null && size < 5
	 * @postcondition ingredient is added to the list of ingredients in the recipe
	 * 
	 * @param ingredient the ingredient to be added to the recipe
	 */
	public void addItem(Ingredient ingredient) {
		if (ingredient == null) {
			throw new IllegalArgumentException("ingredient must not be null.");
		}
		this.ingredientsList.add(ingredient);
	}
	
	/**
	 * Return the ingredients in the recipe
	 * 
	 * @return the ingredients in the recipe
	 */
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredientsList;
	}
}
