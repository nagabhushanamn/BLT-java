package com.bank.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TxrStatus {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
