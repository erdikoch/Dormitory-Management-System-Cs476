package background;

import java.util.ArrayList;

public class Room {
	private int typeName;
	private ArrayList<Room> roomList;
	private int roomNo;
	private double roomPrice;

	

	public int getTypeName() {
		return typeName;
	}
	public void setTypeName(int typeName) {
		this.typeName = typeName;
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
	
	public void addRoom(Room room){
		roomList.add(room);
	}
	
	public int getRoomSize(){
		return roomList.size();
	}
	
	
	

}
