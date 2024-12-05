package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestAddTask {
	
	@Test
	public void testAddValidTask() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.getTitle().setValue("a");
		vm.getDescription().setValue("b");
		vm.addTask();
		
		assertEquals(4, vm.getTasks().getSize());
		assertEquals("a", vm.getTasks().get(3).getTitle());
		assertEquals("b", vm.getTasks().get(3).getDescription());
	}
}
