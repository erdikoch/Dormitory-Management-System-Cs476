package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import background.Hostel;

public class TestHostel {
	private Hostel hostel;

	@Test
	public void testStartDate() {
		hostel = new Hostel();
		hostel.setStartDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(), hostel.getStartDate());
	}

	@Test
	public void testEndDate() {
		hostel = new Hostel();
		hostel.setEndDate(Calendar.getInstance().getTime());
		assertEquals(Calendar.getInstance().getTime(), hostel.getEndDate());
	}

}
