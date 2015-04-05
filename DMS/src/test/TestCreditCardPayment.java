package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import background.CreditCardPayment;

public class TestCreditCardPayment {
	private CreditCardPayment creditCardPayment;
	private Date entryDate;

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

	@Test
	public void testRoomPrice() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setRoomPrice(100);
		assertEquals(100, creditCardPayment.getRoomPrice());
	}

	@Test
	public void testRoomPriceForZero() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setRoomPrice(0);
		assertEquals(0, creditCardPayment.getRoomPrice());
	}
	
	@Test
	public void testTotalDebt() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setTotalDebt(100);
		assertEquals(0, creditCardPayment.getTotalDebt());
	}
	
	@Test
	public void testTotalDisbursement() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setDisbursement(100);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	

	@Test
	public void testAccomodationTime() {
		creditCardPayment = new CreditCardPayment();
		entryDate = new Date(12-2-2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@Test
	public void testAccomodationTimeVolume2() {
		creditCardPayment = new CreditCardPayment();
		entryDate = new Date(12/2/2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAccomodationTimeVolume3() {
		creditCardPayment = new CreditCardPayment();
		entryDate = new Date(12,2,2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@Test
	public void testRemainingDebt() {
		creditCardPayment = new CreditCardPayment();
		creditCardPayment.setRemainingDebt(100);
		assertEquals(0, creditCardPayment.getRemainingDebt());
	}
	
	

}