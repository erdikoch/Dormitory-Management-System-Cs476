package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import junit.framework.TestCase;

import org.junit.Test;

import background.Hostel;

public class TestHostel extends TestCase {
	private Hostel hostel;
	
	@Override
	protected void setUp() throws Exception {
		hostel = new Hostel();
		super.setUp();
	}

	@Test
	public void testStartDate() {
		hostel.setStartDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(),hostel.getStartDate());
	}
	
	@Test
	public void testEndDate() {
		hostel.setEndDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(),hostel.getEndDate());
	}
}