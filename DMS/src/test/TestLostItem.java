package test;

import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import org.junit.Test;

import background.LostItem;

public class TestLostItem extends TestCase {
	private LostItem item;
	
	@Override
	protected void setUp() throws Exception {
		item = new LostItem();
		super.setUp();
	}

	@Test
	public void testLostItemName() {
		item.setLostName("IPhone");;
		assertEquals("IPhone", item.getLostName());
	}
	
	@Test
	public void testLostItemNameWithTwoWords() {
		item.setLostName("IPhone Charge");
		assertEquals("IPhone Charge", item.getLostName());
	}
	
	@Test
	public void testEmptyLostItemName() {
		item.setLostName("");
		assertEquals("", item.getLostName());
	}
	
	@Test
	public void testBlankLostItemName() {
		item.setLostName(" ");
		assertEquals(" ", item.getLostName());
	}
}