package background;

import java.util.ArrayList;
import java.util.Random;


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
		dormSize = 500;
		this.dormSize = dormSize;
	}
	public int getFilledDormSize() {
		return filledDormSize;
	}
	public void setFilledDormSize(int filledDormSize) {
		Random random = new Random();
		int Low = 100;
		int High = 500;
		int R = random.nextInt(High-Low) + Low;
		filledDormSize = R;
		this.filledDormSize = filledDormSize;
	}

	
}
