package edu.westga.cs1302.project3.test.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.utility.TaskPersistenceManager;

public class TestLoadTaskManager {

	@Test
	public void testNullInputFile() {
		TaskPersistenceManager manager = new TaskPersistenceManager();

		assertThrows(IllegalArgumentException.class, () -> {
			manager.loadTaskManager(null);
		});
	}

	@Test
	public void testLoadTaskManager() throws FileNotFoundException, IOException {
		TaskPersistenceManager manager = new TaskPersistenceManager();
		File file = new File("data.txt");
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Sweep the House", "Sweep the floors in the living room and kitchen.");

		taskManager.addItem(task);
		manager.saveTaskManager(taskManager, file);

		TaskManager result = manager.loadTaskManager(file);

		assertEquals(1, result.getTasks().size());
	}
}
