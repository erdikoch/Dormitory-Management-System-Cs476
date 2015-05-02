package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import background.Room;

public class TestRoom extends TestCase {
	private Room room;
	
	@Override
	protected void setUp() throws Exception {
		room = new Room();
		super.setUp();
	}

	@Test
	public void testZeroTypeName() {
		room.setTypeName(0);
		assertEquals(0, room.getTypeName());
	}
	
	@Test
	public void testTwoIntegerTypeName() {
		room.setTypeName(10);
		assertEquals(10, room.getTypeName());
	}
	
	@Test
	public void testTypeName() {
		room.setTypeName(5);
		assertEquals(5, room.getTypeName());
	}
	
	@Test
	public void testMinusTypeName() {
		room.setTypeName(-1);
		assertEquals(-1, room.getTypeName());
	}
	
	@Test
	public void testLongDigitTypeName() {
		room.setTypeName(11111111);
		assertEquals(11111111, room.getTypeName());
	}
	
	@Test
	public void testRoomNoZero() {
		room.setRoomNo(0);
		assertEquals(0, room.getRoomNo());
	}
	
	@Test
	public void testOneDigitRoomNo() {
		room.setRoomNo(2);
		assertEquals(2, room.getRoomNo());
	}
	
	@Test
	public void testTwoDigitRoomNo() {
		room.setRoomNo(10);
		assertEquals(10, room.getRoomNo());
	}
	
	@Test
	public void testThreeDigitRoomNo() {
		room.setRoomNo(100);
		assertEquals(100, room.getRoomNo());
	}
	
	@Test
	public void testFourDigitRoomNo() {
		room.setRoomNo(1000);
		assertEquals(1000, room.getRoomNo());
	}
	
	@Test
	public void testFourDigitRoomNegative() {
		room.setRoomNo(-1000);
		assertEquals(-1000, room.getRoomNo());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneDigitRoomPrice() {
		room.setRoomPrice((double) 6.0);
		assertEquals(6.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRoomPriceNegative() {
		room.setRoomPrice((double) -6.0);
		assertEquals(-6.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testTwoDigitRoomPrice() {
		room.setRoomPrice((double) 60.0);
		assertEquals(60.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testThreeDigitRoomPrice() {
		room.setRoomPrice((double) 600.0);
		assertEquals(600.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLongDigitRoomPrice() {
		room.setRoomPrice((double) 600000.0);
		assertEquals(600000.0, room.getRoomPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAfterPointRoomPrice() {
		room.setRoomPrice((double) 600.3232323);
		assertEquals(600.3232323, room.getRoomPrice());
	}
	
	@Test
	public void testMonthDiff() {
		room.setMonthDiff(12);
		assertEquals(12, room.getMonthDiff());
	}
	
	@Test
	public void testTotalDebtZero() {
		room.setTotalDebt(0.0);
		assertEquals(0.0, room.getTotalDebt());
	}
	
	@Test
	public void testTotalDebt() {
		room.setTotalDebt(15.275);
		assertEquals(15.275, room.getTotalDebt());
	}
}