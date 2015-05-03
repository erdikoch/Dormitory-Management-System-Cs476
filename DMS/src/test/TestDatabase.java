package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import background.ClosedItem;
import background.DamagedItem;
import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.LostItem;
import background.Payment;
import background.Room;
import background.School;
import background.Student;
import database.DBConnection;

public class TestDatabase extends TestCase {

	DBConnection dbConnection = new DBConnection();
	Connection connection;

	@Before
	public void before() {
		try {
			Connection connection = new DBConnection().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getConnectionTest() throws SQLException {

		Assert.assertNotNull(connection);
		Assert.assertTrue(connection.isValid(0));
		connection.close();
	}

	@Test
	public void getDormCapacityTest(Dorm dorm) throws SQLException {
		Connection connection = dbConnection.connect();
		int capacity = dbConnection.getDormCapacity(dorm);
		assertNotNull("Dorm Capacity is Not null", capacity);
		connection.close();
	}

	@Test
	public void getMaleNumberTest(Dorm dorm) throws SQLException {
		Connection connection = dbConnection.connect();
		int maleNumber = dbConnection.getMaleNumber(dorm);
		assertEquals(dorm.getMaleNumber(), maleNumber);
		connection.close();
	}

	@Test
	public void getFemaleNumberTest(Dorm dorm) throws SQLException {
		Connection connection = dbConnection.connect();
		int maleNumber = dbConnection.getMaleNumber(dorm);
		assertEquals(dorm.getFemaleNumber(), maleNumber);
		connection.close();
	}

	@After
	public void after() {
		DBConnection.closeConnection(connection);
	}

	@Test
	public void closeStatementShouldCloseStatement() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnection.closeStatement(statement);
		try {
			assertTrue(statement.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void closeStatementWithNullShouldNotThrow() {
		DBConnection.closeStatement(null);
	}

	@Test
	public void testDormCapacity(Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		int n = conn.getDormCapacity(dorm);
		assertEquals(n, conn.getDormCapacity(dorm));
	}

	@Test
	public void testFemaleNumber(Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		int n = conn.getFemaleNumber(dorm);
		assertEquals(n, conn.getFemaleNumber(dorm));
	}

	@Test
	public void testMaleNumber(Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		int n = conn.getMaleNumber(dorm);
		assertEquals(n, conn.getMaleNumber(dorm));
	}

	@Test
	public void testInsertRoomType(Room room) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertRoomType(room);
		assertEquals(isInserted, conn.insertRoomType(room));
	}

	@Test
	public void testUpdateStudentStatusPassive(Student std) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isUpdated = conn.updateStudentStatusPassive(std);
		assertEquals(isUpdated, conn.updateStudentStatusPassive(std));
	}

	@Test
	public void testInsertDorm(Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertDorm(dorm);
		assertEquals(isInserted, conn.insertDorm(dorm));
	}

	@Test
	public void testInsertRoom(Room room, Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertRoom(room, dorm);
		assertEquals(isInserted, conn.insertRoom(room, dorm));
	}

	@Test
	public void testInsertLostItem(LostItem lostItem) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertLostItem(lostItem);
		assertEquals(isInserted, conn.insertLostItem(lostItem));
	}

	@Test
	public void testInsertDamagedItem(DamagedItem damagedItem)
			throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertDamagedItem(damagedItem);
		assertEquals(isInserted, conn.insertDamagedItem(damagedItem));
	}

	@Test
	public void testInsertClosedItem(ClosedItem closedItem) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertClosedItem(closedItem);
		assertEquals(isInserted, conn.insertClosedItem(closedItem));
	}

	@Test
	public void testInsertPayment(Dorm dorm, Room room, Student std,
			Payment pymt) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertPayment(dorm, room, std, pymt);
		assertEquals(isInserted, conn.insertPayment(dorm, room, std, pymt));
	}

	@Test
	public void testCheckStudentIDCounter(Student std) throws SQLException {
		DBConnection conn = new DBConnection();
		int counter = conn.checkStudentIDCounter(std);
		assertEquals(counter, conn.checkStudentIDCounter(std));
	}

	@Test
	public void testGetRemainingDebt(Student std) throws SQLException {
		DBConnection conn = new DBConnection();
		double counter = conn.getRemainingDebt(std);
		assertEquals(counter, conn.getRemainingDebt(std));
	}

	@Test
	public void testGetStudentNumber(Hostel hostel, Dorm dorm, Room room)
			throws SQLException {
		DBConnection conn = new DBConnection();
		int counter = conn.GetStudentNumber(hostel, dorm, room);
		assertEquals(counter, conn.GetStudentNumber(hostel, dorm, room));
	}

	@Test
	public void testInsertStudent(Student st, EmergencyContact ec, School sc,
			Dorm dorm, Room room, Hostel hostel) throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.insertStudent(st, ec, sc, dorm, room, hostel);
		assertEquals(isInserted,
				conn.insertStudent(st, ec, sc, dorm, room, hostel));
	}

	@Test
	public void testUpdateStudent(Student std, EmergencyContact emg, Dorm dorm,
			Room room, Hostel host, School sch, String Name, String Surname)
			throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.updateStudent(std, emg, dorm, room, host,
				sch, Name, Surname);
		assertEquals(isInserted, conn.updateStudent(std, emg, dorm, room, host,
				sch, Name, Surname));
	}

	@Test
	public void testUpdateHostel(Student std, Dorm dorm, Room room, Hostel host)
			throws SQLException {
		DBConnection conn = new DBConnection();
		boolean isInserted = conn.updateHostel(std, dorm, room, host);
		assertEquals(isInserted, conn.updateHostel(std, dorm, room, host));
	}

	@Test
	public void testGetTotalStudenNumberInDorm(Dorm dorm) throws SQLException {
		DBConnection conn = new DBConnection();
		int counter = conn.getTotalStudenNumberInDorm(dorm);
		assertEquals(counter, conn.getTotalStudenNumberInDorm(dorm));
	}

}
