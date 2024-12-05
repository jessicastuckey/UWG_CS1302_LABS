package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.utility.TaskPersistenceManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author js00547
 * @version Fall 2024
 */
public class MainWindowViewModel {
	private ListProperty<Task> tasks;
	private StringProperty title;
	private StringProperty description;
	
	private TaskManager taskManager;
	private TaskPersistenceManager persistenceManager;
	
	/** Initialize the properties for the viewmodel
	 */
	public MainWindowViewModel() {
		this.taskManager = new TaskManager();
		this.persistenceManager = new TaskPersistenceManager();
		this.tasks = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.taskManager.getTasks()));
		this.title = new SimpleStringProperty();
		this.description = new SimpleStringProperty();
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
	
	/** Gets the title
	 * @return the title
	 */
	public StringProperty getTitle() {
		return this.title;
	}

	/** Gets the description
	 * @return the description
	 */
	public StringProperty getDescription() {
		return this.description;
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
			throw new IllegalArgumentException("File was not found.");
		} catch (IOException ioe) {
			throw new IllegalArgumentException("Invalid file.");
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
	
	/** Adds task to list of tasks
	 * 
	 */
	public void addTask() {
		Task task = new Task(this.title.get(), this.description.get());
		this.taskManager.addItem(task);
		this.updateListView();
	}
	
	/** Removes task from task list
	 * 
	 * @param task to be removed
	 */
	public void removeTask(Task task) {
		this.taskManager.removeItem(task.getTitle());
		this.updateListView();
	}
}
