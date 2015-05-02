package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import background.Student;

public class TestStudent extends TestCase {
	private Student student;
	private Date birtdate;

	@Override
	protected void setUp() throws Exception {
		student = new Student();
		super.setUp();
	}
	
	@Test
	public void testName() {
		student = new Student();
		student.setName("KaÄŸan");
		assertEquals("KaÄŸan", student.getName());
	}

	@Test
	public void testSurname() {
		student = new Student();
		student.setSurname("Hergünşen");
		assertEquals("Hergünşen", student.getSurname());
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
		birtdate = new Date(12 - 12 - 2000);
		student.setBirthday(birtdate);
		assertEquals(birtdate, student.getBirthday());
	}

	@Test
	public void testBirthday2() {
		student = new Student();
		birtdate = new Date(12 / 12 / 2000);
		student.setBirthday(birtdate);
		assertEquals(birtdate, student.getBirthday());
	}

	@Test
	public void testBirthday3() {
		student = new Student();
		birtdate = new Date(12, 12, 2000);
		student.setBirthday(birtdate);
		assertEquals(birtdate, student.getBirthday());
	}
}
