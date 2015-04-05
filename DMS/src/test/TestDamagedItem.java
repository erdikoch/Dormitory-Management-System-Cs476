package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import background.DamagedItem;
import background.Room;
import background.Student;

public class TestDamagedItem {
	private DamagedItem damagedItem;
	private Date entryDate;
	
	@Test
	public void testEntryDate() {
		damagedItem = new DamagedItem();
		entryDate = new Date(12-12-2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testEntryDate2() {
		damagedItem = new DamagedItem();
		entryDate = new Date(12/12/2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testEntryDate3() {
		damagedItem = new DamagedItem();
		entryDate = new Date(12,12,2000);
		damagedItem.setDamagedDate(entryDate);
		assertEquals(entryDate, damagedItem.getDamagedDate());
	}
	
	@Test
	public void testDamagedItemName() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedName("NAME");
		assertEquals("NAME", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName2() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedName("name");
		assertEquals("name", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName3() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedName("123");
		assertEquals("123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName4() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedName("word word");
		assertEquals("word word", damagedItem.getDamagedName());
	}
	
	@Test
	public void testDamagedItemName5() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedName("word 123");
		assertEquals("word 123", damagedItem.getDamagedName());
	}
	
	@Test
	public void testNote() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedNote("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234");
		assertEquals("asdfghj asdfghjkl dfghjkl mnbvcc uýyasdbh 1234", damagedItem.getDamagedNote());
	}
	
	@Test
	public void testDormName() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedDorm("dorm1");
		assertEquals("dorm1", damagedItem.getDamagedDorm());
	}
	
	@Test
	public void testDormName2() {
		damagedItem = new DamagedItem();
		damagedItem.setDamagedDorm("dorm 1");
		assertEquals("dorm 1", damagedItem.getDamagedDorm());
	}
}
