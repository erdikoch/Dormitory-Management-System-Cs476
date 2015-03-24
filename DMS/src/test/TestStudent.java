package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.Student;

public class TestStudent {

	@Test
	public void testName() {
		Student student = new Student();
		student.setName("Kağan");
		assertEquals("Kağan", student.getName());
	}

	@Test
	public void testEmptyName() {
		Student student = new Student();
		student.setName("");
		assertEquals("", student.getName());
	}
	
	@Test
	public void testBlankName() {
		Student student = new Student();
		student.setName(" ");
		assertEquals(" ", student.getName());
	}

	@Test
	public void testSurname() {
		Student student = new Student();
		student.setSurname("Hergünsen");
		assertEquals("Hergünşen", student.getSurname());
	}
	
	@Test
	public void testEmptySurname() {
		Student student = new Student();
		student.setSurname("");
		assertEquals("", student.getSurname());
	}
	
	@Test
	public void testBlankSurname() {
		Student student = new Student();
		student.setSurname(" ");
		assertEquals(" ", student.getSurname());
	}
	
	@Test
	public void testEmail() {
		Student student = new Student();
		student.setEmail("erdi.koc@ozu.edu.tr");
		assertEquals("erdi.koc@ozu.edu.tr", student.getEmail());
	}
	
	@Test
	public void testEmailWithoutAt() {
		Student student = new Student();
		student.setEmail("erdi.koc.ozu.edu.tr");
		assertEquals("erdi.koc.ozu.edu.tr", student.getEmail());
	}
	
	@Test
	public void testEmptyEmail() {
		Student student = new Student();
		student.setEmail("");
		assertEquals("", student.getEmail());
	}
	
	@Test
	public void testBlankEmail() {
		Student student = new Student();
		student.setEmail(" ");
		assertEquals(" ", student.getEmail());
	}
	
	@Test
	public void testPhone() {
		Student student = new Student();
		student.setPhone("111-111-1111");
		assertEquals("111-111-1111", student.getPhone());
	}
	
	@Test
	public void testEmptyPhone() {
		Student student = new Student();
		student.setPhone("");
		assertEquals("", student.getPhone());
	}
	
	@Test
	public void testBlankPhone() {
		Student student = new Student();
		student.setPhone(" ");
		assertEquals(" ", student.getPhone());
	}
	
	@Test
	public void testOneDigitPhone() {
		Student student = new Student();
		student.setPhone("1");
		assertEquals("1", student.getPhone());
	}
	
	@Test
	public void testPhoneWithoutDash() {
		Student student = new Student();
		student.setPhone("111 11");
		assertEquals("111 11", student.getPhone());
	}
	
	@Test
	public void testMaleGender() {
		Student student = new Student();
		student.setGender("M");
		assertEquals("M", student.getGender());
	}
	
	@Test
	public void testWomenGender() {
		Student student = new Student();
		student.setGender("W");
		assertEquals("W", student.getGender());
	}
		
	@Test
	public void testEmptyGender() {
		Student student = new Student();
		student.setGender("");
		assertEquals("", student.getGender());
	}
	
	@Test
	public void testBlankGender() {
		Student student = new Student();
		student.setGender(" ");
		assertEquals(" ", student.getGender());
	}
	
	@Test
	public void testNormalTC() {
		Student student = new Student();
		student.setTC("28315775468");
		assertEquals("28315775468", student.getTC());
	}
	
	@Test
	public void testOneDigitTC() {
		Student student = new Student();
		student.setTC("2");
		assertEquals("2", student.getTC());
	}
	
	@Test
	public void testTCLessThanElevenDigit() {
		Student student = new Student();
		student.setTC("283157754");
		assertEquals("283157754", student.getTC());
	}
	
	@Test
	public void testTCMoreThanElevenDigit() {
		Student student = new Student();
		student.setTC("2831577546822222");
		assertEquals("2831577546822222", student.getTC());
	}
	
	@Test
	public void testEmptyTC() {
		Student student = new Student();
		student.setTC("");
		assertEquals("", student.getTC());
	}
	
	@Test
	public void testBlankTC() {
		Student student = new Student();
		student.setTC(" ");
		assertEquals(" ", student.getTC());
	}
	
	@Test
	public void testBirthdayWithDash() {
		Student student = new Student();
		//student.setBirthday("12-12-2000");
		assertEquals("12-12-2000", student.getBirthday());
	}
	
	@Test
	public void testBirthdayWithSlantLine() {
		Student student = new Student();
		//student.setBirthday("12/12/2000");
		assertEquals("12/12/2000", student.getBirthday());
	}
	
	@Test
	public void testBirthdayWithDot() {
		Student student = new Student();
		//student.setBirthday("12.12.2000");
		assertEquals("12.12.2000", student.getBirthday());
	}
	
	@Test
	public void testBirthday() {
		Student student = new Student();
		//student.setBirthday("12.12.2000");
		assertEquals("12.12.2000", student.getBirthday());
	}	
}