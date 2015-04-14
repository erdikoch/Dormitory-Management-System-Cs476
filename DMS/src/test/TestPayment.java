package test;

import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import org.junit.Test;

import background.Payment;

public class TestPayment extends TestCase {
	private Payment payment;
	
	@Override
	protected void setUp() throws Exception {
		Payment payment = new Payment();
		super.setUp();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetAmount() {
		payment.setRemainingDebt(100.00);
		assertEquals(100.00, payment.getRemainingDebt());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetNegativeAmount() {
		payment.setRemainingDebt(-100.00);
		assertEquals(-100.00, payment.getRemainingDebt());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetZeroAmount() {
		payment.setRemainingDebt(0);
		assertEquals(0, payment.getRemainingDebt());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetLongDigitAmount() {
		payment.setRemainingDebt(100000000.00);
		assertEquals(100000000.00, payment.getRemainingDebt());
	}
}