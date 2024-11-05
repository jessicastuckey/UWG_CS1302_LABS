package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PasswordGeneratorViewModel {
	private StringProperty minLengthProperty;
	private StringProperty outputProperty;
	private BooleanProperty includeDigitsProperty;
	private BooleanProperty lowerCaseLettersProperty;
	private BooleanProperty upperCaseLettersProperty;
	
	private PasswordGenerator generator;
	
	public PasswordGeneratorViewModel() {
		this.minLengthProperty = new SimpleStringProperty();
		this.outputProperty = new SimpleStringProperty();
		this.includeDigitsProperty = new SimpleBooleanProperty();
		this.lowerCaseLettersProperty = new SimpleBooleanProperty();
		this.upperCaseLettersProperty = new SimpleBooleanProperty();
		this.generator = new PasswordGenerator((new Random()).nextLong());
		
	}
	
	/**
	 * @return the lengthProperty
	 */
	public StringProperty getMinLengthProperty() {
		return minLengthProperty;
	}

	/**
	 * @return the outputProperty
	 */
	public StringProperty getOutputProperty() {
		return outputProperty;
	}

	/**
	 * @return the includeDigitsProperty
	 */
	public BooleanProperty getIncludeDigitsProperty() {
		return includeDigitsProperty;
	}

	/**
	 * @return the lowerCaseLettersProperty
	 */
	public BooleanProperty getLowerCaseLettersProperty() {
		return this.lowerCaseLettersProperty;
	}

	/**
	 * @return the upperCaseLettersProperty
	 */
	public BooleanProperty getUpperCaseLettersProperty() {
		return this.upperCaseLettersProperty;
	}
	
	public String generatePassword() {
		try {
			int minLength = Integer.parseInt(this.minLengthProperty.getValue());
			this.generator.setMinimumLength(minLength);
			this.generator.setMustHaveAtLeastOneDigit(this.includeDigitsProperty.getValue());
			this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.lowerCaseLettersProperty.getValue());
			this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.upperCaseLettersProperty.getValue());
			return this.generator.generatePassword();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException();
		}
	}
}
