package background;

public class LostItem {
	private long lostItemID;
	private String lostItemName;
	private boolean isFounded;
	
	public long getLostItemID() {
		return lostItemID;
	}

	public void setLostItemID(long lostItemID) {
		this.lostItemID = lostItemID;
	}

	public String getLostItemName() {
		return lostItemName;
	}

	public void setLostItemName(String lostItemName) {
		this.lostItemName = lostItemName;
	}

	public boolean isFounded() {
		return isFounded;
	}

	public void setFounded(boolean isFounded) {
		this.isFounded = isFounded;
	}

	public LostItem() {
		
	}
}
