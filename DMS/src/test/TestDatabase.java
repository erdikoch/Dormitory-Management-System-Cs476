
package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import background.Dorm;
import database.DBConnection;

public class TestDatabase extends TestCase{

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
	public void getConnectionTest() throws SQLException{

		Assert.assertNotNull(connection);
		Assert.assertTrue(connection.isValid(0));
		connection.close();
	}

	@Test
	public void getDormCapacityTest(Dorm dorm) throws SQLException {
		Connection connection = dbConnection.connect();
		int capacity = dbConnection.getDormCapacity(dorm);
		assertNotNull("Dorm Capacity is Not null", capacity);
	}
	
	@Test
	public void getMaleNumberTest(Dorm dorm) throws SQLException{
		Connection connection = dbConnection.connect();
		int maleNumber = dbConnection.getMaleNumber(dorm);
		assertEquals(dorm.getMaleNumber(), maleNumber);
	}
	
	@Test
	public void getFemaleNumberTest(Dorm dorm) throws SQLException{
		Connection connection = dbConnection.connect();
		int maleNumber = dbConnection.getMaleNumber(dorm);
		assertEquals(dorm.getFemaleNumber(), maleNumber);
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

}
