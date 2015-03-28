package background;

public class Payment{
	protected double amount;

	public Payment(){
		this.amount=0;
	}

	public Payment(double amount){
		if(amount>=0) {
			this.amount=amount;
		}
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
