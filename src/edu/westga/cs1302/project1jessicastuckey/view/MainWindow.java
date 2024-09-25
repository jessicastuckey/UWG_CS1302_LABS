package edu.westga.cs1302.project1jessicastuckey.view;

import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private TextField name;
	@FXML
	private ComboBox<String> type;
	@FXML
	private ListView<PantryGrocery> pantry;

	@FXML
	void addGrocery(ActionEvent event) {
		String name = this.name.getText();
		String type = this.type.getSelectionModel().getSelectedItem();

		PantryGrocery grocery = new PantryGrocery(name, type);
		this.pantry.getItems().add(grocery);
	}

	/**
	 * Initializes the combobox and Strings in the combobox
	 * 
	 * @author JS
	 * @version Fall 2024
	 */

	public void initialize() {
		ObservableList<String> list = FXCollections.observableArrayList("Vegetable", "Meat", "Bread", "Fruit",
				"Dessert", "Ingredient");
		this.type.setItems(list);
	}
}
