package background;

public class Payment{
	protected double remainingDebt;
	protected String paymentType;
	
	
	private static final int CASH = 0;
	private static final int CREDIT_CARD = 1;
	
	
	public Payment(){
		this.remainingDebt=0;
	}

	public Payment(double amount){
		if(amount>=0) {
			this.remainingDebt=amount;
		}
	}
	
	public String getPaymentType() {
		return this.paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}	

	public double getRemainingDebt(){
		return this.remainingDebt;	
	}

	public void setRemainingDebt(double amount){
		if(amount >= 0) {
			this.remainingDebt=amount;
		}
	}

	public String paymentDetails(){
		return "This amount is "+remainingDebt;
	}
}
