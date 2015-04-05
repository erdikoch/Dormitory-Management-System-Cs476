package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.EmergencyContact;

public class TestEmergencyContact {
	private EmergencyContact emergencyContact; 
	
	@Test
	public void testName() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setName("Gamze");
		assertEquals("Gamze", emergencyContact.getName());
	}
	
	@Test
	public void testNameEmpty() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setName("");
		assertEquals("", emergencyContact.getName());
	}
	
	@Test
	public void testNameBlank() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setName(" ");
		assertEquals(" ", emergencyContact.getName());
	}
	
	@Test
	public void testSurname() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setSurname("Koç");
		assertEquals("Koç", emergencyContact.getSurname());
	} 
	
	@Test
	public void testSurnameEmpty() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setSurname("");
		assertEquals("", emergencyContact.getSurname());
	}
	
	@Test
	public void testSurnameBlank() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setSurname(" ");
		assertEquals(" ", emergencyContact.getSurname());
	}
	
	@Test
	public void testPhone() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("111-111-1111");
		assertEquals("111-111-1111", emergencyContact.getPhone());
	}
	
	@Test
	public void testPhoneWithDash() {
		emergencyContact = new EmergencyContact();
		emergencyContact.setPhone("111/111/1111");
		assertEquals("111/111/1111", emergencyContact.getPhone());
	}
}
