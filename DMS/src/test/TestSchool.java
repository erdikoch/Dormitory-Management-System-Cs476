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
	public void testEmptyUniversityName() {
		School school = new School();
		school.setUniName("");
		assertEquals("",school.getUniName());
	}

	@Test
	public void testBlankUniversityName() {
		School school = new School();
		school.setUniName(" ");
		assertEquals(" ",school.getUniName());
	}

	@Test
	public void testUniversityNameWithoutUniversity() {
		School school = new School();
		school.setUniName("Ozyegin");
		assertEquals("Ozyegin",school.getUniName());
	}

	
	@Test
	public void testDepartment() {
		School school = new School();
		school.setDepartment("Computer Science");
		assertEquals("Computer Science",school.getDepartment());
	}
	
	@Test
	public void testBlankDepartment() {
		School school = new School();
		school.setDepartment(" ");
		assertEquals(" ",school.getDepartment());
	}
	
	@Test
	public void testEmptyDepartment() {
		School school = new School();
		school.setDepartment("");
		assertEquals("",school.getDepartment());
	}
	
	@Test
	public void testOneDigitGrade() {
		School school = new School();
		school.setGrade(3);
		assertEquals(3,school.getGrade());
	}
	
	@Test
	public void testZeroGrade() {
		School school = new School();
		school.setGrade(0);
		assertEquals(0, school.getGrade());
	}
	
	@Test
	public void testTwoDigitGrade() {
		School school = new School();
		school.setGrade(13);
		assertEquals(13,school.getGrade());
	}
	
	@Test
	public void testThreeDigitGrade() {
		School school = new School();
		school.setGrade(100);
		assertEquals(100,school.getGrade());
	}
	
	@Test
	public void testWrongThreeDigitGrade() {
		School school = new School();
		school.setGrade(120);
		assertEquals(120, school.getGrade());
	}
	
	@Test
	public void testMinusGrade() {
		School school = new School();
		school.setGrade(-12);
		assertEquals(-12, school.getGrade());
	}
}