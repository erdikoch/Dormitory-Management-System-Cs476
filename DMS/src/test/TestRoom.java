package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.Room;

public class TestRoom {

//	@Test
//	public void testTypeName() {
//		Room room = new Room();
//		room.setTypeName("vol");
//		assertEquals("vol", room.getTypeName());
//	}
//	
//	@Test
//	public void testTypeName2() {
//		Room room = new Room();
//		room.setTypeName("");
//		assertEquals("", room.getTypeName());
//	}
//	
//	@Test
//	public void testTypeName3() {
//		Room room = new Room();
//		room.setTypeName(" ");
//		assertEquals(" ", room.getTypeName());
//	}
//	
//	@Test
//	public void testTypeName4() {
//		Room room = new Room();
//		room.setTypeName("asdfghj");
//		assertEquals("asdfghj", room.getTypeName());
//	}
//	
	@Test
	public void testRoomNo() {
		Room room = new Room();
		room.setRoomNo(0);
		assertEquals(0, room.getRoomNo());
	}
	
	@Test
	public void testRoomNo2() {
		Room room = new Room();
		room.setRoomNo(10);
		assertEquals(10, room.getRoomNo());
	}
	
	@Test
	public void testRoomNo3() {
		Room room = new Room();
		room.setRoomNo(100);
		assertEquals(100, room.getRoomNo());
	}
	@Test
	public void testRoomNo4() {
		Room room = new Room();
		room.setRoomNo(1000);
		assertEquals(1000, room.getRoomNo());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testRoomPrice() {
		Room room = new Room();
		room.setRoomPrice((double) 600.0);
		assertEquals(600.0, room.getRoomPrice());
	}

}
