package edu.westga.cs1302.project3.view;

import java.util.ResourceBundle;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private MenuItem aboutMenuItem;
	@FXML
	private Button addTaskButton;
	@FXML
	private MenuItem addTaskMenuItem;
	@FXML
	private MenuItem closeMenuItem;
	@FXML
	private MenuItem loadTasksMenuItem;
	@FXML
	private Button removeTaskButton;
	@FXML
	private MenuItem saveTaskMenuItem;
	@FXML
	private ListView<Task> taskListView;

	private MainWindowViewModel vm;

	@FXML
	void initialize() {
		assert this.aboutMenuItem != null
				: "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.addTaskButton != null
				: "fx:id=\"addTaskButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.addTaskMenuItem != null
				: "fx:id=\"addTaskMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.closeMenuItem != null
				: "fx:id=\"closeMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.loadTasksMenuItem != null
				: "fx:id=\"loadTasksMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.removeTaskButton != null
				: "fx:id=\"removeTaskButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.saveTaskMenuItem != null
				: "fx:id=\"saveTaskMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.taskListView != null
				: "fx:id=\"taskListView\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.vm = new MainWindowViewModel();
		this.setUpBinding();
		this.taskListView.refresh();
	}

	private void setUpBinding() {
		this.taskListView.itemsProperty().bindBidirectional(this.vm.getTasks());

	}

	@FXML
	void addTaskOnAction(ActionEvent event) {

	}

	@FXML
	void removeTaskOnAction(ActionEvent event) {

	}
}
