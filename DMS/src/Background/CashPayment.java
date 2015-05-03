package background;

import java.util.Date;

public class CashPayment extends Payment {
	private int roomPrice;
	private int totalDebt;
	private double disbursement;
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

	public void setDisbursement(double disbursement) {
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

	public CashPayment() {

	}

	@Override
	public String paymentDetails() {
		return "This cash amount is" + remainingDebt;
	}
}
