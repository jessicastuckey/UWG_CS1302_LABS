package edu.westga.cs1302.project3.view;

import javafx.fxml.FXML;
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
}
