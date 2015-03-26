package background;

import java.util.ArrayList;


public class Dorm {
	
	
	private String dormName;
	private String location;
	private int dormSize;
	private int filledDormSize;
	
	
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDormSize() {
		return dormSize;
	}
	public void setDormSize(int dormSize) {
		dormSize+=1;
	}
	public int getFilledDormSize() {
		return filledDormSize;
	}
	public void setFilledDormSize(int filledDormSize) {
		this.filledDormSize = filledDormSize;
	}

	
}
