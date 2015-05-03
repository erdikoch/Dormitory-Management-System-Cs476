package test;

import junit.framework.TestCase;

import org.junit.Test;

import background.EmergencyContact;

public class TestEmergencyContact extends TestCase {
	private EmergencyContact emergencyContact; 
	
	@Override
	protected void setUp() throws Exception {
		emergencyContact = new EmergencyContact();
		super.setUp();
	}
	
	@Test
	public void testName() {
		emergencyContact.setName("Gamze");
		assertEquals("Gamze", emergencyContact.getName());
	}
	
	@Test
	public void testNameEmpty() {
		emergencyContact.setName("");
		assertEquals("", emergencyContact.getName());
	}
	
	@Test
	public void testNameBlank() {
		emergencyContact.setName(" ");
		assertEquals(" ", emergencyContact.getName());
	}
	
	@Test
	public void testSurname() {
		emergencyContact.setSurname("Koç");
		assertEquals("Koç", emergencyContact.getSurname());
	} 
	
	@Test
	public void testSurnameEmpty() {
		emergencyContact.setSurname("");
		assertEquals("", emergencyContact.getSurname());
	}
	
	@Test
	public void testSurnameBlank() {
		emergencyContact.setSurname(" ");
		assertEquals(" ", emergencyContact.getSurname());
	}
	
	@Test
	public void testPhone() {
		emergencyContact.setPhone("111-111-1111");
		assertEquals("111-111-1111", emergencyContact.getPhone());
	}
	
	@Test
	public void testPhoneWithDash() {
		emergencyContact.setPhone("111/111/1111");
		assertEquals("111/111/1111", emergencyContact.getPhone());
	}
}