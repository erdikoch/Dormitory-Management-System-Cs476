package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import background.Hostel;

public class TestHostel {

	@Test
	public void testStartDate() {
		Hostel hostel = new Hostel();
		hostel.setStartDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(),hostel.getStartDate());
	}

	@Test
	public void testEndDate() {
		Hostel hostel = new Hostel();
		hostel.setEndDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(),hostel.getEndDate());
	}	
}