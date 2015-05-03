package background;

public class Room {
	private int typeName;
	private int roomNo;
	private double roomPrice;
	private int monthDiff;
	private double totalDebt;

	public void setTotalDebt(double totalDebt) {
		this.totalDebt = totalDebt;
	}

	public double getTotalDebt() {
		return totalDebt;
	}

	public int getTypeName() {
		return typeName;
	}

	public void setTypeName(int typeName) {
		this.typeName = typeName;
	}

	public int getMonthDiff() {
		return monthDiff;
	}

	public void setMonthDiff(int monthDiff) {
		this.monthDiff = monthDiff;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPice) {
		this.roomPrice = roomPice;
	}

}
