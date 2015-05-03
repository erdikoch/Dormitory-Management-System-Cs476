package background;

import java.util.Date;

public class DamagedItem {
	private Date entryDate;
	private String damagedItemName;
	private String status;
	private String note;
	private String dormName;

	public Date getDamagedDate() {
		return entryDate;
	}

	public void setDamagedDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getDamagedName() {
		return damagedItemName;
	}

	public void setDamagedName(String lostItemName) {
		this.damagedItemName = lostItemName;
	}

	public String getDamagedStatus() {
		return status;
	}

	public void setDamagedStatus(String status) {
		this.status = status;
	}

	public String getDamagedNote() {
		return note;
	}

	public void setDamagedNote(String note) {
		this.note = note;
	}

	public String getDamagedDorm() {
		return dormName;
	}

	public void setDamagedDorm(String dormName) {
		this.dormName = dormName;
	}

}
