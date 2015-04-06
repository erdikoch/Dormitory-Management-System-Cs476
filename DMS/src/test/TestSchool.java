package test;

import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import org.junit.Test;

import background.School;

public class TestSchool extends TestCase {
	private School school;
	
	@Override
	protected void setUp() throws Exception {
		school = new School();
		super.setUp();
	}

	@Test
	public void testUniversityName() {
		school.setUniName("Ozyegiin University");
		assertEquals("Ozyegiin University",school.getUniName());
	}
	
	@Test
	public void testUniversityNameWithoutUniversity() {
		school.setUniName("Ozyegin");
		assertEquals("Ozyegin",school.getUniName());
	}
	
	@Test
	public void testDepartment() {
		school.setDepartment("Computer Science");
		assertEquals("Computer Science",school.getDepartment());
	}
	
	@Test
	public void testOneDigitGrade() {
		school.setGrade(3);
		assertEquals(3,school.getGrade());
	}
	
	@Test
	public void testGradeZero() {
		school.setGrade(0);
		assertEquals(0,school.getGrade());
	}
	
	@Test
	public void testTwoDigitGrade() {
		school.setGrade(13);
		assertEquals(13,school.getGrade());
	}
	
	@Test
	public void testThreeDigitGrade() {
		school.setGrade(100);
		assertEquals(100, school.getGrade());
	}
	
	@Test
	public void testWrongThreeDigitGrade() {
		school.setGrade(311);
		assertEquals(311,school.getGrade());
	}
	
	@Test
	public void testMinusGrade() {
		school.setGrade(-3);
		assertEquals(-3,school.getGrade());
	}
}