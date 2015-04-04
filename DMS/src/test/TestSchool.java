package test;

import static org.junit.Assert.*;

import org.junit.Test;

import background.School;

public class TestSchool {
	private School school;

	@Test
	public void testUniversityName() {
		school = new School();
		school.setUniName("Ozyegiin University");
		assertEquals("Ozyegiin University", school.getUniName());
	}

	@Test
	public void testUniversityNameEmpty() {
		school = new School();
		school.setUniName("");
		assertEquals("", school.getUniName());
	}

	@Test
	public void testUniversityNameBlank() {
		school = new School();
		school.setUniName(" ");
		assertEquals(" ", school.getUniName());
	}

	@Test
	public void testUniversityNameWithoutUniversity() {
		school = new School();
		school.setUniName("Ozyegin");
		assertEquals("Ozyegin", school.getUniName());
	}

	@Test
	public void testDepartment() {
		school = new School();
		school.setDepartment("Computer Science");
		assertEquals("Computer Science", school.getDepartment());
	}

	@Test
	public void testDepartmentEmpty() {
		school = new School();
		school.setDepartment("");
		assertEquals("", school.getDepartment());
	}

	@Test
	public void testDepartmentBlank() {
		school = new School();
		school.setDepartment(" ");
		assertEquals(" ", school.getDepartment());
	}

	@Test
	public void testOneDigitGrade() {
		school = new School();
		school.setGrade(3);
		assertEquals(3, school.getGrade());
	}

	@Test
	public void testGradeZero() {
		school = new School();
		school.setGrade(0);
		assertEquals(0, school.getGrade());
	}

	@Test
	public void testTwoDigitGrade() {
		school = new School();
		school.setGrade(13);
		assertEquals(13, school.getGrade());
	}

	@Test
	public void testThreeDigitGrade() {
		school = new School();
		school.setGrade(100);
		assertEquals(100, school.getGrade());
	}

	@Test
	public void testWrongThreeDigitGrade() {
		school = new School();
		school.setGrade(311);
		assertEquals(311, school.getGrade());
	}

	@Test
	public void testMinusGrade() {
		school = new School();
		school.setGrade(-3);
		assertEquals(-3, school.getGrade());
	}

}
