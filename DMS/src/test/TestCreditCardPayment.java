package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import background.CreditCardPayment;

public class TestCreditCardPayment extends TestCase {
	private CreditCardPayment creditCardPayment;
	private Date entryDate;

	@Override
	protected void setUp() throws Exception {
		creditCardPayment = new CreditCardPayment();
		super.setUp();
	}

	@Test
	public void testCreditCardName() {
		creditCardPayment.setCardName("Visa");
		assertEquals("Visa", creditCardPayment.getCardName());
	}

	@Test
	public void testEmptyCreditCardName() {
		creditCardPayment.setCardName("");
		assertEquals("", creditCardPayment.getCardName());
	}

	@Test
	public void testBlankCreditCardName() {
		creditCardPayment.setCardName(" ");
		assertEquals(" ", creditCardPayment.getCardName());
	}

	@Test
	public void testRoomPrice() {
		creditCardPayment.setRoomPrice(100);
		assertEquals(100, creditCardPayment.getRoomPrice());
	}

	@Test
	public void testRoomPriceForZero() {
		creditCardPayment.setRoomPrice(0);
		assertEquals(0, creditCardPayment.getRoomPrice());
	}
	
	@Test
	public void testTotalDebt() {
		creditCardPayment.setTotalDebt(100);
		assertEquals(100, creditCardPayment.getTotalDebt());
	}
	
	@Test
	public void testTotalDisbursement() {
		creditCardPayment.setDisbursement(100);
		assertEquals(100, creditCardPayment.getDisbursement());
	}
	

	@Test
	public void testAccomodationTime() {
		entryDate = new Date(12-2-2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@Test
	public void testAccomodationTimeVolume2() {
		entryDate = new Date(12/2/2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAccomodationTimeVolume3() {
		entryDate = new Date(12,2,2015);
		creditCardPayment.setAccomodationTime(entryDate);
		assertEquals(0, creditCardPayment.getDisbursement());
	}
	
	@Test
	public void testRemainingDebt() {
		creditCardPayment.setRemainingDebt(100);
		assertEquals(100, creditCardPayment.getRemainingDebt());
	}
}
