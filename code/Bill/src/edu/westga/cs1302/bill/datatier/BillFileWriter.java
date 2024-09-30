package edu.westga.cs1302.bill.datatier;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creates a file writer for GUI
 * 
 * @author JS
 * @version Fall 2024
 */

public class BillFileWriter {
	private File billFile;

	/**
	 * Creates file writer
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param file the file to write on
	 * 
	 * @throws IllegalArgumentException is file is null
	 */

	public BillFileWriter(File file) {
		if (file == null) {
			throw new IllegalArgumentException("file cannot be null");
		}
		this.billFile = file;
	}

	/** Writes the parameter into the file
	 * 
	 * @param billReceipt the string to be written on the file
	 */

	public void writeFile(String billReceipt) {
		if (billReceipt == null) {
			throw new IllegalArgumentException("billReceipt cannot be null");
		}

		try (PrintWriter writer = new PrintWriter(this.billFile)) {
			writer.println(billReceipt);
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}
}