package background;

public class CashPayment extends Payment {
	  public CashPayment(){

		}

		@Override public String paymentDetails(){
			return "This cash amount is" + amount;
		}
	}
