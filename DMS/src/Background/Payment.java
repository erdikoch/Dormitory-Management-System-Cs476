package background;

public class Payment {
	private double remainingDebt;
	private String paymentType;
	private double disbursement;

	public Payment() {
		this.remainingDebt = 0;
	}

	public Payment(double amount) {
		if (amount >= 0) {
			this.remainingDebt = amount;
		}
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public double getDisbursement() {
		return disbursement;
	}

	public void setDisbursement(double disbursement) {
		this.disbursement = disbursement;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getRemainingDebt() {
		return this.remainingDebt;
	}

	public void setRemainingDebt(double amount) {
		if (amount >= 0) {
			this.remainingDebt = amount;
		}
	}

	public String paymentDetails() {
		return "This amount is " + remainingDebt;
	}
}
