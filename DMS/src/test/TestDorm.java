package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.Dorm;

public class TestDorm {
	private Dorm dorm;

	@Test
	public void testDormName() {
		dorm = new Dorm();
		dorm.setDormName("NazlÄ±'s Home");
		assertEquals("NazlÄ±'s Home", dorm.getDormName());
	}

	@Test
	public void testDormNameEmpty() {
		dorm = new Dorm();
		dorm.setDormName("");
		assertEquals("", dorm.getDormName());
	}

	@Test
	public void testDormNameBlank() {
		dorm = new Dorm();
		dorm.setDormName(" ");
		assertEquals(" ", dorm.getDormName());
	}

	@Test
	public void testDormLocation() {
		dorm = new Dorm();
		dorm.setLocation("Cekmekoy");
		assertEquals("Cekmekoy", dorm.getLocation());
	}

	@Test
	public void testDormLocationEmpty() {
		dorm = new Dorm();
		dorm.setLocation("");
		assertEquals("", dorm.getLocation());
	}

	@Test
	public void testDormLocationBlank() {
		dorm = new Dorm();
		dorm.setLocation(" ");
		assertEquals(" ", dorm.getLocation());
	}

	@Test
	public void testDormLocationLength() {
		equals(dorm.getLocation().length() < 100);
	}

	@Test
	public void testFilledDormSize() {
		dorm = new Dorm();
		dorm.setFilledDormSize(100);
		assertEquals(100, dorm.getLocation());
	}

	@Test
	public void testFilledDormSizeMinus() {
		dorm = new Dorm();
		dorm.setFilledDormSize(-100);
		assertEquals(-100, dorm.getLocation());
	}

	@Test
	public void testFilledDormSizeZero() {
		dorm = new Dorm();
		dorm.setFilledDormSize(0);
		assertEquals(0, dorm.getLocation());
	}

	@Test
	public void testFilledDormSizeBigInteger() {
		dorm = new Dorm();
		dorm.setFilledDormSize(1000000000);
		assertEquals(1000000000, dorm.getLocation());
	}
}
