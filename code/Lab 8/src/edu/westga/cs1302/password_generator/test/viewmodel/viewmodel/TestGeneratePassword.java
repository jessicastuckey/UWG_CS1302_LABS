package edu.westga.cs1302.password_generator.test.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

public class TestGeneratePassword {

	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.verifyMinimumLength();
		vm.generatePassword();
		
		assertTrue(vm.getPasswords().get(vm.getPasswords().getSize()-1).length() >= 2, "checking the password property has an appropriate number of characters");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}
}
