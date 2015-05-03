package background;

public class School {
	private String uniName;
	private String department;
	private int grade;

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {

		this.uniName = uniName;

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if (department.equals("")) {
			department = "N/A";
		} else if (department.equals(" ")) {
			department = "N/A";
		} else {
			this.department = department;
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if (grade >= 0 || grade <= 100) {
			this.grade = grade;
		}
	}
}
