package edu.westga.cs1302.project1jessicastuckey.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;


class TestAddGrocery {

	@Test
	void testNullGrocery() {
		Pantry pantry = new Pantry();
		
		assertThrows(IllegalArgumentException.class, ()->{pantry.addGrocery(null);});
	}
	
	@Test
	void testAddFirstGrocery() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("apple", "Fruit");
		
		pantry.addGrocery(item1);
		
		assertEquals(1, pantry.getSize(), "checking number of groceries in the pantry");
		PantryGrocery firstItem = pantry.getGroceries()[0];
		assertEquals("apple", firstItem.getName(), "checking the name of the first item in the pantry");
		assertEquals("Fruit", firstItem.getType(), "checking the type of the first item in the pantry");
	}
	
	@Test
	void testAddSecondGrocery() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("Apple", "Fruit");
		PantryGrocery item2 = new PantryGrocery("Chicken", "Meat");
		pantry.addGrocery(item1);
		
		pantry.addGrocery(item2);
		
		assertEquals(2, pantry.getSize(), "checking number of groceries in the bill");
		PantryGrocery firstItem = pantry.getGroceries()[0];
		assertEquals("Apple", firstItem.getName(), "checking the name of the first item in the pantry");
		assertEquals("Fruit", firstItem.getType(), "checking the type of the first item in the pantry");
		PantryGrocery secondItem = pantry.getGroceries()[1];
		assertEquals("Chicken", secondItem.getName(), "checking the name of the second item in the pantry");
		assertEquals("Meat", secondItem.getType(), "checking the type of the secons item in the pantry");
	}
	
	@Test
	void testAddTooManyGroceries() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("Apple", "Fruit");
		PantryGrocery item2 = new PantryGrocery("Orange", "Fruit");
		PantryGrocery item3 = new PantryGrocery("Bread", "Bread");
		PantryGrocery item4 = new PantryGrocery("Chicken", "Meat");
		PantryGrocery item5 = new PantryGrocery("Beef", "Meat");
		PantryGrocery item6 = new PantryGrocery("Ice Cream", "Desert");
		pantry.addGrocery(item1);
		pantry.addGrocery(item2);
		pantry.addGrocery(item3);
		pantry.addGrocery(item4);
		pantry.addGrocery(item5);
		
		assertThrows(IllegalStateException.class, ()->{pantry.addGrocery(item6);});
	}

}
