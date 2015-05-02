package test;

import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import org.junit.Test;

import background.Dorm;

public class TestDorm extends TestCase {
	private Dorm dorm;
	
	@Override
	protected void setUp() throws Exception {
		dorm = new Dorm();
		super.setUp();
	}

	@Test
	public void testDormName() {
		dorm.setDormName("NazlÄ±'s Home");
		assertEquals("NazlÄ±'s Home", dorm.getDormName());
	}

	@Test
	public void testDormNameEmpty() {
		dorm.setDormName("");
		assertEquals("", dorm.getDormName());
	}

	@Test
	public void testDormNameBlank() {
		dorm.setDormName(" ");
		assertEquals(" ", dorm.getDormName());
	}

	@Test
	public void testDormLocation() {
		dorm.setLocation("Cekmekoy");
		assertEquals("Cekmekoy", dorm.getLocation());
	}

	@Test
	public void testDormLocationEmpty() {
		dorm.setLocation("");
		assertEquals("", dorm.getLocation());
	}

	@Test
	public void testDormLocationBlank() {
		dorm.setLocation(" ");
		assertEquals(" ", dorm.getLocation());
	}

	@Test
	public void testDormLocationLength() {
		equals(new Dorm().getLocation().length() < 100);
	}
}