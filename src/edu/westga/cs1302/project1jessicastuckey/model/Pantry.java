package edu.westga.cs1302.project1jessicastuckey.model;

/**
 * Manages a set of Groceries
 * 
 * @author JS
 * @version Fall 2024
 */
public class Pantry {

	public static final int MAX_NUMBER_OF_ITEMS = 5;
	private PantryGrocery[] groceries;
	private int size;

	/**
	 * Create a new empty Pantry
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Pantry() {
		this.groceries = new PantryGrocery[Pantry.MAX_NUMBER_OF_ITEMS];
		this.size = 0;
	}

	/**
	 * Adds the grocery to the Pantry
	 * 
	 * @precondition grocery != null && size < 5
	 * @postcondition grocery is added to the list of groceries in the pantry
	 * 
	 * @param grocery the grocery to be added to the pantry
	 */
	public void addGrocery(PantryGrocery grocery) {
		if (grocery == null) {
			throw new IllegalArgumentException("grocery must not be null.");
		}
		if (this.size == Pantry.MAX_NUMBER_OF_ITEMS) {
			throw new IllegalStateException("pantry list is full");
		}
		this.groceries[this.size] = grocery;
		this.size++;
	}
	
	/** Return the number of groceries in the pantry
	 * 
	 * @return the number of groceries in the pantry
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Return the groceries in the pantry
	 * 
	 * @return the groceries in the pantry
	 */
	public PantryGrocery[] getGroceries() {
		return this.groceries;
	}
	
}
