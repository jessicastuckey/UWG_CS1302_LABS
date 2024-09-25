package edu.westga.cs1302.project1jessicastuckey.test.model.PantryGrocery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;

public class TestIncreaseQuantity {
	
	@Test
	void testNoIncrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.increaseQuantity(0);
		
		assertEquals(0, item1.getQuantity());
	}
	
	@Test
	void testOneIncrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.increaseQuantity(1);
		
		assertEquals(1, item1.getQuantity());
	}
	
	@Test
	void testMultipleIncrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.increaseQuantity(5);
		
		assertEquals(5, item1.getQuantity());
	}
	
	@Test
	void testIncreaseWhenItemHasSetQuantity() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.setQuantity(5);
		item1.increaseQuantity(5);
		
		assertEquals(10, item1.getQuantity());
	}



}
