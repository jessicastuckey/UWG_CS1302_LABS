package edu.westga.cs1302.project3.model;

/** Store information for a single Task
 * 
 * @author js00547
 * @version Fall 2024
 */
public class Task {
	private String title;
	private String description;
	
	/** Create a new task with a title and description
	 * 
	 * @precondition title != null && !title.isEmpty() &&
	 * 				 description != null && !description.isEmpty()
	 * 
	 * @param title the title of the task
	 * @param description the description of the task
	 */
	public Task(String title, String description) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Must provide valid title.");
		}
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException("Must provide valid description");
		}
		this.title = title;
		this.description = description;
	}
	
	/** Return the title of the task
	 * 
	 * @return the title of the task
	 */
	public String getTitle() {
		return this.title;
	}
	
	/** Return the description of the task
	 * 
	 * @return the description of the task
	 */
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}

