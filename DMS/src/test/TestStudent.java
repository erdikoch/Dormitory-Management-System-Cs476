package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import background.Student;

public class TestStudent {
	private Student student;

	@Test
	public void testName() {
		student = new Student();
		student.setName("Kağan");
		assertEquals("Kağan", student.getName());
	}

	@Test
	public void testName2() {
		student = new Student();
		student.setName("");
		assertEquals("", student.getName());
	}

	@Test
	public void testSurname() {
		student = new Student();
		student.setSurname("Hergünsen");
		assertEquals("Hergünşen", student.getSurname());
	}

	@Test
	public void testSurname2() {
		student = new Student();
		student.setSurname("");
		assertEquals("", student.getSurname());
	}

	@Test
	public void testEmail() {
		student = new Student();
		student.setEmail("erdi.koc@ozu.edu.tr");
		assertEquals("erdi.koc@ozu.edu.tr", student.getEmail());
	}

	@Test
	public void testEmail2() {
		student = new Student();
		student.setEmail("");
		assertEquals("", student.getEmail());
	}

	@Test
	public void testPhone() {
		student = new Student();
		student.setPhone("111-111-1111");
		assertEquals("111-111-1111", student.getPhone());
	}

	@Test
	public void testPhone2() {
		student = new Student();
		student.setPhone("");
		assertEquals("", student.getPhone());
	}

	@Test
	public void testGender() {
		student = new Student();
		student.setGender("M");
		assertEquals("M", student.getGender());
	}

	@Test
	public void testGender2() {
		student = new Student();
		student.setGender("W");
		assertEquals("W", student.getGender());
	}

	@Test
	public void testGender3() {
		student = new Student();
		student.setGender("");
		assertEquals("", student.getGender());
	}

	@Test
	public void testTC() {
		student = new Student();
		student.setTC("28315775468");
		assertEquals("28315775468", student.getTC());
	}

	@Test
	public void testTC2() {
		student = new Student();
		student.setTC("");
		assertEquals("", student.getTC());
	}

	@Test
	public void testBirthday() {
		student = new Student();
		// student.setBirthday("12-12-2000");
		assertEquals("12-12-2000", student.getBirthday());
	}

	@Test
	public void testBirthday2() {
		student = new Student();
		// student.setBirthday("12/12/2000");
		assertEquals("12/12/2000", student.getBirthday());
	}

	@Test
	public void testBirthday3() {
		student = new Student();
		// student.setBirthday("12.12.2000");
		assertEquals("12.12.2000", student.getBirthday());
	}

}
