package edu.westga.cs1302.bill.model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public abstract class BillPersistenceManager {

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
	public abstract void saveBillData(Bill bill);

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
	public abstract Bill loadBillData() throws FileNotFoundException, IOException;
}
