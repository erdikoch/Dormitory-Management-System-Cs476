package background;

public class Payment{
	protected double amount;
	protected String paymentType;
	
	
	private static final int CASH = 0;
	private static final int CREDIT_CARD = 1;
	
	
	public Payment(){
		this.amount=0;
	}

	public Payment(double amount){
		if(amount>=0) {
			this.amount=amount;
		}
	}
	
	public String getPaymentType() {
		return this.paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}	

	public double getAmount(){
		return this.amount;	
	}

	public void setAmount(double amount){
		if(amount >= 0) {
			this.amount=amount;
		}
	}

	public String paymentDetails(){
		return "This amount is "+amount;
	}
}
