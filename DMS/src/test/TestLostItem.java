package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.LostItem;

public class TestLostItem {
	private LostItem lostItem;

	@Test
	public void testLostItemName() {
		lostItem = new LostItem();
		lostItem.setLostName("IPhone");
		;
		assertEquals("IPhone", lostItem.getLostName());
	}

	@Test
	public void testLostItemNameWithTwoWords() {
		lostItem = new LostItem();
		lostItem.setLostName("IPhone Charge");
		assertEquals("IPhone Charge", lostItem.getLostName());
	}

	@Test
	public void testEmptyLostItemName() {
		lostItem = new LostItem();
		lostItem.setLostName("");
		assertEquals("", lostItem.getLostName());
	}

	@Test
	public void testBlankLostItemName() {
		lostItem = new LostItem();
		lostItem.setLostName(" ");
		assertEquals(" ", lostItem.getLostName());
	}

	// @Test
	// public void testLostItemID() {
	// LostItem item = new LostItem();
	// item.setLostItemID(123456789);
	// assertEquals(123456789, item.getLostItemID());
	// }
	//
	// @Test
	// public void testZeroLostItemID() {
	// LostItem item = new LostItem();
	// item.setLostItemID(000000000);
	// assertEquals(000000000, item.getLostItemID());
	// }
	//
	// @Test
	// public void testMinusLostItemID() {
	// LostItem item = new LostItem();
	// item.setLostItemID(-111111111);
	// assertEquals(-111111111, item.getLostItemID());
	// }
}