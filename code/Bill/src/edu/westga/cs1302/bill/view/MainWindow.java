package edu.westga.cs1302.bill.view;

import java.io.File;
import java.io.FileNotFoundException;

import edu.westga.cs1302.bill.datatier.BillFileWriter;
import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * The codebehind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	private Bill bill;

	@FXML
	private AnchorPane pane;
	@FXML
	private TextField name;
	@FXML
	private TextField amount;
	@FXML
	private TextArea receiptArea;
	@FXML
	private ComboBox<String> serverName;

	@FXML
	void addItem(ActionEvent event) {
		try {
			BillItem item = new BillItem(this.name.getText(), Double.parseDouble(this.amount.getText()));
			this.bill.addItem(item);
			this.name.clear();
			this.amount.clear();
			this.updateReceipt();
		} catch (NumberFormatException numError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add new bill item");
			alert.setContentText("Invalid amount provided, please correct and try again.");
			alert.showAndWait();
		} catch (IllegalArgumentException argError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add new bill item");
			alert.setContentText(argError.getMessage());
			alert.showAndWait();
		}
	}

	private void updateReceipt() {
		this.receiptArea.setText(BillTextifier.getText(this.bill));
	}

	@FXML
	void selectServer(ActionEvent event) {
		String name = this.serverName.getValue();
		if (name != null) {
			this.bill.setServerName(name);
			this.updateReceipt();
		}
	}

	@FXML
	void saveBillData(ActionEvent event) {
		//Gets string for receipt
		String receiptData = this.receiptArea.getText();
		
		//This opens the file directory using Javafx
		Window owner = this.pane.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();

		File selectedFile = fileChooser.showSaveDialog(owner);
		if (selectedFile != null) {
			BillFileWriter writer = new BillFileWriter(selectedFile);
			writer.writeFile(receiptData);
		}
	}

	@FXML
	void initialize() {
		this.serverName.getItems().add("Bob");
		this.serverName.getItems().add("Alice");
		this.serverName.getItems().add("Trudy");
		this.bill = new Bill();
		this.updateReceipt();
	}
}
