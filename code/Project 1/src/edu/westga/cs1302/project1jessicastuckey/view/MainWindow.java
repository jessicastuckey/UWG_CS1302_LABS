package edu.westga.cs1302.project1jessicastuckey.view;

import edu.westga.cs1302.project1jessicastuckey.model.Pantry;
import edu.westga.cs1302.project1jessicastuckey.model.PantryGrocery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
	private ListView<PantryGrocery> pantryListView;
	@FXML
	private TextField quantity;

	private Pantry pantry;
	
	/**
	 * Initializes elements for the GUI
	 * 
	 * 
	 */
	public void initialize() {
		ObservableList<String> list = FXCollections.observableArrayList("Vegetable", "Meat", "Bread", "Fruit",
				"Dessert", "Ingredient");
		this.type.setItems(list);
		this.pantry = new Pantry();
	}

	@FXML
	void addGrocery(ActionEvent event) {
		String name = this.name.getText();
		String type = this.type.getSelectionModel().getSelectedItem();

		PantryGrocery grocery = new PantryGrocery(name, type);
		try {
			int quantity = Integer.parseInt(this.quantity.getText());
			grocery.setQuantity(quantity);

		} catch (NumberFormatException errorThing) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to create grocery: " + errorThing.getMessage()
					+ ". Please reenter quantity and try again.");
			errorPopup.showAndWait();
		}

		if (this.pantry.getSize() < 5) { 
		this.pantryListView.getItems().add(grocery);
		this.pantry.addGrocery(grocery);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Pantry is full.");
			errorPopup.showAndWait();
		}
	}
	
	@FXML
	void removeGrocery(ActionEvent event) {
		PantryGrocery grocery = this.pantryListView.getSelectionModel().getSelectedItem();
		if (grocery != null) {
			this.pantryListView.getItems().remove(grocery);
			this.pantry.removeGrocery(grocery);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No grocery selected. Unable to remove.");
			errorPopup.showAndWait();
		}
	}
	
	@FXML
	void decreaseQuantity(ActionEvent event) {
		PantryGrocery grocery = this.pantryListView.getSelectionModel().getSelectedItem();
		grocery.decreaseQuantity(1);
		this.pantryListView.refresh();

	}

	@FXML
	void increaseQuantity(ActionEvent event) {
		PantryGrocery grocery = this.pantryListView.getSelectionModel().getSelectedItem();
		grocery.increaseQuantity(1);
		this.pantryListView.refresh();
	}
	
	@FXML
	void countGroceries(ActionEvent event) {
		Alert infoPopup = new Alert(Alert.AlertType.INFORMATION);
		infoPopup.setContentText("The grocery count is: " + utils.Utility.countGroceries(this.pantry));
		infoPopup.showAndWait();
	}
}
