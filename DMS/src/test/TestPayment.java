package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.Payment;

public class TestPayment {
	private Payment payment;

	@SuppressWarnings("deprecation")
	@Test
	public void testSetAmount() {
		payment = new Payment();
		payment.setAmount(100.00);
		assertEquals(100.00, payment.getAmount());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetNegativeAmount() {
		payment = new Payment();
		payment.setAmount(-100.00);
		assertEquals(-100.00, payment.getAmount());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetZeroAmount() {
		payment = new Payment();
		payment.setAmount(0);
		assertEquals(0, payment.getAmount());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetLongDigitAmount() {
		payment = new Payment();
		payment.setAmount(100000000.00);
		assertEquals(100000000.00, payment.getAmount());
	}
}