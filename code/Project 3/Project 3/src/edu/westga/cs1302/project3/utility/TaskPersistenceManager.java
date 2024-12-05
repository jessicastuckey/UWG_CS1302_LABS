package edu.westga.cs1302.project3.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

/** Supports saving and loading functions for TaskManager
 * 
 * @author js00547
 * @version Fall 2024
 */
public class TaskPersistenceManager {
	
	/**
	 * Saves the taskManager
	 * 
	 * Writes all taskManager data to a file
	 * 
	 * @precondition taskManager != null
	 * @postcondition none
	 * 
	 * @param taskManager the task manager to be saved
	 * @param file the file to save to
	 * @throws IOException
	 */
	
	public void saveTaskManager(TaskManager taskManager, File file) {
		if (taskManager == null) {
			throw new IllegalArgumentException("taskManager cannot be null");
		}
		if (file == null) {
			throw new IllegalArgumentException("file cannot be null");
		}
		try (PrintWriter writer = new PrintWriter(file)) {
			String output = "";
			for (Task currTask : taskManager.getTasks()) {
				output += currTask.getTitle() + "\t" + currTask.getDescription() + "\n";
			}
			writer.println(output);
		} catch (IOException writerException) {
			throw new IllegalArgumentException("Failed to write to file.");
		}
	}
	
	/**
	 * Loads the taskManager
	 * 
	 * Reads from inputFile
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param inputFile the file to load from
	 * @return the taskManager loaded
	 */
	public TaskManager loadTaskManager(File inputFile) throws FileNotFoundException, IOException {
		if (inputFile == null) {
			throw new IllegalArgumentException("inputFile cannot be null");
		}
		TaskManager taskManager = new TaskManager();
			try (Scanner scnr = new Scanner(inputFile)) {
				while (scnr.hasNextLine()) {
					String line = scnr.nextLine();
					if (line.isBlank()) {
						break;
					}
					String[] parts = line.strip().split("\t");
					Task task = new Task(parts[0], parts[1]);
					taskManager.addItem(task);
				}
			} catch (IllegalArgumentException dataError) {
				throw new IOException("Unable to create task, bad title/description");
			} catch (IndexOutOfBoundsException dataError) {
				throw new IOException("Missing either title or description");
			}
			return taskManager;
		}

}
