package background;

public class CreditCardPayment extends Payment {

	private String cardName;
	private String expireDate;
	private String creditCardNum;

	public CreditCardPayment(){
		this.cardName="No card name";
		this.expireDate="No expire date";
		this.creditCardNum="No credit card number";
	}

	public CreditCardPayment(String cardName, String expireDate, String creditCardNum){
		this.cardName=cardName;
		this.expireDate=expireDate;
		this.creditCardNum=creditCardNum;
	}

	public void setCardName(String cardName){
		if(!cardName.equals("") || !cardName.equals(" ")) {
			this.cardName=cardName;
		}
	}
	
	public String getCardName() {
		return cardName;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public void setExpireDate(String expireDate){
		this.expireDate=expireDate;
	}

	public void setCreditCardNum(String creditCardNum){
		if(!creditCardNum.equals("") || !creditCardNum.equals(" ")) {
			this.creditCardNum=creditCardNum;
		}
	}
}