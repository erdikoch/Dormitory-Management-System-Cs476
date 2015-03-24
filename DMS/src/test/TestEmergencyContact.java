package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.EmergencyContact;

public class TestEmergencyContact {

	@Test
	public void testEmergencyContactName() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setName("Gamze");
		assertEquals("Gamze", emergencyContact.getName());
	}
	
	@Test
	public void testEmptyEmergencyContactName() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setName("");
		assertEquals("", emergencyContact.getName());
	}
	
	@Test
	public void testBlankEmergencyContactName() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setName(" ");
		assertEquals(" ", emergencyContact.getName());
	}
	
	@Test
	public void testSurname() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setSurname("Koç");
		assertEquals("Koç", emergencyContact.getSurname());
	}
	
	@Test
	public void testEmptySurname() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setSurname("");
		assertEquals("", emergencyContact.getSurname());
	}
	
	@Test
	public void testBlankSurname() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setSurname(" ");
		assertEquals(" ", emergencyContact.getSurname());
	}
	
	@Test
	public void testNormalPhoneNumber() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("111-111-1111");
		assertEquals("111-111-1111", emergencyContact.getPhone());
	}
	
	@Test
	public void testWrongPhoneNumber() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("111-111");
		assertEquals("111-111", emergencyContact.getPhone());
	}
	
	@Test
	public void testEmptyPhoneNumber() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("");
		assertEquals("", emergencyContact.getPhone());
	}
	
	@Test
	public void testBlankPhoneNumber() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone(" ");
		assertEquals(" ", emergencyContact.getPhone());
	}
	
	@Test
	public void testOneDigitPhoneNumber() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("1");
		assertEquals("1", emergencyContact.getPhone());
	}
	
	@Test
	public void testPhoneNumberWithoutdash() {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("111 11");
		assertEquals("111 11", emergencyContact.getPhone());
	}

}
