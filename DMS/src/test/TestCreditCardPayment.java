package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.CreditCardPayment;

public class TestCreditCardPayment {

	@Test
	public void testCreditCardName() {
		CreditCardPayment creditCardPayment = new CreditCardPayment();
//		creditCardPayment.setcardName("Visa");
		assertEquals("Visa", creditCardPayment.getCardName());
	}
	
	@Test
	public void testEmptyCreditCardName() {
		CreditCardPayment creditCardPayment = new CreditCardPayment();
//		creditCardPayment.setcardName("");
		assertEquals("", creditCardPayment.getCardName());
	}
	
	@Test
	public void testBlankCreditCardName() {
		CreditCardPayment creditCardPayment = new CreditCardPayment();
//		creditCardPayment.setcardName(" ");
		assertEquals(" ", creditCardPayment.getCardName());
	}
	
	

}
