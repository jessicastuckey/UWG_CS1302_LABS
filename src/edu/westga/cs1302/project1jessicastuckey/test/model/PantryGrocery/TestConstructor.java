package edu.westga.cs1302.project1jessicastuckey.test.model.PantryGrocery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;


class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new PantryGrocery(null, "Fruit");});
	}

	@Test
	void testNullType() {
		assertThrows(IllegalArgumentException.class, ()->{new PantryGrocery("Apple", null);});
	}
	
	@Test
	void testCreatingObject() {
		PantryGrocery result = new PantryGrocery("Apple", "Fruit");
		
		assertEquals("Apple", result.getName());
		assertEquals("Fruit", result.getType());
	}

}
