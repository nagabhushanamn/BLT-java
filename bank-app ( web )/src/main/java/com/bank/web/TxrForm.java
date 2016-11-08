package com.bank.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TxrForm")
public class TxrForm {
	
	private double amount;
	private String fromAcc;
	private String toAcc;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(String fromAcc) {
		this.fromAcc = fromAcc;
	}
	public String getToAcc() {
		return toAcc;
	}
	public void setToAcc(String toAcc) {
		this.toAcc = toAcc;
	}
	
	

}
