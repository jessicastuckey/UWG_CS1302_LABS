package edu.westga.cs1302.project3.test.model.taskmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestRemoveItem {

	@Test
	public void testNullTaskTitle() {
		TaskManager taskList = new TaskManager();

		assertThrows(IllegalArgumentException.class, () -> {
			taskList.removeItem(null);
		});
	}
	
	@Test
	public void testEmptyTaskTitle() {
		TaskManager taskList = new TaskManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			taskList.removeItem("");
		});
	}

	@Test
	public void testRemoveValidTask() {
		TaskManager taskList = new TaskManager();
		Task task = new Task("a", "b");
		Task task2 = new Task("c", "d");
		Task task3 = new Task("e", "f");

		taskList.addItem(task);
		taskList.addItem(task2);
		taskList.addItem(task3);
		
		taskList.removeItem("a");

		assertEquals("c", taskList.getTasks().get(0).getTitle());
	}
}
