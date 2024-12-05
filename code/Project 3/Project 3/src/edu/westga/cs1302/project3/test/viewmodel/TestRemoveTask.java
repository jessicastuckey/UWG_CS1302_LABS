package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestRemoveTask {

	@Test
	public void testRemoveValidTask() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Task task = new Task("Cook Dinner", "Cook chicken casserole for four people.");
		
		vm.removeTask(task);
		
		assertEquals(2, vm.getTasks().getSize());
	}
	
	@Test
	public void testRemoveNonexistantTask() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Task task = new Task("a", "b");
		
		vm.removeTask(task);
		
		assertEquals(3, vm.getTasks().getSize());

	}
}
