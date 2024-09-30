package utils;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;

/**
 * Utility class for the pantry
 * 
 * @author JS
 * @version Fall 2024
 */

public class Utility {

	/**
	 * Return the count of groceries in the pantry
	 * 
	 * @param pantry the pantry with pantrygroceries to be counted
	 * @return the count of groceries
	 */
	public static int countGroceries(Pantry pantry) {
		int count = 0;
		PantryGrocery[] groceries = pantry.getGroceries();
		for (int index = 0; index < pantry.getSize(); index++) {
			count = count + groceries[index].getQuantity();
		}
		return count;
	}

}
