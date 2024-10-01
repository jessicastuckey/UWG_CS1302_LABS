package edu.westga.cs1302.bill.model;

import java.io.IOException;
import java.io.PrintWriter;

/** Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {
	
	public static final String DATA_FILE = "data.txt";
	
	/** Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException 
	 */
	public static void saveBillData(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("billReceipt cannot be null");
		}

		try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
			String output = bill.getServerName() + ",";
				for (BillItem currentItem : bill.getItems()) {
					output += currentItem.getName() + "," + currentItem.getAmount() + ",";
				}
			writer.println(output);
		} catch (IOException writerException) {
			System.out.print("Failed to write to file");
		}
	}

	/** Load the bill!
	 * 
	 * Reads from DATA_FILE
	 * File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 */
	public static Bill loadBillData() {
		return null;
	}

}
