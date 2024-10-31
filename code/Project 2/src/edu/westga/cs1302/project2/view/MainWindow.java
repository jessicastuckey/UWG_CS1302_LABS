package edu.westga.cs1302.project2.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.westga.cs1302.project2.model.IngredientNameComparator;
import edu.westga.cs1302.project2.model.IngredientTypeComparator;
import edu.westga.cs1302.project2.model.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
	}

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
		}
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
