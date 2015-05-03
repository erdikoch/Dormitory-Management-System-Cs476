package background;

import java.util.Date;

public class Student {
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String gender;
	private String TC;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals("")) {
			name = "N/A";
		} else if (name.equals(" ")) {
			name = "N/A";
		} else {
			this.name = name;
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname.equals("")) {
			surname = "N/A";
		} else if (name.equals(" ")) {
			surname = "N/A";
		} else {
			this.surname = surname;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (name.equals("")) {
			name = "N/A";
		} else if (name.equals(" ")) {
			name = "N/A";
		} else {
			this.email = email;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.equals("")) {
			phone = "N/A";
		} else if (name.equals(" ")) {
			phone = "N/A";
		} else {
			this.phone = phone;
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;

	}

	public String getTC() {
		return TC;
	}

	public void setTC(String TC) {

		this.TC = TC;
	}

}
