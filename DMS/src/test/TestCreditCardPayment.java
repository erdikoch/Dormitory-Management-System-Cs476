package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.CreditCardPayment;

public class TestCreditCardPayment {
	private CreditCardPayment creditCardPayment;

	@Test
	public void testCreditCardName() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setCardName("Visa");
		assertEquals("Visa", creditCardPayment.getCardName());
	}

	@Test
	public void testEmptyCreditCardName() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setCardName("");
		assertEquals("", creditCardPayment.getCardName());
	}

	@Test
	public void testBlankCreditCardName() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setCardName(" ");
		assertEquals(" ", creditCardPayment.getCardName());
	}
}