package background;

import java.sql.SQLException;

import database.DBConnection;

public class Dorm {
	private String dormName;
	private String location;
	private Dorm dorm;

	public Dorm(Dorm dorm) {
		this.dorm = dorm;
	}

	public Dorm() {

	}

	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		if (!dormName.equals("") || !dormName.equals(" ")) {
			this.dormName = dormName;
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		if (!location.equals("") || !location.equals(" ")) {
			this.location = location;
		}
	}

	public int getMaleNumber() throws SQLException {
		DBConnection connection = new DBConnection();
		connection.connect();
		return connection.getMaleNumber(dorm);
	}

	public Object getFemaleNumber() throws SQLException {
		DBConnection connection = new DBConnection();
		connection.connect();
		return connection.getFemaleNumber(dorm);
	}

}
