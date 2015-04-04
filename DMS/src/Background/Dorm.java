package background;

public class Dorm {
	private String dormName;
	private String location;

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

}