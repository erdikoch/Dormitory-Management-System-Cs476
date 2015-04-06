package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import background.DamagedItem;

public class TestDamagedItem extends TestCase {
	@Override
	protected void setUp() throws Exception {
		damagedItem = new DamagedItem();
		super.setUp();
	}

	private DamagedItem damagedItem;
	private Date entryDate;
	
	@Test
	public void testEntryDate() {
		entryDate = new Date(12-12-2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testEntryDate2() {
		entryDate = new Date(12/12/2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testEntryDate3() {
		entryDate = new Date(12,12,2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testDamagedItemName() {
		damagedItem.setDamagedName("NAME");
		assertEquals("NAME", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName2() {
		damagedItem.setDamagedName("name");
		assertEquals("name", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName3() {
		damagedItem.setDamagedName("123");
		assertEquals("123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName4() {
		damagedItem.setDamagedName("word word");
		assertEquals("word word", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName5() {
		damagedItem.setDamagedName("word 123");
		assertEquals("word 123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testNote() {
		damagedItem.setDamagedNote("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234");
		assertEquals("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234", damagedItem.getDamagedNote());
	}
	
	@Test
	public void testDormName() {
		damagedItem.setDamagedDorm("dorm1");
		assertEquals("dorm1", damagedItem.getDamagedDorm());
	}
	
	@Test
	public void testDormName2() {
		damagedItem.setDamagedDorm("dorm 1");
		assertEquals("dorm 1", damagedItem.getDamagedDorm());
	}
}