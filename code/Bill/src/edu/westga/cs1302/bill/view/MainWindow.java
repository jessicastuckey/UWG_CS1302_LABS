package edu.westga.cs1302.bill.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;
import edu.westga.cs1302.bill.model.CSVBillPersistenceManager;
import edu.westga.cs1302.bill.model.TSVBillPersistenceManager;
import edu.westga.cs1302.bill.model.BillAscendingPriceComparator;
import edu.westga.cs1302.bill.model.BillDescendingPriceComparator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private ComboBox<BillPersistenceManager> format;
    @FXML 
    private ComboBox<Comparator<BillItem>> order;

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
	
	@FXML void changeOrder(ActionEvent event) {
		this.bill.sortItems(this.order.getValue());
		this.updateReceipt();
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
		try {
			this.format.getValue().saveBillData(this.bill);
		} catch (IOException writeError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to save data to file!");
			alert.showAndWait();
		}
	}

	@FXML
	void initialize() {
		this.serverName.getItems().add("Bob");
		this.serverName.getItems().add("Alice");
		this.serverName.getItems().add("Trudy");
		
		this.format.getItems().add(new CSVBillPersistenceManager());
		this.format.getItems().add(new TSVBillPersistenceManager());
		this.format.setValue(this.format.getItems().get(0));
		
		this.order.getItems().add(new BillAscendingPriceComparator());
		this.order.getItems().add(new BillDescendingPriceComparator());
		this.order.setValue(this.order.getItems().get(0));

		try {
			this.bill = this.format.getValue().loadBillData();
		} catch (FileNotFoundException fileError) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("No save data file found, loading with no bill data");
			alert.showAndWait();
			this.bill = new Bill();
		} catch (IOException parseError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("File not in valid format");
			alert.setContentText(parseError.getMessage());
			alert.showAndWait();
		}
		this.updateReceipt();
	}
}
