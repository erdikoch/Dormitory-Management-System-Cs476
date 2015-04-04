package background;

public class Room {
	private int typeName;
	private int roomNo;
	private double roomPrice;

	public int getTypeName() {
		return typeName;
	}

	public void setTypeName(int typeName) {
		if(typeName > 0 && typeName < 10) {
			this.typeName = typeName;
		}		
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		if(roomNo >= 0) {
			this.roomNo = roomNo;
		}
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		if(roomPrice >= 0) {
			this.roomPrice = roomPrice;
		}
	}
}
