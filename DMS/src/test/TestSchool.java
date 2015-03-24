package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.School;

public class TestSchool {

	@Test
	public void testUniversityName() {
		School school = new School();
		school.setUniName("Ozyegiin University");
		assertEquals("Ozyegiin University",school.getUniName());
	}
	
	@Test
	public void testDepartment() {
		School school = new School();
		school.setDepartment("Computer Science");
		assertEquals("Computer Science",school.getDepartment());
	}
	
	@Test
	public void testGrade() {
		School school = new School();
		school.setGrade(3);
		assertEquals(3,school.getGrade());
	}

}
