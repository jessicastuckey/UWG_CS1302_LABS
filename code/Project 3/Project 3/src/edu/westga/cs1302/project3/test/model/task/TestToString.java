package edu.westga.cs1302.project3.test.model.task;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

public class TestToString {
	
	@Test
	public void testToString() {
		Task task = new Task("a", "b");
		
		String result = task.toString();
		
		assertEquals("a", result);
	}
}
