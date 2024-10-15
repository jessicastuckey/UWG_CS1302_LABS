package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**
 * Used for sorting prices of BillItems in ascending order
 * 
 * @author js00547
 * @version Fall 2024
 */
public class BillAscendingPriceComparator implements Comparator<BillItem> {

	@Override
	public int compare(BillItem o1, BillItem o2) {
		return Double.compare(o1.getAmount(), o2.getAmount());
	}
	
	@Override
	public String toString() {
		return "Ascending";
	}

}
