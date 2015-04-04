package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.Room;

public class TestRoom {
	private Room room;

	@Test
	public void testZeroTypeName() {
		room = new Room();
		room.setTypeName(0);
		assertEquals(0, room.getTypeName());
	}

	@Test
	public void testTwoIntegerTypeName() {
		room = new Room();
		room.setTypeName(10);
		assertEquals(10, room.getTypeName());
	}

	@Test
	public void testTypeName() {
		room = new Room();
		room.setTypeName(5);
		assertEquals(5, room.getTypeName());
	}

	@Test
	public void testMinusTypeName() {
		room = new Room();
		room.setTypeName(-1);
		assertEquals(-1, room.getTypeName());
	}

	@Test
	public void testLongDigitTypeName() {
		room = new Room();
		room.setTypeName(11111111);
		assertEquals(11111111, room.getTypeName());
	}

	@Test
	public void testRoomNoZero() {
		room = new Room();
		room.setRoomNo(0);
		assertEquals(0, room.getRoomNo());
	}

	@Test
	public void testOneDigitRoomNo() {
		room = new Room();
		room.setRoomNo(2);
		assertEquals(2, room.getRoomNo());
	}

	@Test
	public void testTwoDigitRoomNo() {
		room = new Room();
		room.setRoomNo(10);
		assertEquals(10, room.getRoomNo());
	}

	@Test
	public void testThreeDigitRoomNo() {
		room = new Room();
		room.setRoomNo(100);
		assertEquals(100, room.getRoomNo());
	}

	@Test
	public void testFourDigitRoomNo() {
		room = new Room();
		room.setRoomNo(1000);
		assertEquals(1000, room.getRoomNo());
	}

	@Test
	public void testFourDigitRoomNegative() {
		room = new Room();
		room.setRoomNo(-1000);
		assertEquals(-1000, room.getRoomNo());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testOneDigitRoomPrice() {
		room = new Room();
		room.setRoomPrice((double) 6.0);
		assertEquals(6.0, room.getRoomPrice());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRoomPriceNegative() {
		room = new Room();
		room.setRoomPrice((double) -6.0);
		assertEquals(-6.0, room.getRoomPrice());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testTwoDigitRoomPrice() {
		room = new Room();
		room.setRoomPrice((double) 60.0);
		assertEquals(60.0, room.getRoomPrice());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThreeDigitRoomPrice() {
		room = new Room();
		room.setRoomPrice((double) 600.0);
		assertEquals(600.0, room.getRoomPrice());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testLongDigitRoomPrice() {
		room = new Room();
		room.setRoomPrice((double) 600000.0);
		assertEquals(600000.0, room.getRoomPrice());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAfterPointRoomPrice() {
		room = new Room();
		room.setRoomPrice((double) 600.3232323);
		assertEquals(600.3232323, room.getRoomPrice());
	}
}
