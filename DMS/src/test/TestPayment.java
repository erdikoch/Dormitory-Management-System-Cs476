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
		payment.setAmount(100.00);
		assertEquals(100.00, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetNegativeAmount() {
		payment.setAmount(-100.00);
		assertEquals(-100.00, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetZeroAmount() {
		payment.setAmount(0);
		assertEquals(0, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetLongDigitAmount() {
		payment.setAmount(100000000.00);
		assertEquals(100000000.00, payment.getAmount());
	}
}