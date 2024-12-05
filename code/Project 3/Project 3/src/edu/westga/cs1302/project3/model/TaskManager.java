package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores a set of Tasks
 *
 * @author js00547
 * @version Fall 2024
 */

public class TaskManager {
	private ArrayList<Task> taskList;
	private Map<String, Task> taskMap;

	/**
	 * Creates an empty list for tasks
	 */
	public TaskManager() {
		this.taskList = new ArrayList<>();
		this.taskMap = new HashMap<String, Task>();
	}

	/**
	 * Return the tasks in the TaskManager
	 *
	 * @return the tasks in the TaskManager
	 */

	public ArrayList<Task> getTasks() {
		return this.taskList;
	}

	/**
	 * Adds the task to the TaskManager
	 *
	 * @precondition task != null
	 * @postcondition task is added to the task list
	 *
	 * @param task the task to be added
	 */

	public void addItem(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("task must not be null.");
		}
		if (this.isDuplicate(task)) {
			throw new IllegalArgumentException("Task cannot have duplicate title.");
		}
		this.taskList.add(task);
		this.taskMap.put(task.getTitle(), task);
	}

	/**
	 * Removes a sepcified task from the TaskManager
	 * 
	 * @param taskTitle the title of the task to be removed
	 */
	public void removeItem(String taskTitle) {
		if (taskTitle == null || taskTitle.isEmpty()) {
			throw new IllegalArgumentException("Must enter valid tastTitle");
		}
		Task taskToRemove = null;
		for (Task currTask : this.taskList) {
			if (currTask.getTitle().equals(taskTitle)) {
				taskToRemove = currTask;
				break;
			}
		}
		this.taskList.remove(taskToRemove);
		this.taskMap.remove(taskTitle);
	}

	private boolean isDuplicate(Task task) {
		try {
			this.taskMap.get(task.getTitle()).getTitle();
			return true;
		} catch (NullPointerException npe) {
			return false;
		}
	}
}