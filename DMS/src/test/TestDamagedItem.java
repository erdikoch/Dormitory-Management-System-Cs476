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
	public void testDamagedItemUpperCaseName() {
		damagedItem.setDamagedName("NAME");
		assertEquals("NAME", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemLowerCaseName() {
		damagedItem.setDamagedName("name");
		assertEquals("name", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemNumberName() {
		damagedItem.setDamagedName("123");
		assertEquals("123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemTwoWordsName() {
		damagedItem.setDamagedName("word word");
		assertEquals("word word", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemWordNumberName() {
		damagedItem.setDamagedName("word 123");
		assertEquals("word 123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testNote() {
		damagedItem.setDamagedNote("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234");
		assertEquals("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234", damagedItem.getDamagedNote());
	}
	
	@Test
	public void testEmptyNote() {
		damagedItem.setDamagedNote("");
		assertEquals("", damagedItem.getDamagedNote());
	}
	
	@Test
	public void testBlankNote() {
		damagedItem.setDamagedNote(" ");
		assertEquals(" ", damagedItem.getDamagedNote());
	}
	
	@Test
	public void testDormName() {
		damagedItem.setDamagedDorm("dorm1");
		assertEquals("dorm1", damagedItem.getDamagedDorm());
	}
	
	@Test
	public void testDormIntegerName() {
		damagedItem.setDamagedDorm("123");
		assertEquals("123", damagedItem.getDamagedDorm());
	}
}