package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**
 * Used for sorting prices of BillItems in descnending order
 * 
 * @author js00547
 * @version Fall 2024
 */
public class BillDescendingPriceComparator implements Comparator<BillItem> {

	@Override
	public int compare(BillItem o1, BillItem o2) {
		return Double.compare(o2.getAmount(), o1.getAmount());
	}
	
	@Override
	public String toString() {
		return "Descending";
	}

}
