package test;

import junit.framework.TestCase;

import org.junit.Test;

import background.Payment;

public class TestPayment extends TestCase {
	private Payment payment;

	@Override
	protected void setUp() throws Exception {
		payment = new Payment();
		super.setUp();
	}

	@Test
	public void testSetAmount() {
		payment.setRemainingDebt(100.00);
		assertEquals(100.00, payment.getRemainingDebt());
	}

	@Test
	public void testSetNegativeAmount() {
		payment.setRemainingDebt(-100.00);
		assertEquals(-100.00, payment.getRemainingDebt());
	}

	@Test
	public void testSetZeroAmount() {
		payment.setRemainingDebt(0);
		assertEquals(0, payment.getRemainingDebt());
	}

	@Test
	public void testSetLongDigitAmount() {
		payment.setRemainingDebt(100000000.00);
		assertEquals(100000000.00, payment.getRemainingDebt());
	}

	@Test
	public void testBlankPaymentType() {
		payment.setPaymentType(" ");
		;
		assertEquals(" ", payment.getRemainingDebt());
	}

	@Test
	public void testEmptyPaymentType() {
		payment.setPaymentType("");
		;
		assertEquals("", payment.getRemainingDebt());
	}

	@Test
	public void testCreditCardPaymentType() {
		payment.setPaymentType("Credit Card");
		;
		assertEquals("Credit Card", payment.getRemainingDebt());
	}

	@Test
	public void testCashPaymentType() {
		payment.setPaymentType("Cash");
		;
		assertEquals("Cash", payment.getRemainingDebt());
	}
}