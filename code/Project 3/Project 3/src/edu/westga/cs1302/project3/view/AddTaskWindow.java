package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {

	@FXML
	private Button addTaskButton;
	@FXML
	private Button cancelButton;
	@FXML
	private TextArea descriptionTextArea;
	@FXML
	private TextField titleTextField;
	
	private MainWindowViewModel vm;

	@FXML
	void initialize() {
		assert this.addTaskButton != null
				: "fx:id=\"addTaskButton\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert this.cancelButton != null
				: "fx:id=\"cancelButton\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert this.descriptionTextArea != null
				: "fx:id=\"descriptionTextArea\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert this.titleTextField != null
				: "fx:id=\"titleTextField\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";

	}

    @FXML
    void cancelOnAction(ActionEvent event) {
    	this.titleTextField.getParent().getScene().getWindow().hide();
    }
    
    @FXML
    void addTaskOnAction(ActionEvent event) {
    	try {
    		this.vm.addTask();
    		this.cancelOnAction(event);
    	} catch (Exception exc) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Error when adding task: " + exc.getMessage());
    		alert.showAndWait();
    	}
    }
    
    /** Binds the viewmodel to the properties
     * 
     * @param vm the viewmodel 
     */
    public void bindToVM(MainWindowViewModel vm) {
    	this.vm = vm;
    	this.vm.getTitle().bind(this.titleTextField.textProperty());
    	this.vm.getDescription().bind(this.descriptionTextArea.textProperty());
    }
	
}
