package background;

public class EmergencyContact {
	private String name;
	private String surname;
	private String phone;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone.equals("")) {
			phone = "N/A";
		} else if (phone.equals(" ")) {
			phone = "N/A";
		} else {
			this.phone = phone;
		}
	}
}
