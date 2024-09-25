package edu.westga.cs1302.project1jessicastuckey.model;

/** Stores information for a single grocery in a pantry.
 * 
 * @author JS
 * @version Fall 2024
 */
public class PantryGrocery {
	private final String name;
	private final String type;
	private int quantity;
	
	/** create a new grocery item with the provided name and type
	 * 
	 * @precondition name != null &&
	 * 				 type != null
	 * @postcondition getName() == name &&
	 * 				  getType() == type
	 * 
	 * @param name the name of the grocery item
	 * @param type the type of the grocery item
	 */
	public PantryGrocery(String name, String type) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("type must not be null");
		}
		this.name = name;
		this.type = type;
		this.quantity = 0;
	}

	/** Return the name for the grocery item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the grocery item
	 */
	public String getName() {
		return this.name;
	}
	
	/** Return the type for the grocery item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the type for the grocery item
	 */
	public String getType() {
		return this.type;
	}
	
	/** Return the quantity for the grocery item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantity for the grocery item
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Return a String of the grocery's name and quantity
	 * 
	 * @return the String of grocery's name and quantity
	 */

	public String toString() {
		return this.name + " - " + this.quantity;
	}
}
