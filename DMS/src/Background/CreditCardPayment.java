package background;

public class CreditCardPayment extends Payment {

	private String cardName;

	public CreditCardPayment(){
		this.cardName="No card name";
	}

	public CreditCardPayment(String cardName, String expireDate, String creditCardNum){
		this.cardName=cardName;
	}

	public void setCardName(String cardName){
		if(!cardName.equals("") || !cardName.equals(" ")) {
			this.cardName=cardName;
		}
	}
	
	public String getCardName() {
		return cardName;
	}
}