package background;

import java.util.Date;

public class LostItem {
	private Date entryDate;
	private String lostItemName;
	private String status;
	private String note;
	private String dormName;
	
	public String getLostItemName() {
		return lostItemName;
	}

	public void setLostItemName(String lostItemName) {
		this.lostItemName = lostItemName;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getLostItemDate() {
		return entryDate;
	}

	public void setLostItemDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDorm() {
		return dormName;
	}

	public void setDorm(String dormName) {
		this.dormName = dormName;
	}
	
	
	
}
