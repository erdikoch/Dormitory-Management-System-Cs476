package background;

import java.util.Date;

public class ClosedItem {
	private String cName;
	private String cSurname;
	private Date closingDate;
	private int lostItemId;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcSurname() {
		return cSurname;
	}

	public void setcSurname(String cSurname) {
		this.cSurname = cSurname;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public int getLostItemId() {
		return lostItemId;
	}

	public void setLostItemId(int lostItemId) {
		this.lostItemId = lostItemId;
	}
}
