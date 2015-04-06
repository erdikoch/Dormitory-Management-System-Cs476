package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.Dorm;

public class TestDorm {

	@Test
	public void testDormName() {
		Dorm dorm = new Dorm();
		dorm.setDormName("NazlÄ±'s Home");
		assertEquals("NazlÄ±'s Home", dorm.getDormName());
	}

	@Test
	public void testDormNameEmpty() {
		Dorm dorm = new Dorm();
		dorm.setDormName("");
		assertEquals("", dorm.getDormName());
	}

	@Test
	public void testDormNameBlank() {
		Dorm dorm = new Dorm();
		dorm.setDormName(" ");
		assertEquals(" ", dorm.getDormName());
	}

	@Test
	public void testDormLocation() {
		Dorm dorm = new Dorm();
		dorm.setLocation("Cekmekoy");
		assertEquals("Cekmekoy", dorm.getLocation());
	}

	@Test
	public void testDormLocationEmpty() {
		Dorm dorm = new Dorm();
		dorm.setLocation("");
		assertEquals("", dorm.getLocation());
	}

	@Test
	public void testDormLocationBlank() {
		Dorm dorm = new Dorm();
		dorm.setLocation(" ");
		assertEquals(" ", dorm.getLocation());
	}

	@Test
	public void testDormLocationLength() {
		equals(new Dorm().getLocation().length() < 100);
	}

}
