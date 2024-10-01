package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;
import edu.westga.cs1302.bill.view.BillTextifier;

public class TestLoadBillData {
	
	@Test
	void testLoadMultipleItems() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Apple", 1.29);
		BillItem item2 = new BillItem("Banana", 0.99);
		BillItem item3 = new BillItem("Chicken", 3.50);
		
		bill.addItem(item1);
		bill.addItem(item2);
		bill.addItem(item3);
		bill.setServerName("Bob");
		
		BillPersistenceManager.saveBillData(bill);
		
		Bill loadedBill = new Bill();
		try {
			loadedBill = BillPersistenceManager.loadBillData();
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
		
		assertEquals(BillTextifier.getText(bill), BillTextifier.getText(loadedBill));
	}
	
	@Test
	void testLoadOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Apple", 1.29);
		
		bill.addItem(item1);
		bill.setServerName("Bill");
		
		BillPersistenceManager.saveBillData(bill);
		
		Bill loadedBill = new Bill();
		try {
			loadedBill = BillPersistenceManager.loadBillData();
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
		
		assertEquals(BillTextifier.getText(bill), BillTextifier.getText(loadedBill));
	}
	
	@Test
	void testLoadEmptyBill() {
		Bill bill = new Bill();
		
		BillPersistenceManager.saveBillData(bill);
		
		Bill loadedBill = new Bill();
		try {
			loadedBill = BillPersistenceManager.loadBillData();
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
		
		assertEquals(BillTextifier.getText(bill), BillTextifier.getText(loadedBill));
	}

}
