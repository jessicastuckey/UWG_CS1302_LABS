package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestLoadData {

	@Test
	public void testLoadData() {
		MainWindowViewModel vm = new MainWindowViewModel();
		File file = new File("data.txt");
		Task task = new Task("Sweep the House", "Sweep the floors in the living room and kitchen.");
		
		vm.removeTask(task);
		vm.saveData(file);
		
		vm.loadData(file);
		
		assertEquals(2, vm.getTasks().getSize());
	}
}
