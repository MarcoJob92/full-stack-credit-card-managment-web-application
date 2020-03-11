package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

public class CreditCard {
	
	private String userName;
	private String number;
	private int limit;
	private int balance;
	
	public CreditCard(String userName, String number, int limit, int balance) {
		this.userName = userName;
		this.number = number;
		this.limit = limit;
		this.balance = balance;
	}
	
	public CreditCard() {}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean checkLuhn10() {
		number = number.replaceAll("[ -]", "");
	    int sum = 0;
	    for (int i=0; i<number.length(); i++){
	    int digit = (int) number.charAt(i) - '0';
	      if (i % 2 == 0) {
	        digit *= 2;
	        if (digit > 9)
	          digit -= 9;
	      }
	      sum += digit;
	    }
	    return (sum % 10) == 0;
	}
	
}
