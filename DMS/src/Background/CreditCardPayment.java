package background;

import java.util.Date;

public class CreditCardPayment extends Payment {
	private String cardName;
	private int roomPrice;
	private int totalDebt;
	private int disbursement;
	private Date accomodationTime;
	private int remainingDebt;

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(int totalDebt) {
		this.totalDebt = totalDebt;
	}

	public double getDisbursement() {
		return disbursement;
	}

	public void setDisbursement(int disbursement) {
		this.disbursement = disbursement;
	}

	public Date getAccomodationTime() {
		return accomodationTime;
	}

	public void setAccomodationTime(Date accomodationTime) {
		this.accomodationTime = accomodationTime;
	}

	public void setRemainingDebt(int remainingDebt) {
		this.remainingDebt = remainingDebt;
	}

	public CreditCardPayment() {
		this.cardName = "No card name";
	}

	public CreditCardPayment(String cardName, String expireDate,
			String creditCardNum) {
		this.cardName = cardName;
	}

	public void setCardName(String cardName) {
		if (!cardName.equals("") || !cardName.equals(" ")) {
			this.cardName = cardName;
		}
	}

	public String getCardName() {
		return cardName;
	}
}