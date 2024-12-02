package edu.westga.cs1302.project3.test.model.task;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

public class TestConstructor {

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, ()->{new Task(null, "a");});
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("", "a");});
	}

	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("a", null);});
	}

	@Test
	void testEmptyDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("a", "");});
	}
}
