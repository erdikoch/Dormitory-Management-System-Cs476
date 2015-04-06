package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import background.Room;

public class TestRoom extends TestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Test
	public void testZeroTypeName() {
		Room room = new Room();
		room.setTypeName(0);
		assertEquals(0, room.getTypeName());
	}
	
	@Test
	public void testTwoIntegerTypeName() {
		Room room = new Room();
		room.setTypeName(10);
		assertEquals(10, room.getTypeName());
	}
	
	@Test
	public void testTypeName() {
		Room room = new Room();
		room.setTypeName(5);
		assertEquals(5, room.getTypeName());
	}
	
	@Test
	public void testMinusTypeName() {
		Room room = new Room();
		room.setTypeName(-1);
		assertEquals(-1, room.getTypeName());
	}
	
	@Test
	public void testLongDigitTypeName() {
		Room room = new Room();
		room.setTypeName(11111111);
		assertEquals(11111111, room.getTypeName());
	}
	
	@Test
	public void testRoomNoZero() {
		Room room = new Room();
		room.setRoomNo(0);
		assertEquals(0, room.getRoomNo());
	}
	
	@Test
	public void testOneDigitRoomNo() {
		Room room = new Room();
		room.setRoomNo(2);
		assertEquals(2, room.getRoomNo());
	}
	
	@Test
	public void testTwoDigitRoomNo() {
		Room room = new Room();
		room.setRoomNo(10);
		assertEquals(10, room.getRoomNo());
	}
	
	@Test
	public void testThreeDigitRoomNo() {
		Room room = new Room();
		room.setRoomNo(100);
		assertEquals(100, room.getRoomNo());
	}
	
	@Test
	public void testFourDigitRoomNo() {
		Room room = new Room();
		room.setRoomNo(1000);
		assertEquals(1000, room.getRoomNo());
	}
	
	@Test
	public void testFourDigitRoomNegative() {
		Room room = new Room();
		room.setRoomNo(-1000);
		assertEquals(-1000, room.getRoomNo());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneDigitRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 6.0);
		assertEquals(6.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRoomPriceNegative() {
		Room room = new Room();
		room.setRoomPrice((double) -6.0);
		assertEquals(-6.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testTwoDigitRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 60.0);
		assertEquals(60.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testThreeDigitRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 600.0);
		assertEquals(600.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLongDigitRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 600000.0);
		assertEquals(600000.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAfterPointRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 600.3232323);
		assertEquals(600.3232323, room.getRoomPrice());
	}
}
