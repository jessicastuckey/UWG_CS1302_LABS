package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskPersistenceManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author js00547
 * @version Fall 2024
 */
public class MainWindowViewModel {
	private ListProperty<Task> tasks;
	
	private TaskManager taskManager;
	private TaskPersistenceManager persistenceManager;
	
	/** Initialize the properties for the viewmodel
	 */
	public MainWindowViewModel() {
		this.taskManager = new TaskManager();
		this.persistenceManager = new TaskPersistenceManager();
		this.tasks = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.taskManager.getTasks()));
		Task task1 = new Task("Sweep the House", "Sweep the floors in the living room and kitchen.");
		Task task2 = new Task("Cook Dinner", "Cook chicken casserole for four people.");
		Task task3 = new Task("Get Ready for Bed", "Shower, complete a nightly skincare routine, and brush your teeth.");
		
		this.taskManager.addItem(task1);
		this.taskManager.addItem(task2);
		this.taskManager.addItem(task3);
		this.updateListView(); 
	}
	
	/** Return the list property
	 * 
	 * @return the list property
	 */

	public ListProperty<Task> getTasks() {
		return this.tasks;
	}
	
	private void updateListView() {
		this.tasks.setValue(FXCollections.observableArrayList(this.taskManager.getTasks()));
	}

	/** Loads data from a selected file
	 * 
	 * @param selectedFile the file to load the task manager from
	 */
	public void loadData(File selectedFile) {
		this.taskManager.getTasks().clear();
		try {
			this.taskManager = this.persistenceManager.loadTaskManager(selectedFile);
			this.updateListView();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File was not found.");
		} catch (IOException ioe) {
			System.out.println("Invalid file.");
		}
	}
	
	/** Saves data to a selected file
	 * 
	 * @param selectedFile the file to save the task manager to
	 */
	public void saveData(File selectedFile) {
			this.persistenceManager.saveTaskManager(this.taskManager, selectedFile);
			this.updateListView(); 
	}
}
