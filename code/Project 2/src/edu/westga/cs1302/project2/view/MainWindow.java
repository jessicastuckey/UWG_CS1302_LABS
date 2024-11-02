package edu.westga.cs1302.project2.view;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import edu.westga.cs1302.project2.model.IngredientNameComparator;
import edu.westga.cs1302.project2.model.IngredientTypeComparator;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeSaver;
import edu.westga.cs1302.project2.model.Ingredient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML private ComboBox<String> ingredientType;
	@FXML private ListView<Ingredient> ingredientsList;
	@FXML private TextField ingredientName;
    @FXML private ComboBox<Comparator<Ingredient>> sortComboBox;
    @FXML private ListView<Ingredient> recipeList;
    @FXML private TextField recipeName;
    @FXML private TextArea recipeDisplay;
    @FXML private Button recipeDisplayButton;

	@FXML
	void addIngredient(ActionEvent event) {
		try {
			this.ingredientsList.getItems().add(new Ingredient(this.ingredientName.getText(), this.ingredientType.getValue()));
			this.ingredientName.clear();
			this.ingredientType.getSelectionModel().clearSelection();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add ingredient");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
		this.ingredientsList.refresh();
	}
	
    @FXML
    void addToRecipe(ActionEvent event) {
    	Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.recipeList.getItems().add(selectedIngredient);
		}
		this.recipeList.refresh();
    }

    @FXML
    void createRecipe(ActionEvent event) {
    	String recipeName = this.recipeName.getText();
    	List<Ingredient> ingredientList = this.recipeList.getItems();
    	if (recipeName == null || recipeName.isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid recipe name");
    		alert.showAndWait();
    		return;
    	}
    	if (ingredientList.isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Ingredient list is empty.");
    		alert.showAndWait();
    		return;
    	}
    	Recipe recipe = new Recipe(recipeName);
    	for (Ingredient currIngredient : ingredientList) {
    		recipe.addItem(currIngredient);
    	}
    	try {
    		RecipeSaver.saveRecipeData(recipe);
    	} catch (IOException ioe) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("File writer error.");
    		alert.showAndWait();
    		return;
    	} catch (IllegalStateException ise) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Recipe already exists.");
    		alert.showAndWait();
    		return;
    	}
    }

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
		}
		this.ingredientsList.refresh();
	}
	
	  @FXML
	    void changeSort(ActionEvent event) {
		  if (this.sortComboBox.getValue().toString().equals("Name")) {
			  ObservableList<Ingredient> ingredients = this.ingredientsList.getItems();
			  ingredients.sort(new IngredientNameComparator());
			  this.ingredientsList.setItems(ingredients);
			  this.ingredientsList.refresh();
		  } else if (this.sortComboBox.getValue().toString().equals("Type")) {
			  ObservableList<Ingredient> ingredients = this.ingredientsList.getItems();
			  ingredients.sort(new IngredientTypeComparator());
			  this.ingredientsList.setItems(ingredients);
			  this.ingredientsList.refresh();
		  }
	  }
	  
	  @FXML
	    void searchRecipes(ActionEvent event) {

	    }
	  
	@FXML
	void initialize() {
		this.ingredientType.getItems().add("Vegetable");
		this.ingredientType.getItems().add("Meat");
		this.ingredientType.getItems().add("Bread");
		this.ingredientType.getItems().add("Fruit");
		this.ingredientType.getItems().add("Spice");
		
		this.sortComboBox.getItems().add(new IngredientNameComparator());
		this.sortComboBox.getItems().add(new IngredientTypeComparator());
		this.sortComboBox.setValue(this.sortComboBox.getItems().get(0));
	}
}
