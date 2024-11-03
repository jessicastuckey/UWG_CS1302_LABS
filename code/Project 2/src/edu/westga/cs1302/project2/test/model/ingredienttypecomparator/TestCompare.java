package edu.westga.cs1302.project2.test.model.ingredienttypecomparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.IngredientTypeComparator;

public class TestCompare {

	@Test
	public void testWhenSortingTwo() {
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("a", "a");
		Ingredient ingredient2 = new Ingredient("b", "b");
		
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		
		ingredients.sort(new IngredientTypeComparator());
		
		assertEquals("a", ingredients.get(0).getType());
		assertEquals("b", ingredients.get(1).getType());
	}
	
	@Test
	public void testWhenSortingMultiple() {
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("a", "a");
		Ingredient ingredient2 = new Ingredient("b", "b");
		Ingredient ingredient3 = new Ingredient("c", "c");
		Ingredient ingredient4 = new Ingredient("d", "d");
		
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		
		ingredients.sort(new IngredientTypeComparator());
		
		assertEquals("a", ingredients.get(0).getType());
		assertEquals("b", ingredients.get(1).getType());
		assertEquals("c", ingredients.get(2).getType());
		assertEquals("d", ingredients.get(3).getType());
	}

}
