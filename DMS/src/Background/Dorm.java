package background;

import java.util.ArrayList;


public class Dorm {
	
	private ArrayList<Dorm> dormList;
	
	private String dormName;
	private String location;
	
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
	public void addDorm(Dorm dorm){
		dormList.add(dorm);
	}
	
	public int getDormSize(){
		return dormList.size();
	}
	
}
