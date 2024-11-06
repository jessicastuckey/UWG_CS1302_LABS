package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Class ViewModel.
 * 
 * @author js00547
 * @version Fall 2024
 */
public class PasswordGeneratorViewModel {
	private StringProperty minLengthProperty;
	private StringProperty outputProperty;
	private BooleanProperty includeDigitsProperty;
	private BooleanProperty lowerCaseLettersProperty;
	private BooleanProperty upperCaseLettersProperty;
	
	private PasswordGenerator generator;
	
	/**
	 * Instantiates a new password view model.
	 */

	public PasswordGeneratorViewModel() {
		this.minLengthProperty = new SimpleStringProperty();
		this.outputProperty = new SimpleStringProperty();
		this.includeDigitsProperty = new SimpleBooleanProperty();
		this.lowerCaseLettersProperty = new SimpleBooleanProperty();
		this.upperCaseLettersProperty = new SimpleBooleanProperty();
		this.generator = new PasswordGenerator((new Random()).nextLong());
		
	}
	
	/**
	 * Gets the minimum length property
	 * 
	 * @return the lengthProperty
	 */
	public StringProperty getMinLengthProperty() {
		return this.minLengthProperty;
	}

	/**
	 * Gets the output property
	 * 
	 * @return the outputProperty
	 */
	public StringProperty getOutputProperty() {
		return this.outputProperty;
	}

	/**
	 * Gets the include digits property
	 * 
	 * @return the includeDigitsProperty
	 */
	public BooleanProperty getIncludeDigitsProperty() {
		return this.includeDigitsProperty;
	}

	/**
	 * Gets the lower case letters property
	 * 
	 * @return the lowerCaseLettersProperty
	 */
	public BooleanProperty getLowerCaseLettersProperty() {
		return this.lowerCaseLettersProperty;
	}

	/**
	 * Gets the upper case letters property
	 * 
	 * @return the upperCaseLettersProperty
	 */
	public BooleanProperty getUpperCaseLettersProperty() {
		return this.upperCaseLettersProperty;
	}
	
	/**
	 * Generate a password.
	 * 
	 * @precondition: none
	 * @postcondition: password is generated with a minimum of one character with specified boolean values
	 * 
	 */
	public void generatePassword() {
		String password = "";
		try {
			int minLength = Integer.parseInt(this.minLengthProperty.getValue());
			this.generator.setMinimumLength(minLength);
			this.generator.setMustHaveAtLeastOneDigit(this.includeDigitsProperty.getValue());
			this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.lowerCaseLettersProperty.getValue());
			this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.upperCaseLettersProperty.getValue());
			password = this.generator.generatePassword();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException();
		}
		this.outputProperty.setValue(password);
	}
}
