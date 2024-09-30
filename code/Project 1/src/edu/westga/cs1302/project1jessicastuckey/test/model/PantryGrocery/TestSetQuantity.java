package edu.westga.cs1302.project1jessicastuckey.test.model.PantryGrocery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;

public class TestSetQuantity {
	
	@Test
	void testWhenSettingOneQuantity() {
		Pantry pantry = new Pantry();
		PantryGrocery item = new PantryGrocery("Apple", "Fruit");
		
		pantry.addGrocery(item);
		item.setQuantity(1);
		
		assertEquals(1, item.getQuantity());
	}
	
	@Test
	void testWhenSettingMultipleQuantity() {
		Pantry pantry = new Pantry();
		PantryGrocery item = new PantryGrocery("Apple", "Fruit");
		
		pantry.addGrocery(item);
		item.setQuantity(5);
		
		assertEquals(5, item.getQuantity());

	}

}
