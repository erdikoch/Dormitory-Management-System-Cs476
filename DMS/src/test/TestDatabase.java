/**
 * @author erdi.koc
 */
package test;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.DBConnection;

/**
 * @author erdi.koc
 *
 */
public class TestDatabase {

	  Connection connection;

	    @Before
	    public void before() {
	        try {
			connection = new DBConnection().connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @After
	    public void after() {
	        DBConnection.closeConnection(connection);
	    }

	    @Test
	    public void closeStatementShouldCloseStatement() {
	        Statement statement = null; // null olmayacak !!
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
