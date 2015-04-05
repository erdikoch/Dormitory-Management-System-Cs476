package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.LostItem;

public class TestLostItem {

	@Test
	public void testLostItemName() {
		LostItem item = new LostItem();
		item.setLostName("IPhone");;
		assertEquals("IPhone", item.getLostName());
	}
	
	@Test
	public void testLostItemNameWithTwoWords() {
		LostItem item = new LostItem();
		item.setLostName("IPhone Charge");
		assertEquals("IPhone Charge", item.getLostName());
	}
	
	@Test
	public void testEmptyLostItemName() {
		LostItem item = new LostItem();
		item.setLostName("");
		assertEquals("", item.getLostName());
	}
	
	@Test
	public void testBlankLostItemName() {
		LostItem item = new LostItem();
		item.setLostName(" ");
		assertEquals(" ", item.getLostName());
	}

}