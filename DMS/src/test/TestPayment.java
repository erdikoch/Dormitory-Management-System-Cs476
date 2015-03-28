package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.Payment;

public class TestPayment {

	@SuppressWarnings("deprecation")
	@Test
	public void testSetAmount() {
		Payment payment = new Payment();
		payment.setAmount(100.00);
		assertEquals(100.00, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetNegativeAmount() {
		Payment payment = new Payment();
		payment.setAmount(-100.00);
		assertEquals(-100.00, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetZeroAmount() {
		Payment payment = new Payment();
		payment.setAmount(0);
		assertEquals(0, payment.getAmount());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetLongDigitAmount() {
		Payment payment = new Payment();
		payment.setAmount(100000000.00);
		assertEquals(100000000.00, payment.getAmount());
	}
}