package edu.westga.cs1302.bill.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class TSVBillPersistenceManager extends BillPersistenceManager {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException
	 */
	@Override
	public void saveBillData(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("billReceipt cannot be null");
		}

		try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
			String output = bill.getServerName() + "/t";
			for (BillItem currentItem : bill.getItems()) {
				output += currentItem.getName() + "/t" + currentItem.getAmount() + "/t";
			}
			writer.println(output);
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}

	/**
	 * Load the bill!
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 */
	@Override
	public Bill loadBillData() throws FileNotFoundException, IOException {
		Bill bill = new Bill();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			String[] parts = reader.nextLine().strip().split("/t");
			String serverName = parts[0];
			bill.setServerName(serverName);

			try {
				for (int index = 1; index < parts.length; index += 2) {
					String name = parts[index];
					double amount = Double.parseDouble(parts[index + 1]);
					BillItem item = new BillItem(name, amount);
					bill.addItem(item);
				}
			} catch (NumberFormatException numError) {
				throw new IOException("Unable to read grade (was not a valid int) on line ");
			} catch (IllegalArgumentException studentDataError) {
				throw new IOException("Unable to create student, bad name/grade on line ");
			} catch (IndexOutOfBoundsException studentDataError) {
				throw new IOException("Missing either name and/or grade on line ");
			}
		}

		return bill;
	}

	@Override
	public String toString() {
		return "TSV";
	}

}
