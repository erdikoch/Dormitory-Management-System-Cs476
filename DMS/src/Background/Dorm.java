package background;

import java.util.Random;


public class Dorm {

	private String dormName;
	private String location;
	private int dormSize;
	private int filledDormSize;
	private int counter;


	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		if(!dormName.equals("") || !dormName.equals(" ")) {
			this.dormName = dormName;
		}
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		if(!location.equals("") || !location.equals(" ")) {
			this.location = location;
		}
	}
	public int getDormSize() {
		return dormSize;
	}

	public int calculateDormSize(int counter){
		this.counter = counter;
		
		//
		//Burada dormun size ý hesaplanacak galiba bu room sayýlarýnýn 
		//içindeki oda sayýlarý toplamý olacaðý için
		// databaseden cekilmesi gerekiyor 
		//
		//

		setDormSize(counter);
		return counter;
	}
	
	private void setDormSize(int dormSize) {
		this.dormSize = dormSize;
	}
	
	public int getFilledDormSize() {
		return filledDormSize;
	}
	public void setFilledDormSize(int filledDormSize) {
		this.filledDormSize = filledDormSize;
		// burada da dolu olan odalardaki kiþi sayýlarý lazým
	}	
}