package background;

import java.util.Date;

public class LostItem {
	private Date entryDate;
	private String lostItemName;
	private String status;
	private String note;
	private String dormName;
	
	public String getLostName() {
		return lostItemName;
	}

	public void setLostName(String lostItemName) {
		this.lostItemName = lostItemName;
	}
	
	public String getLostNote() {
		return note;
	}

	public void setLostNote(String note) {
		this.note = note;
	}
	
	public Date getLostDate() {
		return entryDate;
	}

	public void setLostDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public String getLostStatus() {
		return status;
	}
	
	public void setLostStatus(String status) {
		this.status = status;
	}

	public String getLostDorm() {
		return dormName;
	}

	public void setLostDorm(String dormName) {
		this.dormName = dormName;
	}
	
	
	
}
