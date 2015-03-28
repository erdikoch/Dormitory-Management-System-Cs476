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

		public void setcardName(String cardName){
			this.cardName=cardName;
		}

		public void setexpireDate(String expireDate){
			this.expireDate=expireDate;
		}

		public void setcreditCardNum(String creditCardNum){
			this.creditCardNum=creditCardNum;
		}

	}
