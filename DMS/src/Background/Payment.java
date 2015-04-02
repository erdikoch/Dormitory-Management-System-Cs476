package background;

public class Payment{
	protected double amount;
	protected int paymentType;
	
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
	
	public int getPaymentType() {
		return this.paymentType;
	}
	
	public void setPaymentType() {
		if(paymentType == CASH) 
		{
			CashPayment payment = new CashPayment();
			payment.paymentDetails();		
		} 
		else if(paymentType == CREDIT_CARD) 
		{
			CreditCardPayment payment = new CreditCardPayment();
			payment.paymentDetails();
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
