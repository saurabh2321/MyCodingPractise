package com.saurabh.designpatterns;
//adapter clss
public class BankCustomer extends BankDetails implements CreditCard  {

	@Override
	public void giveBankDetails() {
		setAccHolderName("Saurabh Singh");
		setBankName("HDFC");
		setAccNumber(12345);
		
	}

	@Override
	public String getCreditCard() {
		long accNo = getAccNumber();
		String bank = getBankName();
		String name = getAccHolderName();
		return "The account nbr "+ accNo+"of "+name+"in "
				+bank+"is valid for using the credit card";
	}
	
}
