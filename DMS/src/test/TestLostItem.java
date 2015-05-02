package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import background.LostItem;
import background.Student;

public class TestLostItem extends TestCase {
	private LostItem item;
	private Date entryDate;
	
	@Override
	protected void setUp() throws Exception {
		item = new LostItem();
		super.setUp();
	}
	
	@Test
	public void testLostItemID() {
		item.setLostID(123123123);
		assertEquals(123123123, item.getLostID());
	}
	
	@Test
	public void testLostItemIDZero() {
		item.setLostID(0);
		assertEquals(0, item.getLostID());
	}
	
	@Test
	public void testLostItemNote() {
		item.setLostNote("kafeteryada kimlik bulundu");
		assertEquals("kafeteryada kimlik bulundu", item.getLostNote());
	}
	
	@Test
	public void testLostItemEmptyNote() {
		item.setLostNote("");
		assertEquals("", item.getLostNote());
	}
	
	@Test
	public void testLostItemBlankNote() {
		item.setLostNote(" ");
		assertEquals(" ", item.getLostNote());
	}
	
	@Test
	public void testLostItemStatus() {
		item.setLostStatus("in progress");
		assertEquals("in progress", item.getLostStatus());
	}
	
	@Test
	public void testLostItemEmptyStatus() {
		item.setLostStatus("");
		assertEquals("", item.getLostStatus());
	}
	
	@Test
	public void testLostItemBlankStatus() {
		item.setLostStatus(" ");
		assertEquals(" ", item.getLostStatus());
	}
	
	@Test
	public void testLostItemDormName() {
		item.setLostDorm("Dorm 1");
		assertEquals("Dorm 1", item.getLostDorm());
	}
	
	@Test
	public void testLostItemEmptyDormName() {
		item.setLostDorm("");
		assertEquals("", item.getLostDorm());
	}
	
	@Test
	public void testLostItemBlankDormName() {
		item.setLostDorm(" ");
		assertEquals(" ", item.getLostDorm());
	}
	
	@Test
	public void testLostItemEntryDate() {
		entryDate = new Date(12 / 12 / 2000);
		item.setLostDate(entryDate);
	}
	
	@Test
	public void testLostItemEntryDateDash() {
		entryDate = new Date(12-12-2000);
		item.setLostDate(entryDate);
	}
	
	@Test
	public void testBirthdayComma() {
		entryDate = new Date(12, 12, 2000);
		item.setLostDate(entryDate);
		assertEquals(entryDate, item.getLostDate());
	}
	
	@Test
	public void testBirthdayDash() {
		entryDate = new Date(12/12/2000);
		item.setLostDate(entryDate);
		assertEquals(entryDate, item.getLostDate());
	}
	
	@Test
	public void testBirthday() {
		entryDate = new Date(12-12-2000);
		item.setLostDate(entryDate);
		assertEquals(entryDate, item.getLostDate());
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