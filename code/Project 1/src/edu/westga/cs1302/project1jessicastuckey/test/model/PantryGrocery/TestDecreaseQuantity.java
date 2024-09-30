package edu.westga.cs1302.project1jessicastuckey.test.model.PantryGrocery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;

public class TestDecreaseQuantity {
	
	@Test
	void testNegativeQuantity() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);

		assertThrows(IllegalArgumentException.class, ()->{item1.decreaseQuantity(1);});	
	}
	
	@Test
	void testNoDecrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.decreaseQuantity(0);
		
		assertEquals(0, item1.getQuantity());
	}
	
	@Test
	void testOneDecrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.setQuantity(5);
		item1.decreaseQuantity(1);
		
		assertEquals(4, item1.getQuantity());
	}
	
	@Test
	void testMultipleDecrease() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		item1.setQuantity(5);
		item1.decreaseQuantity(3);
		
		assertEquals(2, item1.getQuantity());
	}
	
}
