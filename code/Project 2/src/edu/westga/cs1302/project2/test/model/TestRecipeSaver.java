package edu.westga.cs1302.project2.test.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeSaver;

import java.io.File;
import java.io.IOException;

public class TestRecipeSaver {

    private Recipe testRecipe;

    @BeforeEach
    public void setUp() {
        this.testRecipe = new Recipe("Test Recipe");
        this.testRecipe.addItem(new Ingredient("Tomato", "Vegetable"));
        this.testRecipe.addItem(new Ingredient("Chicken", "Meat"));
    }

    @Test
    public void testSaveRecipeDataCreatesFile() throws IOException {
        String filePath = "test_recipes.txt";

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        RecipeSaver.saveRecipeData(testRecipe);

        assertTrue(file.exists(), "File should be created after saving a recipe.");

        file.delete();
    }

    @Test
    public void testSaveRecipeDataThrowsExceptionWhenRecipeExists() throws IOException {
        String filePath = "test_recipes.txt";
        RecipeSaver.saveRecipeData(testRecipe);

        assertThrows(IllegalStateException.class, () -> {
            RecipeSaver.saveRecipeData(testRecipe);
        }, "Should throw IllegalStateException when trying to save an existing recipe.");
        
        new File(filePath).delete();
    }
}
