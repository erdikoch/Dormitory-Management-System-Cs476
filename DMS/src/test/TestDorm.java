package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.Dorm;

public class TestDorm {
	
	@Test
	public void testDormName() {
		Dorm dorm = new Dorm();
		dorm.setDormName("Nazlı's Home");
		assertEquals("Nazlı's Home", dorm.getDormName());
	}
	
	@Test
	public void testDormName2() {
		Dorm dorm = new Dorm();
		dorm.setDormName("");
		assertEquals("", dorm.getDormName());
	}
	
	@Test
	public void testDormName3() {
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
	public void testDormLocationLength() {
		equals(new Dorm().getLocation().length() < 100 );
	}
	
	@Test
	public void testDormSizeZero() {
		Dorm dorm = new Dorm();
		dorm.setDormSize(0);
		assertEquals(0, dorm.getLocation());
	}
	
	@Test
	public void testDormSizeBigInteger() {
		Dorm dorm = new Dorm();
		dorm.setDormSize(1111111111);
		assertEquals(1111111111, dorm.getLocation());
	}
	
	@Test
	public void testDormSizeMinusInteger() {
		Dorm dorm = new Dorm();
		dorm.setDormSize(-4);
		assertEquals(-4, dorm.getLocation());
	}
	
	@Test
	public void testFilledDormSize() {
		Dorm dorm = new Dorm();
		dorm.setFilledDormSize(100);
		assertEquals(100, dorm.getLocation());
	}
	
	@Test
	public void testFilledDormSizeMinus() {
		Dorm dorm = new Dorm();
		dorm.setFilledDormSize(-100);
		assertEquals(-100, dorm.getLocation());
	}
	
	@Test
	public void testFilledDormSizeZero() {
		Dorm dorm = new Dorm();
		dorm.setFilledDormSize(0);
		assertEquals(0, dorm.getLocation());
	}
	
	@Test
	public void testFilledDormSizeBigInteger() {
		Dorm dorm = new Dorm();
		dorm.setFilledDormSize(1000000000);
		assertEquals(1000000000, dorm.getLocation());
	}
}