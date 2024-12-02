package edu.westga.cs1302.project3.test.model.taskmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestAddItem {

	@Test
	public void testNullTask() {
		TaskManager taskList = new TaskManager();
		
		assertThrows(IllegalArgumentException.class, ()->{taskList.addItem(null);});
	}
	
	@Test
	public void testAddValidTask() {
		TaskManager taskList = new TaskManager();
		Task task = new Task("a", "b");
		
		taskList.addItem(task);
		
		assertEquals("a", taskList.getTasks().get(0).getTitle());
		assertEquals("b", taskList.getTasks().get(0).getDescription());
	}
}
