package edu.westga.cs1302.project1jessicastuckey.test.model.Pantry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;


class TestRemoveGrocery {

	@Test
	void testNullGrocery() {
		Pantry pantry = new Pantry();
		
		assertThrows(IllegalArgumentException.class, ()->{pantry.removeGrocery(null);});
	}
	
	@Test
	void testRemoveWhenListIsEmpty() {
		Pantry pantry = new Pantry();
		PantryGrocery item = new PantryGrocery("Apple", "Fruit");
		
		assertThrows(IllegalArgumentException.class, ()->{pantry.removeGrocery(item);});
	}

	@Test
	void testRemoveFirstGroceryInList() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("Apple", "Fruit");
		PantryGrocery item2 = new PantryGrocery("Orange", "Fruit");
		PantryGrocery item3 = new PantryGrocery("Bread", "Bread");
		PantryGrocery item4 = new PantryGrocery("Chicken", "Meat");
		PantryGrocery item5 = new PantryGrocery("Beef", "Meat");
		pantry.addGrocery(item1);
		pantry.addGrocery(item2);
		pantry.addGrocery(item3);
		pantry.addGrocery(item4);
		pantry.addGrocery(item5);

		
		pantry.removeGrocery(item1);
		
		PantryGrocery firstItem = pantry.getGroceries()[0];
		assertEquals(4, pantry.getSize());
		assertNull(firstItem);
	}
	
	@Test
	void testRemoveLastGroceryInList() {
		Pantry pantry = new Pantry();
		PantryGrocery item1 = new PantryGrocery("Apple", "Fruit");
		PantryGrocery item2 = new PantryGrocery("Orange", "Fruit");
		PantryGrocery item3 = new PantryGrocery("Bread", "Bread");
		PantryGrocery item4 = new PantryGrocery("Chicken", "Meat");
		PantryGrocery item5 = new PantryGrocery("Beef", "Meat");
		pantry.addGrocery(item1);
		pantry.addGrocery(item2);
		pantry.addGrocery(item3);
		pantry.addGrocery(item4);
		pantry.addGrocery(item5);
		
		pantry.removeGrocery(item5);
		
		PantryGrocery lastItem = pantry.getGroceries()[4];
		assertEquals(4, pantry.getSize());
		assertNull(lastItem);
	}
}
