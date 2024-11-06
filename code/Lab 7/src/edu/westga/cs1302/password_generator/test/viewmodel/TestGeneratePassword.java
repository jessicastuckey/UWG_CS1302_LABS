package edu.westga.cs1302.password_generator.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;

class TestGeneratePassword {

	@Test
	public void testWhenMinLengthIsInvalid() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.getMinLengthProperty().setValue("a");
		assertThrows(NumberFormatException.class, ()->{generator.generatePassword();});
	}

	@Test
	public void testWhenMinLengthLessThanOne() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.getMinLengthProperty().setValue("0");
		assertThrows(IllegalArgumentException.class, ()->{generator.generatePassword();});
	}

	@Test
	public void testNoErrors() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.getMinLengthProperty().setValue("5");
		generator.generatePassword();
		assertTrue(5 <= generator.getOutputProperty().getValue().length());
	}
}
